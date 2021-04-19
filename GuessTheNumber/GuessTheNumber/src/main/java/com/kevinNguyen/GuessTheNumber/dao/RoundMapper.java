package com.kevinNguyen.GuessTheNumber.dao;

import com.kevinNguyen.GuessTheNumber.dto.Round;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoundMapper implements RowMapper<Round> {

    @Override
    public Round mapRow(ResultSet rs, int index) throws SQLException {
        Round round = new Round();
        round.setGameId(rs.getInt("gameId"));
        round.setId(rs.getInt("roundId"));
        round.setGuess("e:" + rs.getInt("exactMatches") + ":p:" + rs.getInt("partialMatches"));
        return round;
    }
}
