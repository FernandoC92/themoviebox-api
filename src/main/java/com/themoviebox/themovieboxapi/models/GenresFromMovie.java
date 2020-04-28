package com.themoviebox.themovieboxapi.models;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenresFromMovie {

    public List<Long> listGenres(Long idMovie) throws SQLException {

        List<Long> listGenres = new ArrayList<>();
        String sql = "SELECT * FROM genres WHERE idGenre = ?";
        ResultSet resultQuery;

        PreparedStatement stmt = ConnectionFactory.getConnect().prepareStatement(sql);
        stmt.setLong(1, idMovie);
        resultQuery = stmt.executeQuery();

        while (resultQuery.next()) {
            Long genre = resultQuery.getLong("number");
            listGenres.add(genre);
        }

        return listGenres;

    }

}