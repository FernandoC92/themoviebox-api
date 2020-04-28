package com.themoviebox.themovieboxapi.models;

import java.util.List;

public class Movie {
    
    private long id;
    private String title;
    private String posterPath;
	private double voteAverage;
    private String overview;
    private List<Long> genreIds;
    private String releaseDate;
    private double popularity;

	public Movie(long id, String title, String posterPath, double voteAverage, String overview, List<Long> genreIds,
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

	public double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(double voteAverage) {

		this.voteAverage = voteAverage;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public List<Long> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(List<Long> genreIds) {
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
