var cust = new Object();

cust.dataTable = undefined;

/**
 * main method
 */
cust.main = function() {
	cust.loaddataTable();
};

/**
 * Load dataTable
 */
cust.loaddataTable = function() {
	cust.dataTable = $('.table').DataTable({
		"processing" : true,
		"serverSide" : true,
		"ordering" : false,
		"searching" : false,
		"dom" : 'l<"toolbar">rtip',
		"language" : util.dataTableLanguage(),
		"ajax" : {
			'url' : '../cust/custs.do',
			'dataType' : 'json',
			'type' : 'POST',
			'data' : function(d) {
				return $.extend(d, {
					'name' : $('#search').val()
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
				operationHtml += '<div class="icon-edit icon-blue-color updateBtn  margin-smallR3" title="修改" style="cursor:pointer"></div>';
				operationHtml += '<div class="icon-trash icon-blue-color deleteBtn" title="删除" style="cursor:pointer"></div>';
				operationHtml += '</div>'
				return operationHtml;
			}
		} ],

		'drawCallback' : function(settings) {
			cust.showOrhideOperation();
		},
		'initComplete' : function() {
			cust.addButton();
			cust.searchEvnet();
			cust.clickAddBtn();
		}

	});
};

/**
 * js add add button
 */
cust.addButton = function() {

	var html = "";
	html += "<input type='search' id='search' placeholder='请输入用户名'/>";
	html += "<button class='btn btn-primary' id='searchbtu' style='margin-bottom: 10px; margin-left: 10px;'>查询</button>"
	html += "<button class='btn btn-warning' id='addbtn' style='margin-bottom: 10px; margin-left: 10px;'>新增</button>";
	$('.toolbar').html(html);
};

/**
 * click search button
 */
cust.searchEvnet = function() {
	$('#searchbtu').on('click', function() {
		cust.dataTable.draw();
	});

	$('#search').on('keyup', function(event) {
		if (event.keyCode === 13) {
			cust.dataTable.draw();
		}
	});
}

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
 * click add button
 */
cust.clickAddBtn = function() {
	$('#addbtn').on('click', function() {
		$('#custForm').clearForm();
		$('#myModalLabel').html('新增商户');
		$('#custForm').attr('action', '../cust/add.do');
		
		//TODO 加载select；
		
		$('#myModal').modal({
			'backdrop' : 'static',
			'show' : true
		});

	});
}

/**
 * excute method
 */
cust.main();