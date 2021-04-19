package com.kevinNguyen.GuessTheNumber.service;

import com.kevinNguyen.GuessTheNumber.dto.Game;
import com.kevinNguyen.GuessTheNumber.dto.Round;

import java.util.ArrayList;
import java.util.List;

public interface ServiceLayer {

    public void startGame(Game game) throws DuplicateIDException, InvalidAnswerException;

    public String verifyGuess();

    public List<Game> returnListOfGames();

    public Game getGame(int gameId);

    public List<Round> getRounds(int gameId);

    public String test();
}
