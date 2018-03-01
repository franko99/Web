$(document).ready(function() {
	$('#person-form').submit(function(event) {
		event.preventDefault();
		enter_person();
	});
});

function enter_person() {
	var person = {};
	person["firstName"] = $("#firstname").val();
	person["lastName"] = $("#lastname").val();
	person["email"] = $("#email").val();
	person["password"] = $("#password").val();
	
	$("#enterPerson").prop("disabled", true);
	
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: '/api/enterPerson',
		data: JSON.stringify(person),
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			var result = "<p>Success</p><pre>"
				+ JSON.stringify(data, null, 4) + "</pre>";
			$("#feedback").html(result);
			$("#enterPerson").prop("disabled", false);
		},
		error: function(e) {
			var result = "<p>Failure</p><pre>"
				+ e.responseText + "</pre>";
			$("#feedback").html(result);
			$("#enterPerson").prop("disabled", false);
		}
	});
};

function delete_person(id) {
	var person = {};
	person["id"] = id;
	
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: '/api/deletePerson',
		data: JSON.stringify(person),
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			var result = "<p>Success</p><pre>"
				+ JSON.stringify(data, null, 4) + "</pre>";
			$("#feedback").html(result);
		},
		error: function(e) {
			var result = "<p>Failure</p><pre>"
				+ e.responseText + "</pre>";
			$("#feedback").html(result);
		}
	});
};