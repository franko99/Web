$(document).ready(function() {

});

function deselect(e) {
	$('.pop').slideFadeToggle(function() {
		e.removeClass('selected');
	});
}

$(function() {
	$('#contact').on('click', function() {
		if ($(this).hasClass('selected')) {
			deselect($(this));
		} else {
			$(this).addClass('selected');
			$('.pop').slideFadeToggle();
		}
		return false;
	});

	$('.close').on('click', function() {
		deselect($('#contact'));
		return false;
	});
});

$.fn.slideFadeToggle = function(easing, callback) {
	return this.animate({
		opacity : 'toggle',
		height : 'toggle'
	}, 'fast', easing, callback);
};

function delete_product(id) {
	var product = {};
	product["id"] = id;

	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : 'api/deleteProduct',
		data : JSON.stringify(product),
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			var result = "<p>Success</><pre>" + JSON.stringify(data, null, 4)
					+ "</pre>";
			$("#feedback").html(result);
			location.href = "/listProduct";
		},
		error : function(e) {
			var result = "<p>Failure</p><pre>" + e.responseText + "</pre>";
			$("#feedback").html(result);
		}
	});
};