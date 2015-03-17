var util = new Object();

/**
 * dataTable Lauguage
 */
util.dataTableLanguage = function() {

	return {
		"lengthMenu" : "每页_MENU_条记录",
		"zeroRecords" : "没有数据",
		"infoEmpty" : "0条记录",
		"processing" : "正在处理...",
		"search" : "搜索:",
		"info" : "显示 _START_ 到 _END_ 条，总 _TOTAL_ 条记录",
		"paginate" : {
			"first" : "首页",
			"last" : "末页",
			"next" : "下一页",
			"previous" : "上一页"
		}
	};
};

/**
 * 获取所有的分销商并且生成select元素
 * 
 * @param id
 *            the id of select
 * @param name
 *            the name of select
 * @param calzz
 *            the class of select
 */
util.getAllDistributors = function(id, name, clazz) {

	var selectHtml = "";

	$.ajax({
		'url' : '../distributor/getSelect.do',
		'datType' : 'json',
		'async' : false,
		'success' : function(data, textStatus, jqXHR) {
			selectHtml += "<select id='" + id + "' name='" + name + "' class='" + clazz + "'>";
			selectHtml += "<option value='-1'>请选择分销商</option>";

			for (var i = 0; i < data.length; i++) {
				selectHtml += "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
			}

			selectHtml += "</select>";
		}
	});
	return selectHtml;

}
