var cust = new Object();

cust.zTreeObj = undefined;

/**
 * main
 */
cust.main = function() {
	cust.loadZtree();
	cust.clickSavebtn();
}

/**
 * load zTree
 */
cust.loadZtree = function() {

	var setting = {
		view : {
			addHoverDom : cust.addHoverDom,
			removeHoverDom : cust.removeHoverDom,
			selectedMulti : false,
			showTitle : false,
			dblClickExpand : false
		},
		edit : {
			enable : true,
			removeTitle : "删除",
			renameTitle : "修改",
			showRemoveBtn : cust.showRemoveBtu,
			showRenameBtn : cust.showRenameBtu,
			drag : {
				isCopy : false,
				isMove : false
			}
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			// before
			beforeClick : function(treeId, treeNode) {
				cust.zTreeObj.expandNode(treeNode, !treeNode.open, false, true);
				return true;
			},
			beforeRemove : function(treeId, treeNode) {
				cust.deleteNode(treeNode.id);
				return false;
			},
			beforeEditName : function(treeId, treeNode, newName, isCancel) {
				cust.updateNode(treeNode.id);
				return false;
			},

			// on
			onClick : function(event, treeId, treeNode) {
				cust.addInfo(treeNode);
			}
		}
	};

	/**
	 * get data;
	 */
	$.ajax({
		url : '../distributor/getTree.do',
		dataType : 'json',
		success : function(data) {
			cust.zTreeObj = $.fn.zTree.init($("#distributorTree"), setting, data);
			$('.scrollable').slimScroll({
				height : '400px',
				width : 'auto'
			});
			cust.addInfo(data[1]);
		}
	});
}

/**
 * mouse moveover
 */
cust.addHoverDom = function(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
		return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='添加' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_" + treeNode.tId);
	if (btn)
		btn.on("click", function() {
			$('#myModalLabel').html('新增分销商');
			$('#distributorForm').attr('action', '../distributor/add.do');
			$('#distributorForm').clearForm();
			$('#inputError').empty();
			$('#parentDis').val(treeNode.name);
			$('#pid').val(treeNode.id);

			$('#myModal').modal({
				'backdrop' : 'static',
				'show' : true,
			});

			return false;
		});
};

/**
 * remove button
 */
cust.showRemoveBtu = function(treeId, treeNode) {

	if (treeNode.id == '0') {
		return false
	} else if (treeNode.isParent) {
		return false
	}

	return true;
}

/**
 * edit button
 */
cust.showRenameBtu = function(treeId, treeNode) {
	if (treeNode.id == '0') {
		return false
	}

	return true;
}

/**
 * mouse moveout
 */
cust.removeHoverDom = function(treeId, treeNode) {
	$("#addBtn_" + treeNode.tId).unbind().remove();
};

/**
 * click save button
 */
cust.clickSavebtn = function() {

	$('#saveBtn').on('click', function() {
		cust.subMitForm();
	})
};

/**
 * submit form
 */
cust.subMitForm = function() {
	$('#distributorForm').ajaxSubmit({
		'dataType' : 'json',
		'resetForm' : true,
		'beforeSubmit' : function(array) {

			if (array[0].value === '') {
				$('#name')[0].focus();
				$('#inputError').html('分销商名称不能为空');
				return false;
			}
			if (array[1].value === '') {
				$('#manager')[0].focus();
				$('#inputError').html('分销商负责人不能为空');
				return false;
			}
			if (array[2].value === '') {
				$('#tel')[0].focus();
				$('#inputError').html('联系电话不能为空');
				return false;
			}
			if (array[3].value === '') {
				$('#addr')[0].focus();
				$('#inputError').html('联系地址不能为空');
				return false;
			}

			return true;

		},
		'success' : function(data) {
			if (data.code != 0) {
				$('#myModal').modal('hide');
				cust.loadZtree();
			}
		},
	});
};

/**
 * delete a distributor
 */
cust.deleteNode = function(id) {

	if (window.confirm('您确定要删除此分销商吗？')) {

		$.ajax({
			'url' : '../distributor/delete/' + id + '.do',
			'type' : 'get',
			'dataType' : 'json',
			'success' : function(data) {
				if (data.code !== 0) {
					cust.loadZtree();
				} else {
					alert(data.msg);
				}
			}
		});
	}
}

/**
 * show update tableb before update a distributor
 */
cust.updateNode = function(id) {

	$('#myModalLabel').html('修改分销商');
	$('#distributorForm').attr('action', '../distributor/update.do');
	$('#inputError').empty();

	$.ajax({
		'url' : '../distributor/get/' + id + '.do',
		'type' : 'get',
		'dataType' : 'json',
		'success' : function(data) {
			if (!data.pPistributor) {
				$('#parentDis').val('全部');
				$('#pid').val('0');
			} else {
				$('#parentDis').val(data.pPistributor.name);
				$('#pid').val(data.pPistributor.id);
			}
			$('#name').val(data.name);
			$('#manager').val(data.manager);
			$('#tel').val(data.tel);
			$('#addr').val(data.addr);
			$('#id').val(data.id);

			$('#myModal').modal({
				'backdrop' : 'static',
				'show' : true,
			});

		}
	});
}

/**
 * load distributor info
 */
cust.addInfo = function(treeNode) {

	if (treeNode) {
		if (treeNode.pId === '0' || treeNode.pId === null) {
			$('#distributorinfo').html('无');
		} else {
			$('#distributorinfo').html(treeNode.pPistributor.name);
			$('#nameinfo').html(treeNode.name);
			$('#managerinfo').html(treeNode.manager);
			$('#telinfo').html(treeNode.tel);
			$('#addrinfo').html(treeNode.addr);
		}
	}
};

/**
 * load main method when thd doucment is already
 */
$(document).ready(function() {
	cust.main();
});