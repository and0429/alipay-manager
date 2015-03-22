/**
 * create namespace
 */
var loginer = new Object();

loginer.DataTable = undefined;
loginer.zTreeObj = undefined;
loginer.custOrDistributorId = undefined;
loginer.distributorHasChild = undefined;

/**
 * main method
 */
loginer.main = function() {
	loginer.loadZtree();
	loginer.loadDataTable();
	loginer.clickSavebtn();
}

/*-------------------------------------------------------------------------------*/
/**
 * load zTree
 */
loginer.loadZtree = function() {

	var setting = {
		view : {
			selectedMulti : false,
			showTitle : false,
			dblClickExpand : false,
			showLine : false
		},
		edit : {
			enable : false
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			beforeExpand : false,
			beforeClick : function(treeId, treeNode) {
				return true;
			},
			onClick : function(event, treeId, treeNode) {
				loginer.custOrDistributorId = treeNode.id
				loginer.distributorHasChild = treeNode.hasChild
				loginer.DataTable.draw();
				if (treeNode.isParent) {
					$('#addbtn').removeAttr('disabled');
				} else {
					$('#addbtn').attr('disabled', 'disabled');
				}
			}
		}
	};

	/**
	 * get data;
	 */
	$.ajax({
		url : '../login/getZtree.do',
		dataType : 'json',
		success : function(data) {
			loginer.zTreeObj = $.fn.zTree.init($("#distributorTree"), setting, data);
		}
	});
};

/*------------------------------------------------------------------------------------------*/

/**
 * load tables
 */
loginer.loadDataTable = function() {

	loginer.DataTable = $('.table').DataTable({
		"processing" : true,
		"serverSide" : true,
		"ordering" : false,
		"searching" : false,
		"dom" : 'l<"toolbar">rtip',
		"language" : util.dataTableLanguage(),
		"ajax" : {
			'url' : '../login/loginers.do',
			'dataType' : 'json',
			'type' : 'POST',
			'data' : function(d) {
				return $.extend(d, {
					'username' : $.trim($('#search').val()),
					'custOrDistributorId' : loginer.custOrDistributorId
				});
			}
		},

		"columns" : [ {
			"data" : "custOrDistributorName"
		}, {
			"data" : "username"
		}, {
			"data" : "role"
		}, {
			"data" : "id"
		} ],

		"columnDefs" : [ {
			"targets" : 2,
			"render" : function(data, type, full, meta) {
				var result = '无';
				if (data) {
					switch (data) {
					case 1:
						result = '代理商';
						break;
					case 2:
						result = '分销商';
						break;
					case 3:
						result = '商户';
						break;
					}
				}

				return result;
			}
		}, {
			"targets" : 3,
			"render" : function(data, type, full, meta) {
				var operationHtml = "<div id='operation' style='display: none;'>"
				operationHtml += '<div class="icon-edit icon-blue-color updateBtn  margin-smallR3" title="修改" style="cursor:pointer" custId=' + data + '></div>';
				operationHtml += '<div class="icon-trash icon-blue-color deleteBtn" title="删除" style="cursor:pointer" custId=' + data + '></div>';
				operationHtml += '</div>'
				return operationHtml;
			}
		} ],

		'drawCallback' : function(settings) {
			cust.showOrhideOperation();
			// cust.clickDelete();
			// cust.clickEdit();
		},

		'initComplete' : function() {
			loginer.addButton();
			loginer.searchEvnet();
			loginer.clickAddBtn();
		}

	});
};

/**
 * show or hide edit and delete log
 */
cust.showOrhideOperation = function() {
	$('.table tbody').on('mouseover', 'tr', function() {
		$(this).find('#operation').show();
	});
	$('.table tbody').on('mouseout', 'tr', function() {
		$(this).find('#operation').hide();
	});
}

/**
 * click search button
 */
loginer.searchEvnet = function() {
	$('#searchbtu').on('click', function() {
		loginer.DataTable.draw();
	});

	$('#search').on('keyup', function(event) {
		if (event.keyCode === 13) {
			loginer.DataTable.draw();
		}
	});
};

/**
 * add button
 */
loginer.addButton = function() {
	var html = "";
	html += "<input type='search' id='search' placeholder='请输入用户名查询'/>";
	html += "<button class='btn btn-primary' id='searchbtu' style='margin-bottom: 10px; margin-left: 10px;'>查询</button>"
	html += "<button class='btn btn-warning' id='addbtn' disabled='disabled' style='margin-bottom: 10px; margin-left: 10px;'>新增</button>";
	$('.toolbar').html(html);
}

/**
 * click add button
 */
loginer.clickAddBtn = function() {
	$('#addbtn').on('click', function() {
		$('#loginForm').clearForm();
		$('#role').val('1');
		$('#inputError').html('');
		$('#myModalLabel').html('新增用户');
		$('#loginForm').attr('action', '../loginer/add.do');
		$('#distributor').html(util.getLoginerSelect('loginSelect', 'custOrDistributorId', 'myselect', loginer.custOrDistributorId, loginer.distributorHasChild));
		$('#myModal').modal({
			'backdrop' : 'static',
			'show' : true
		});
	});
};

/**
 * click save button
 */
loginer.clickSavebtn = function() {
	$('#saveBtn').on('click', loginer.submitForm);
}

/**
 * submit form and validation
 */
loginer.submitForm = function() {

	$('#loginForm').ajaxSubmit({
		'dataType' : 'json',
		'beforeSubmit' : function(arr, jquery) {

			if (arr[2].value === '') {
				$('#name')[0].focus();
				$('#inputError').html('请填写用户名');
				return false;
			}

			return true;
		},
		'success' : function(data) {
			if (data.code) {
				$('#myModal').modal('hide');
				loginer.DataTable.draw();
			} else {
				$('#inputError').html(data.msg);
			}
		}
	});
};

$(document).ready(loginer.main());