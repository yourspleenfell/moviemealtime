package com.darbuth.moviemealtime.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

	@RequestMapping("/get")
	public String getRecipes() throws Exception {
		Gson g = new Gson();
	    String url = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=52772";
	    URL obj = new URL(url);
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    con.setRequestMethod("GET");
	    con.setRequestProperty("User-Agent", "Mozilla/5.0");
	    BufferedReader in = new BufferedReader(
	    	new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    StringBuffer response = new StringBuffer();
	    while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	    }
	    in.close();
	    String l = g.toJson(response.toString());
	    return l;
//	    JSONObject myResponse = new JSONObject(response.toString());
	}
}