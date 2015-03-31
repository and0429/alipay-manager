/**
 * constructor
 */
function Paymonth4distributor() {

}

/**
 * new Object
 */
var p4d = new Paymonth4distributor();

p4d.dataTable = undefined;

/**
 * method main
 */
Paymonth4distributor.prototype.main = function() {
	p4d.loadDataTable();
};

/**
 * load dataTable
 */
Paymonth4distributor.prototype.loadDataTable = function() {
	p4d.dataTable = $('#paymonth4distributorTable').DataTable({
		"processing" : true,
		"serverSide" : true,
		"ordering" : false,
		"searching" : false,
		"dom" : 'l<"toolbar">rtip',
		"language" : util.dataTableLanguage(),
		"ajax" : {
			'url' : '../paymonth4cust/paymonth4custs.do',
			'dataType' : 'json',
			'type' : 'POST',
			'data' : function(d) {
				return $.extend(d, {
					'name' : $.trim($('#search').val()),
					'distributorId' : cust.distributorId
				});
			}
		},
		"columns" : [ {
			"data" : "distributor.name"
		}, {
			"data" : "name"
		}, {
			"data" : "addr"
		}, {
			"data" : "manager"
		}, {
			"data" : "tel"
		}, {
			"data" : "id"
		} ],

		"columnDefs" : [ {
			"targets" : 5,
			"render" : function(data, type, full, meta) {
				var operationHtml = "<div id='operation' style='display: none;'>"
				operationHtml += '<div class="icon-edit icon-blue-color updateBtn  margin-smallR3" title="修改" style="cursor:pointer" custId=' + data + '></div>';
				operationHtml += '<div class="icon-trash icon-blue-color deleteBtn" title="删除" style="cursor:pointer" custId=' + data + '></div>';
				operationHtml += '</div>'
				return operationHtml;
			}
		} ],

		'drawCallback' : function(settings) {
//			cust.showOrhideOperation();
//			cust.clickDelete();
//			cust.clickEdit();
		},
		'initComplete' : function() {
//			cust.addButton();
//			cust.searchEvnet();
//			cust.clickAddBtn();
		}
	});
};

/**
 * 
 */
$.ready(p4d.main());