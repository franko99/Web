$(document).ready(function() {
	$("#search-form").submit(function(event) {
		event.preventDefault();
		fire_ajax_submit();
	});
});

function insert_me(movie) {
	var $row = $(movie).closest('tr');
	var $columns = $row.find('td');
	
	var movie = {};
	movie["title"] = $columns[0].innerHTML;
	movie["year"] = $columns[1].innerHTML;
	movie["imdbID"] = $columns[2].innerHTML;
	
	console.log(movie);
	
//	$.ajax({
//		type: "POST",
//		contentType: "application/json",
//		url: "/api/search/movie",
//		data: JSON.stringify(movie),
//		dataType: 'json',
//		cache: false,
//		timeout: 600000,
//		success: function(data) {
//			console.log("SUCCESS : ", data);
//			$("#btn-search").prop("disabled", false);
//		},
//		error: function(e) {
//			var json = "<h4>AjaxResponse</h4><pre>"
//				+ e.ResponseText + "</pre>";
//			$("#feedback").html(json);
//			
//			console.log("ERROR : ", e);
//			$("#btn-search").prop("disabled", false);
//		}
//	});
};

function fire_ajax_submit() {
	var search = {};
	search["movie"] = $("#movie").val();
	
	var movie = search["movie"].replace(/\s+/g, '+');
	
	var url = "http://www.omdbapi.com/?s=" + movie + "&apikey=f44e9055";
	
	$("#btn-search").prop("disabled", true);
	
	$.ajax({
		type: "POST",
		contentType: "text/plain",
		url: url,
		data: JSON.stringify(search),
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			var movies = {};
			movies["movies"] = [];
			$.each(data.Search, function() {
				var movie = {};
				movie["title"] = this.Title;
				movie["year"] = this.Year;
				movie["imdbID"] = this.imdbID;
				movies["movies"].push(movie);
			});
			
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/api/search/movie",
				data: JSON.stringify(movies),
				dataType: 'json',
				cache: false,
				timeout: 600000,
				success: function(data) {
					console.log("Movies: ");
					console.log("SUCCESS : ", data);
					
					var rows = "";
					var count = 0;
					$.each(data.movies, function() {
						rows += "<tr>";
						rows += "<td>" + this.title + "</td>";
						rows += "<td>" + this.year + "</td>";
						rows += "<td>" + this.imdbID + "</td>";
						rows += "<td><input type='button' value='Insert' id='insertButton' onclick='insert_me(this)' /></td>";
						rows += "</tr>";
					});
					
					var table = "<h4>Results</h4>" +
							"<table class='table' id='resultsTable'><thead><tr><th>Title</th><th>Year</th><th>imdbID</th></tr></thead><tbody>"
						+ rows + "</tbody></table>";
					$("#feedback").html(table);
					$("#btn-search").prop("disabled", false);
				},
				error: function(e) {
					var json = "<h4>AjaxResponse</h4><pre>"
						+ e.ResponseText + "</pre>";
					$("#feedback").html(json);
					
					console.log("ERROR : ", e);
					$("#btn-search").prop("disabled", false);
				}
			});
		},
		error: function(e) {
			var json = "<h4>Error</h4><pre>"
				+ e.ResponseText + "</pre>";
			$("#feedback").html(json);
			
			console.log("ERROR : ", e);
			$("#btn-search").prop("disabled", false);
		}
	});
};