package com.kevinNguyen.GuessTheNumber.dao;

import com.kevinNguyen.GuessTheNumber.dto.Round;

import java.util.List;

public interface RoundDao {
    public Round addRound(Round round);
    public Round getRoundById(int roundId);
    public List<Round> getAllRoundsById(int gameId);
}
