package com.kevinNguyen.GuessTheNumber.service;

import com.kevinNguyen.GuessTheNumber.dao.GameDao;
import com.kevinNguyen.GuessTheNumber.dao.RoundDao;
import com.kevinNguyen.GuessTheNumber.dto.Game;
import com.kevinNguyen.GuessTheNumber.dto.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceLayerImpl implements ServiceLayer{
    @Autowired
    public GameDao gameDao;
    @Autowired
    public RoundDao roundDao;

    public ServiceLayerImpl(GameDao gd, RoundDao rd){
        gameDao = gd;
        roundDao = rd;
    }

    public void startGame(Game game) throws DuplicateIDException, InvalidAnswerException{
        // Verify that id is unique in gameMap, check seed too?
        if (gameDao.getGameById(game.getId()) != null){
            throw new DuplicateIDException("A game already exists with the same ID.");
        }

        // Verify that game has 4 digit answer
        if (String.valueOf(game.getAnswer()).length() != 4){
            System.out.println(game.getAnswer());
            throw new InvalidAnswerException("Answer has less or more than 4 digits");
        }

        // Verify that answer has no duplicate digits
        int uniqueDigits =  String.valueOf(game.getAnswer()).chars()
                .mapToObj(c -> c)
                .collect(Collectors.toSet())
                .size();

        // Check if there are 4 UNIQUE digits in the list we created above
        if (uniqueDigits != 4){
            System.out.println(uniqueDigits);
            throw new InvalidAnswerException("Answer has duplicate digits");
        }

        // TODO: Run the DAO
        gameDao.addGame(game);
    }

    @Override
    public String test(){
        return gameDao.test();
    }

    public String verifyGuess(){
        return null;
    }

    public List<Game> returnListOfGames(){
        return gameDao.getAllGames();
    }

    public Game getGame(int gameId){
        return null;
    }

    public List<Round> getRounds(int gameId) {
        return null;
    }
}
