package com.example.wek11final.models;

import java.util.UUID;

/**
 * Represents a Player model that extends the common SoccerEntity interface
 * The properties match the fields provided in the example players data
 */
public class Player implements SoccerEntity {
    private String id;
    private String name;
    private int age;
    private String country;
    private String position;
    private String team;
    private int number;

    public Player(String name, int age, String country, String position, String team, int number) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.country = country;
        this.position = position;
        this.team = team;
        this.number = number;
    }

    @Override public String getId() { return id; }
    @Override public String getName() { return name; }

    public String getTeam() { return team; }
}