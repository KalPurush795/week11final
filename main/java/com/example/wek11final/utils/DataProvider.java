/**
 *  This serves as our hardcoded database.
 * We use this to populate our repositories when the app starts.
 */

package com.example.wek11final.utils;

import com.example.wek11final.models.Match;
import com.example.wek11final.models.Player;
import com.example.wek11final.models.Team;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static List<Team> createSampleTeams() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("FC Barcelona", "Spain", "La Liga"));
        teams.add(new Team("Manchester United", "England", "Premier League"));
        teams.add(new Team("Bayern Munich", "Germany", "Bundesliga"));
        teams.add(new Team("Juventus", "Italy", "Serie A"));
        teams.add(new Team("Paris Saint-Germain", "France", "Ligue 1"));
        return teams;
    }

    // NEW: Adding sample players based on the assignment data
    public static List<Player> createSamplePlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Lionel Messi", 34, "Argentina", "Forward", "FC Barcelona", 10));
        players.add(new Player("Cristiano Ronaldo", 36, "Portugal", "Forward", "Juventus", 7));
        players.add(new Player("Robert Lewandowski", 32, "Poland", "Forward", "Bayern Munich", 9));
        players.add(new Player("Kevin De Bruyne", 29, "Belgium", "Midfielder", "Manchester City", 17));
        return players;
    }

    // NEW: Adding sample matches based on the assignment data
    public static List<Match> createSampleMatches() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match("FC Barcelona", "Real Madrid", "2-1", "La Liga", "2023-04-10", "Camp Nou"));
        matches.add(new Match("Manchester United", "Liverpool", "0-3", "Premier League", "2023-03-15", "Old Trafford"));
        matches.add(new Match("Bayern Munich", "Borussia Dortmund", "4-2", "Bundesliga", "2023-04-01", "Allianz Arena"));
        return matches;
    }
}
