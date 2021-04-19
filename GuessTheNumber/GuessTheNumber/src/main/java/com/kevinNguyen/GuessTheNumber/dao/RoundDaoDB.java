package com.kevinNguyen.GuessTheNumber.dao;

import com.kevinNguyen.GuessTheNumber.dto.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RoundDaoDB implements RoundDao{
    @Autowired
    private JdbcTemplate jdbc;
    private Map<Integer, Round> roundMap;

    public RoundDaoDB(){
        roundMap = new HashMap<Integer, Round>();
    }

    @Override
    public Round addRound(Round round) {
        // TODO: Add round to database
        return null;
    }

    @Override
    public Round getRoundById(int id) {
        try {
            return jdbc.queryForObject("SELECT * FROM Round WHERE id = ?", new RoundMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Round> getAllRoundsById(int gameId) {
        return null;
    }
}
