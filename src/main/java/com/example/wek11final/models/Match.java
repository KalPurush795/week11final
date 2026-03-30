package com.example.wek11final.models;

import java.util.UUID;

/**
 * Represents a Match model extending the SoccerEntity interface
 * The properties are derived directly from the example matches data
 */
public class Match implements SoccerEntity {
    private String id;
    private String homeTeam;
    private String awayTeam;
    private String score;
    private String league;
    private String date;
    private String stadium;

    public Match(String homeTeam, String awayTeam, String score, String league, String date, String stadium) {
        this.id = UUID.randomUUID().toString();
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
        this.league = league;
        this.date = date;
        this.stadium = stadium;
    }

    @Override public String getId() { return id; }

    // A match doesn't have a single "Name", so we combine the two teams to fulfill the interface contract!
    @Override public String getName() { return homeTeam + " vs " + awayTeam; }

    public String getHomeTeam() { return homeTeam; }
    public String getAwayTeam() { return awayTeam; }
}