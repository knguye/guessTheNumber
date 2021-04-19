package com.kevinNguyen.GuessTheNumber.dao;

import com.kevinNguyen.GuessTheNumber.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;


@Repository
public class GameDaoDB implements GameDao {
    @Autowired
    public JdbcTemplate jdbc;

    public static final List<Game> games = new ArrayList<>();

    public GameDaoDB(){

    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        // TODO: Add game to DB w/ insert query
        try {
            jdbc.update("INSERT INTO Game(id, answer, status) VALUES (?,?,?)",
                    game.getId(), game.getAnswer(), game.getStatus());
            System.out.println("Add complete");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return game;
    }

    @Override
    public String test(){
        Game game = jdbc.queryForObject("SELECT * FROM game WHERE id = 1", new GameMapper());
        return game.getStatus();
    }

    @Override
    public Game getGameById(int id) {
        // TODO: Retrieve game using id in search query
        try {
            return jdbc.queryForObject("SELECT * FROM Game WHERE id = ?", new GameMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Game> getAllGames() {
        // TODO: retrieve list of games
        return jdbc.query("SELECT * FROM Game", new GameMapper());
        //return new ArrayList<>(games);
    }

    @Override
    public boolean update(Game game) {
        int index = 0;
        while (index < games.size()
                && games.get(index).getId() != game.getId()){
            index++;
        }

        if ( index < games.size() ){
            games.set(index, game);
        }
        return index < games.size();
    }

    @Override
    public boolean deleteById(int id) {
        return games.removeIf(i -> i.getId() == id);
    }
}
