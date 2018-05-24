$(document).ready(function(){
	
	$('#movieDetails').hide();
	$('#foodDetails').hide();
	
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
		$('#searchResults').html(``);
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
			var genres = "";
			if (movie.genres.length > 1) {
				for (var i = 0; i < movie.genres.length; i++) {
					genres = genres + movie.genres[i].name + " ";
				}
			}
			$('#movieDetails').html(`
				<div class="grey darken-1 card-panel white-text">
					<span class="card-title">
					<a class="btn-floating waves-effect waves-light amber right" id="showRecipes"><i class="material-icons">fastfood</i></a>
					<h4>${movie.title}</h4>
					<i>${movie.tagline}</i></span><br>
					<div class="inline-div">
						<img src="${poster}" class="poster-lg">
					</div>
					<div class="details">
						<p><b>Genre(s):</b> ${genres}</p>
						<p><b>Runtime:</b> ${movie.runtime} min</p>
						<p><b>Release Date:</b> ${movie.release_date}</p>
						<p><b>Average Rating:</b> ${movie.vote_average} / 10</p>
						<p><b>Production Company:</b> ${movie.production_companies[0].name}</p>
						<p><b>Overview:</b> ${movie.overview}</p>
					</div>
				</div>
			`).slideDown();
		});
	});
	
	$('#foods').on('click', function() {
		$.ajax({
			url: "/recipes/get"
		}).then(function(food) {
			var f = jQuery.parseJSON(food);
			var fj = JSON.parse(f);
			console.log(fj);
			$('#foodDetails').html(`
				<div class="col m4">
					<div class="card hoverable">
						<div class="card-image waves-efect waves-block waves-light">
							<img class="activator responsive-img" src="${fj.meals[0].strMealThumb}">
						</div>
						<div class="card-content">
							<span class="card-title"></span>
						</div>
						<div class="card-reveal">
							<span class="card-title"></span>
							<p></p>
						</div>
					</div>
				</div>
				<div class="col m4">
					<div class="card hoverable">
						<div class="card-image waves-efect waves-block waves-light">
							<img class="activator responsive-img" src="${fj.meals[0].strMealThumb}">
						</div>
						<div class="card-content">
							<span class="card-title"></span>
						</div>
						<div class="card-reveal">
							<span class="card-title"></span>
							<p></p>
						</div>
					</div>
				</div>
				<div class="col m4">
					<div class="card hoverable">
						<div class="card-image waves-efect waves-block waves-light">
							<img class="activator responsive-img" src="${fj.meals[0].strMealThumb}">
						</div>
						<div class="card-content">
							<span class="card-title"></span>
						</div>
						<div class="card-reveal">
							<span class="card-title"></span>
							<p></p>
						</div>
					</div>
				</div>
			`).slideDown("fast");
		});
	});

})