$(document).ready(function(){
//	$('#searchResults').click(function() {
////		$.get("http://www.omdbapi.com/?i=tt3896198&apikey=3c57207d", function(res) {
//		alert("hello");
////		});
//	});
	console.log("hello");
//	alert('worked');
	$('#search').on('submit', function(e) {
		e.preventDefault();
		var title = $("input:first").val();
		$.ajax({
			url: "/movies/search?title=" + title
		}).then(function(data) {
			$('#searchResults').append(`<div class="card-panel">${data}</div>`);
		});
	});

	
});