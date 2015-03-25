var payOnlie = new Object();

/**
 * main method
 */
payOnlie.main = function() {
	payOnlie.categorySelect();
}

/**
 * load goods category select
 */
payOnlie.categorySelect = function() {

	$.ajax({
		url : '../goodsCategory/all.do',
		type : 'GET',
		success : function(data) {

			console.log(data);

		}
	});
};

$(document).ready(payOnlie.main());