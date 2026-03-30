package com.example.wek11final.models;

/**
 *  This is our base interface.
 * Every model we create (Team, Player, Match) will "implement" this.
 * This guarantees that every soccer object in our app has an ID and a Name,
 * which makes our generic Repository much easier to build!
 */
public interface SoccerEntity {
    String getId();
    String getName();
}