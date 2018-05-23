$(document).ready(function(){
	
	var slideRes = function(movie) {
		var poster = "";
		if (!movie.poster_path) {
			poster = "/img/no_poster.jpeg";
		} else {
			poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" + movie.poster_path;
		}
		$(`
			<div class="card-panel hoverable movieres" id="${movie.id}">
				<div class="inline-div">
					<img src="${poster}" class="poster-sm">
				</div>
				<div class="details">
					<table>
						<tr>
							<td>${movie.title}</td>
						</tr>
						<tr>
							<td>${movie.release_date}</td>
						</tr>
					</table>
				</div>
			</div>
		`).hide().appendTo('#searchResults').slideDown("fast").promise().done();
	};
	
	$('#searchy').submit(function(e) {
		e.preventDefault();
		$.ajax({
			url: "/movies/get?t=" + $("#titleSearch").val()
		}).then(function(data) {
			for (var i = 0; i < 5; i++) {
				slideRes(data.results[i]);
			}
		}, "json");
	});
	
	$(document).on('click', '[class^="card-panel hoverable movieres"]', function() {
		
		$.ajax({
			url: "/movies/show?id=" + $(this).attr('id')
		}).then(function(movie) {
			console.log(movie);
			var poster = "";
			if (!movie.poster_path) {
				poster = "/img/no_poster.jpeg";
			} else {
				poster = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/" + movie.poster_path;
			}
			$('#movieDetails').html(`
				<span class="card-title">
				<h4>${movie.title}</h4>
				<div class="inline-div">
					<img src="${poster}" class="poster-lg">
				</div>
				<div class="details">
					<p>${movie.poster_path}</p>
				</div>
			`)
		});
	});
	
	$('#foodDetails').click(function() {
		$.ajax({
			url: "/recipes/get"
		}).then(function(food) {
			$('#foodDetails').html(`
				<h2>${food}</h2>
			`)
		});
	});

})