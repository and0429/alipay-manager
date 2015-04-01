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
					'custName' : $.trim($('#search').val()) == '' ? undefined : $.trim($('#search').val()),
					'month' : $('#month').val() == '' ? undefined : $('#month').val()
				});
			}
		},
		"columns" : [ {
			"data" : "month"
		}, {
			"data" : "cust.name"
		}, {
			"data" : "total"
		} ],

		"columnDefs" : [ {
			"targets" : 2,
			"render" : function(data, type, full, meta) {
				return data.toFixed(2);
			}
		} ],

		'drawCallback' : function(settings) {

		},
		'initComplete' : function() {
			p4d.addToolbar();
			p4d.clickSearch();
		}
	});
};

/**
 * add toolbar tools
 */
Paymonth4distributor.prototype.addToolbar = function() {
	var html = '';
	html += "<input type='search' id='search' placeholder='请输入名称查询'/>";
	html += "<input type='month' id='month'style='margin-left: 10px;' />";
	html += "<button class='btn btn-primary' id='searchbtu' style='margin-bottom: 10px; margin-left: 10px;'>查询</button>"
	$('.toolbar').html(html);

}

/**
 * search event;
 */
Paymonth4distributor.prototype.clickSearch = function() {
	$('#searchbtu').on('click', function() {
		p4d.dataTable.draw();
	});
}

/**
 * 
 */
$.ready(p4d.main());