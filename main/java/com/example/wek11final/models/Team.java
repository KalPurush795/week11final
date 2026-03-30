package com.example.wek11final.models;

import java.util.UUID;

/**
 *  This is our Team model based exactly on the UML diagram.
 * It implements SoccerEntity, meaning it MUST have getId() and getName().
 */
public class Team implements SoccerEntity {
    private String id;
    private String name;
    private String country;
    private String league;

    public Team(String name, String country, String league) {
        // We generate a random unique ID for every new team automatically
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.country = country;
        this.league = league;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLeague() {
        return league;
    }
}