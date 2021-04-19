package com.kevinNguyen.GuessTheNumber.controller;


import com.kevinNguyen.GuessTheNumber.dao.GameDaoDB;
import com.kevinNguyen.GuessTheNumber.dto.Game;
import com.kevinNguyen.GuessTheNumber.dto.Round;
import com.kevinNguyen.GuessTheNumber.service.DuplicateIDException;
import com.kevinNguyen.GuessTheNumber.service.InvalidAnswerException;
import com.kevinNguyen.GuessTheNumber.service.ServiceLayer;
import com.kevinNguyen.GuessTheNumber.service.ServiceLayerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    private final ServiceLayer service = new ServiceLayerImpl(new GameDaoDB(), null);

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public ArrayList<String> startGame() throws DuplicateIDException, InvalidAnswerException{

        // TODO: Generate new game object with unique game Id
        Game game = new Game();
        game.generateAnswer();

        // TODO: Send game object to service layer (which then sends to DAO)
        try {
            service.startGame(game);
        } catch (DuplicateIDException e){
            System.out.println("Duplicate ID found");
        } catch (InvalidAnswerException e){
            System.out.println("Invalid answer format.");
            return null;
        }

        ArrayList<String> output = new ArrayList<String>();

        output.add("201 CREATED");
        output.add(String.valueOf(game.getId()));
        return output;
    }

    @GetMapping("/all")
    public List<Game> printAllGames(){

        List<Game> gamesAvailable = service.returnListOfGames();
        ArrayList<Game> games = (ArrayList) gamesAvailable;
        for (Game game : gamesAvailable){
            System.out.println(String.format("%s", game.getId()));
        }
        return gamesAvailable;
    }


    @GetMapping("/test")
    public String test(){
        return service.test();
    }

    @GetMapping("/test2")
    public String test2(){
        return "Test";
    }

    @PostMapping("/guess")
    public String verifyGuess(){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/game")
    public List<Game> returnListOfGames(){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/game/{gameId}")
    public Game getGame(int gameId){
        throw new UnsupportedOperationException();
    }

    @GetMapping("rounds/{gameId}")
    public List<Round> getRounds(int gameId){
        throw new UnsupportedOperationException();
    }

}
