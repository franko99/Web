$(document).ready(function() {
	$("#search-form").submit(function(event) {
		event.preventDefault();
		fire_ajax_submit();
	});
});

function fire_ajax_submit() {
	var search = {};
	search["username"] = $("#username").val();
	search["password"] = $("#password").val();
	search["email"] = $("#email").val();
	
	$("#search").prop("disabled", true);
	
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/search",
		data: JSON.stringify(search),
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			var json = "<h4>Ajax response</h4><pre>"
				+ JSON.stringify(data, null, 4) + "</pre>";
			$('#feedback').html(json);
			
			console.log("SUCCESS : ", data);
			$("#search").prop("disabled", false);
		},
		error: function(e) {
			var json = "<h4>Ajax response</h4><pre>"
				+ e.responseText + "</pre>";
			$("#feedback").html(json);
			
			console.log("FAILURE : " , e);
			$("#search").prop("disabled", false);
		}
	});
};