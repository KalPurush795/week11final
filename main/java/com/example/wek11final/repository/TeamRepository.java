package com.example.wek11final.repository;

import com.example.wek11final.models.Team;
import java.util.List;

/**
 * Because we built a Generic Repository earlier,
 * this class barely needs any code! It inherits add() and getAll() automatically.
 * We just add one specific Lambda filter here.
 */
public class TeamRepository extends Repository<Team> {

    // Uses the generic filter method from the parent class using a Lambda expression
    public List<Team> filterByLeague(String league) {
        return filter(team -> team.getLeague().equalsIgnoreCase(league));
    }
}