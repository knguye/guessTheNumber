package com.kevinNguyen.GuessTheNumber.dto;

import com.kevinNguyen.GuessTheNumber.service.InvalidAnswerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {
    private int id;
    private int answer;
    private String status;
    private List<Round> rounds;
    private Random seed;

    public Game(){
        seed = new Random(); // TODO: Generate random id and answer
        setStatus(0);
        rounds = new ArrayList<Round>();
    }

    public void generateAnswer(){
        answer = seed.nextInt(9000) + 1000;

        while (!allDigitsUnique()){
            generateAnswer();
        }
    }

    public boolean allDigitsUnique(){
        int uniqueDigits =  String.valueOf(getAnswer()).chars()
                .mapToObj(c -> c)
                .collect(Collectors.toSet())
                .size();

        // Check if there are 4 UNIQUE digits in the list we created above
        if (uniqueDigits != 4){
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String convertAnswer() {
        return String.valueOf(answer);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Chooses the status string based on what number we input for status ID.
     * 0 = In progress
     * 1 = Finished
     * @param statusID
     */
    public void setStatus(int statusID){
        String[] statuses = {"In progress", "Finished"};

        try {
            status = statuses[statusID];
        } catch (IndexOutOfBoundsException e){
            System.out.println("Please enter a valid status ID.");
            status = "Unknown"; // In case we pass in a status ID that is invalid
        }
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
