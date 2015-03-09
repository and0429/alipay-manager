var user = new Object();

/**
 * main method
 */
user.main = function() {
	user.dataTable();
};

/**
 * Load dataTable
 */
user.dataTable = function() {
	$('.table').DataTable({
		"processing" : true,
		"serverSide" : true,
		"ordering" : false,
		"searching" : false,
		"dom" : 'l<"toolbar">rtip',
		"language" : util.dataTableLanguage(),
		"ajax" : "../user/users.do",
		"columns" : [ {
			"data" : "distributor.name"
		}, {
			"data" : "username"
		}, {
			"data" : "manager"
		}, {
			"data" : "tel"
		}, {
			"data" : "addr"
		} ],

		'drawCallback' : function(settings) {

		},
		'initComplete' : function() {
			user.addButton();
		}

	});
};

/**
 * js add add button
 */
user.addButton = function() {

	var html = "";
	html += "<input type='search' name='username' placeholder='请输入用户名'/>";
	html += "<button class='btn btn-primary' style='margin-bottom: 10px; margin-left: 10px;'>查询</button>"
	html += "<button class='btn btn-warning' style='margin-bottom: 10px; margin-left: 10px;'>新增</button>";
	$('.toolbar').html(html);
};

/**
 * excute method
 */
user.main();