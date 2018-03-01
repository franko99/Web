$(document).ready(function() {
	console.log("Enter Product");
	$('#product-form').submit(function(event) {
		event.preventDefault();
		enter_product();
	});
});

function enter_product() {
	var product = {};
	product["name"] = $('#name').val();
	product["brand"] = $('#brand').val();
	product["wholeSalePrice"] = $('#wholeSalePrice').val();
	product["amount"] = $('#amount').val();
	
	$("#enterProduct").prop("disabled", true);
	
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: 'api/enterProduct',
		data: JSON.stringify(product),
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			var result = "<p>Success</><pre>"
				+ JSON.stringify(data, null, 4) + "</pre>";
			$("#feedback").html(result);
			$("#enterProduct").prop("disabled", false);
			location.href = "/listProduct";
		},
		error: function(e) {
			var result = "<p>Failure</p><pre>"
				+ e.responseText + "</pre>";
			$("#feedback").html(result);
			$("#enterProduct").prop("disabled", false);
		}
	});
};

function delete_product(id) {
	var product = {};
	product["id"] = id;
	
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: 'api/deleteProduct',
		data: JSON.stringify(product),
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			var result = "<p>Success</><pre>"
				+ JSON.stringify(data, null, 4) + "</pre>";
			$("#feedback").html(result);
			location.href = "/listProduct";
		},
		error: function(e) {
			var result = "<p>Failure</p><pre>"
				+ e.responseText + "</pre>";
			$("#feedback").html(result);
		}
	});
};

function refresh_product() {
	console.log("refresh");
	location.href = "/listProduct";
};