var user = new Object();

/**
 * main method
 */
user.main = function() {
	user.dataTable();
}

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

		"drawCallback" : function(settings) {
			user.addButton();
		}

	});
}

/**
 * js add add button
 */
user.addButton = function() {
	var html = "<button class='btn btn-warning' style='margin-bottom:5px'>新增</button>";
	$('.toolbar').html(html);
}

/**
 * excute method
 */
user.main();