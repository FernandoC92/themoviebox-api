package com.themoviebox.themovieboxapi.models;

import java.util.List;

import org.json.simple.JSONArray;

public class Movie {
    
    private long id;
    private String title;
    private String posterPath;
    private long voteAverage;
    private String overview;
    private JSONArray genreIds;
    private String releaseDate;
    private double popularity;

    public Movie(long id, String title, String posterPath, long voteAverage, String overview, JSONArray genreIds,
			String releaseDate, double popularity) {
		this.id = id;
		this.title = title;
		this.posterPath = posterPath;
		this.voteAverage = voteAverage;
		this.overview = overview;
		this.genreIds = genreIds;
		this.releaseDate = releaseDate;
		this.popularity = popularity;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public long getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(long voteAverage) {
		this.voteAverage = voteAverage;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public JSONArray getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(JSONArray genreIds) {
		this.genreIds = genreIds;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getPopularity() {
		return popularity;
	}

	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}
    
    



}
