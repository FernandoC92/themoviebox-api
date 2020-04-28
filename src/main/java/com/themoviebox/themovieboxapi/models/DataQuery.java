package com.themoviebox.themovieboxapi.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class DataQuery {

    private Connection connection;

    public List<Movie> sortBy(String filterBy) {

        try {
            String sql = "";

            if (filterBy.equals("popularity.desc")) {
                sql = "SELECT * FROM movies ORDER BY popularity DESC;";
            } else if (filterBy.equals("vote_average.desc")) {
                sql = "SELECT * FROM movies ORDER BY voteAverage DESC;";
            } else if(filterBy != null) {
                sql = "SELECT * FROM genres INNER JOIN movies ON genres.idGenre = movies.id WHERE number = " + filterBy + ";";
            }

            Statement stmt = getConnection().createStatement();

            ResultSet result = stmt.executeQuery(sql);
            return generetedList(result);

        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }


    public List<Movie> GetByName(String name) {
        try {
            String sql = "SELECT * FROM movies WHERE title LIKE " + "'%" + name + "%'";
            System.out.println("SQL COMMAND ->" + sql);

            Statement stmt = getConnection().createStatement();
            ResultSet result = stmt.executeQuery(sql);
            return generetedList(result);

       
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    private List<Movie> generetedList(ResultSet result) throws SQLException {

        List<Movie> movies = new ArrayList<>();

        while (result.next()) {

            long id = result.getInt("id");
            String title = result.getString("title");
            String posterPath = result.getString("posterPath");
            double voteAverage = result.getDouble("voteAverage");
            String overview = result.getString("overview");
            String releaseDate = result.getString("releaseDate");
            double popularity = result.getDouble("popularity");

            GenresFromMovie genresFromMovie = new GenresFromMovie();
            List<Long> genreIds = genresFromMovie.listGenres(id);

            movies.add(new Movie(id, title, posterPath, voteAverage, overview, genreIds, releaseDate, popularity));

        }

        return movies;

    }

    private Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            }
        } catch (SQLException e) {

        }
        connection = ConnectionFactory.getConnect();
        return connection;
    } 

}