package com.kevinNguyen.GuessTheNumber.dao;

import com.kevinNguyen.GuessTheNumber.dto.Game;
import com.kevinNguyen.GuessTheNumber.dto.Round;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameMapper implements RowMapper<Game> {
    @Override
    public Game mapRow(ResultSet rs, int index) throws SQLException {
        Game game = new Game();
        game.setId(rs.getInt("id"));
        game.setAnswer(rs.getInt("answer"));
        game.setStatus(rs.getString("status"));

        return game;
    }
}
