$(document).ready(function(){
	
	$('#movieDetails').hide();
	$('#foods').hide();
	
	$('.modal').modal();
	$('.trigger-modal').modal();
	
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
	
	var inglist = function(meal) {
		var w = "<ul>";
		if (meal.strIngredient1 != null) {
			w = w + "<li>" + meal.strIngredient1 + " " + meal.strMeasure1 + "</li>";
		} 
		if (meal.strIngredient2 != null) {
			w = w + "<li>" + meal.strIngredient2 + " " + meal.strMeasure2 + "</li>";
		} else {
			return w; 
		}
		if (meal.strIngredient3 != null) {
			w = w + "<li>" + meal.strIngredient3 + " " + meal.strMeasure3 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient4 != null) {
			w = w + "<li>" + meal.strIngredient4 + " " + meal.strMeasure4 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient5 != null) {
			w = w + "<li>" + meal.strIngredient5 + " " + meal.strMeasure5 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient6 != null) {
			w = w + "<li>" + meal.strIngredient6 + " " + meal.strMeasure6 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient7 != null) {
			w = w + "<li>" + meal.strIngredient7 + " " + meal.strMeasure7 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient8 != null) {
			w = w + "<li>" + meal.strIngredient8 + " " + meal.strMeasure8 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient9 != null) {
			w = w + "<li>" + meal.strIngredient9 + " " + meal.strMeasure9 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient10 != null) {
			w = w + "<li>" + meal.strIngredient10 + " " + meal.strMeasure10 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient11 != null) {
			w = w + "<li>" + meal.strIngredient11 + " " + meal.strMeasure11 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient12 != null) {
			w = w + "<li>" + meal.strIngredient12 + " " + meal.strMeasure12 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient13 != null) {
			w = w + "<li>" + meal.strIngredient13 + " " + meal.strMeasure13 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient14 != null) {
			w = w + "<li>" + meal.strIngredient14 + " " + meal.strMeasure14 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient15 != null) {
			w = w + "<li>" + meal.strIngredient15 + " " + meal.strMeasure15 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient16 != null) {
			w = w + "<li>" + meal.strIngredient16 + " " + meal.strMeasure16 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient17 != null) {
			w = w + "<li>" + meal.strIngredient17 + " " + meal.strMeasure17 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient18 != null) {
			w = w + "<li>" + meal.strIngredient18 + " " + meal.strMeasure18 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient19 != null) {
			w = w + "<li>" + meal.strIngredient19 + " " + meal.strMeasure19 + "</li>";
		} else {
			return w;
		}
		if (meal.strIngredient20 != null) {
			w = w + "<li>" + meal.strIngredient20 + " " + meal.strMeasure20 + "</li>";
		} else {
			return w;
		}
		w = w + "</ul>";	
		return w;
	};
	
	$('#searchy').submit(function(e) {
		e.preventDefault();
		$('#searchResults').html(``);
		$.ajax({
			url: "/movies/get?t=" + $("#titleSearch").val()
		}).then(function(movies) {
			for (var i = 0; i < movies.length; i++) {
				slideRes(movies[i]);
			}
		}, "json");
	});
	
	$(document).on('click', '[class^="card-panel hoverable movieres"]', function() {
		$('#movieDetails').slideUp("fast").promise().done();
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
			} else {
				genres = movie.genres[0].name;
			}
			var production = "";
			if (movie.production_companies.length == 0) {
				production  = "Not available";
			} else {
				for (var i = 0; i < movie.production_companies.length; i++) {
					production = production + movie.production_companies[i].name + " ";
				}
			}
			$('#movieDetails').html(`
				<div class="grey darken-1 card-panel white-text">
					<span class="card-title">
					<a class="btn-floating waves-effect waves-light amber right" id="showRecipes"><i class="material-icons food" data-movie-id="${movie.id}">fastfood</i></a>
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
						<p><b>Production Company:</b> ${production}</p>
						<p><b>Overview:</b> ${movie.overview}</p>
					</div>
				</div>
			`).slideDown();
		});
	});
	
	$(document).on('click', '[class^="material-icons food"]', function() {
		$('#foods').slideUp("fast").promise().done();
		$.ajax({
			url: "/recipes/meals/" + $(this).attr("data-movie-id")
		}).then(function(foods) {
			var recipes = [];
			for (var i = 0; i < 3; i++) {
				var num = Math.floor(Math.random() * (3 - 1 + 1)) + 1;
				var feds = JSON.parse(jQuery.parseJSON(foods[i]));
				if (i > 0 && recipes.some(item => item.strMeal === feds.meals[num].strMeal)) {
					recipes.push(feds.meals[num + i]);
				} else {
					recipes.push(feds.meals[num]);
				}
			}
			$.get("https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + recipes[0].idMeal, function(rec) {
				var ing = inglist(rec.meals[0]);
				$('#meal1').html(`
					<div class="card hoverable">
						<div class="card-image waves-efect waves-block waves-light">
							<img class="activator responsive-img" src="${rec.meals[0].strMealThumb}">
						</div>
						<div class="card-content">
							<span class="card-title">${rec.meals[0].strMeal}</span>
						</div>
						<div class="card-reveal">
							<span class="card-title"><i class="material-icons right">close</i>${rec.meals[0].strMeal}</span>
							${ing}
							<button  class="btn-flat waves-effect waves-light open-dir" id="${rec.meals[0].idMeal}">View Instructions</button>
						</div>
					</div>
				`).promise().done();
			}, "json");
			$.get("https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + recipes[1].idMeal, function(rec) {
				var ing = inglist(rec.meals[0]);
				$('#meal2').html(`
					<div class="card hoverable">
						<div class="card-image waves-efect waves-block waves-light">
							<img class="activator responsive-img" src="${rec.meals[0].strMealThumb}">
						</div>
						<div class="card-content">
							<span class="card-title">${rec.meals[0].strMeal}</span>
						</div>
						<div class="card-reveal">
							<span class="card-title"><i class="material-icons right">close</i>${rec.meals[0].strMeal}</span>
							${ing}
							<button  class="btn-flat waves-effect waves-light open-dir" id="${rec.meals[0].idMeal}">View Instructions</button>
						</div>
					</div>
				`);
			}, "json");
			$.get("https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + recipes[2].idMeal, function(rec) {
				var ing = inglist(rec.meals[0]);
				$('#meal3').html(`
					<div class="card hoverable">
						<div class="card-image waves-efect waves-block waves-light">
							<img class="activator responsive-img" src="${rec.meals[0].strMealThumb}">
						</div>
						<div class="card-content">
							<span class="card-title">${rec.meals[0].strMeal}</span>
						</div>
						<div class="card-reveal">
							<span class="card-title"><i class="material-icons right">close</i>${rec.meals[0].strMeal}</span>
							${ing}
							<button  class="btn-flat waves-effect waves-light open-dir" id="${rec.meals[0].idMeal}">View Instructions</button>
						</div>
					</div>
				`);
			}, "json");
			$('#foods').slideDown("fast").promise().done();
		});
	});
	
	$(document).on('click', '[class^="btn-flat waves-effect waves-light open-dir"]', function() {
		$.ajax({
			url: "/recipes/get/" + $(this).attr('id')
		}).then(function(recipe) {
			var rec1 = JSON.parse(jQuery.parseJSON(recipe));
			console.log(rec1.meals[0]);
			$('#dirModal').html(`
				<div class="modal-content">
					<h4>${rec1.meals[0].strMeal}</h4>
					<p><b>Instructions: </b>${rec1.meals[0].strInstructions}</p>
				</div>
			`);
		});
		$('#dirModal').modal('open');
	});

})