/**
 * 
 */

var zTreeObj;var nodes;

var setting = {
	view : {
		addHoverDom : true,
		removeHoverDom : true,
		selectedMulti : false,
		showTitle : false,
		dblClickExpand : false
	},
	edit : {
		enable : true,
		editNameSelectAll : true,
		removeTitle : "删除",
		renameTitle : "修改",
		showRemoveBtn : true,
		showRenameBtn : true
	},
	data : {
		simpleData : {
			enable : true
		}
	},
	callback : {
		onClick : function(event, treeId, treeNode) {

			console.log(treeNode.open);

			treeNode.open = (!treeNode.open);
			console.log(treeNode);

			zTreeObj.refresh();

		}
	}
};

$.ajax({
	url : '../distributor/getTree.do',
	success : function(data) {
		
		nodes = data;
		console.log(nodes)

	}
})

/*var nodes = [ {
	id : 1,
	pId : -1,
	name : "0",
	open : true
}, {
	id : 2,
	pId : 1,
	name : "1"
}, {
	id : 3,
	pId : 1,
	name : "2"
}, {
	id : 11,
	pId : 2,
	name : "11"
}, {
	id : 12,
	pId : 3,
	name : "12"
} ];*/

$(document).ready(function() {
	zTreeObj = $.fn.zTree.init($("#distributorTree"), setting, nodes);

});