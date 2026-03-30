package com.example.wek11final.repository;

import com.example.wek11final.models.Match;
import java.util.List;

/**
 * Extends the generic Repository class to handle Match entities
 */
public class MatchRepository extends Repository<Match> {

    /**
     * Utilizes a lambda expression to implement filtering
     * Finds all matches where a specific team was either the home team OR the away team.
     */
    public List<Match> filterByTeam(String teamName) {
        return filter(match -> match.getHomeTeam().equalsIgnoreCase(teamName) ||
                match.getAwayTeam().equalsIgnoreCase(teamName));
    }
}