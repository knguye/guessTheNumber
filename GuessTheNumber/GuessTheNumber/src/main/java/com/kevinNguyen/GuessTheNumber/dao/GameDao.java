package com.kevinNguyen.GuessTheNumber.dao;

import com.kevinNguyen.GuessTheNumber.dto.Game;

import java.util.List;

public interface GameDao {
    public Game addGame(Game game);
    public Game getGameById(int id);
    public List<Game> getAllGames();
    public String test();
    // true if item exists and is updated
    boolean update(Game game);
    boolean deleteById(int id);
}
