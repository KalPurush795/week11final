package com.example.wek11final.repository;

import com.example.wek11final.models.Player;
import java.util.List;

/**
 * Extends the generic Repository<T> class to manage collections of Player entities[cite: 25].
 */
public class PlayerRepository extends Repository<Player> {

    /**
     * Implements search/filter functionality using a lambda expression[cite: 36].
     * Filters the list to find all players on a specific team.
     */
    public List<Player> filterByTeam(String teamName) {
        return filter(player -> player.getTeam().equalsIgnoreCase(teamName));
    }
}