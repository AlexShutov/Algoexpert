package com.algoexpert.easy.java;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentWinner {
    public static void main(String[] args) {
        TournamentWinner tw = new TournamentWinner();
    }

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> points = new HashMap<>();
        for (int i = 0; i < competitions.size(); i++) {
            List<String> round = competitions.get(i);
            String winner;
            if (results.get(i) == 1) {
                // home team (first index) wins
                winner = round.get(0);
            } else {
                // home team loses
                winner = round.get(1);
            }
            // add points to winning team
            points.put(winner, points.getOrDefault(winner, 0) + 3);
        }
        int maxScore = -1;
        String winningTeam = "";
        for (String team: points.keySet()) {
            int teamPoints = points.get(team);
            if (teamPoints > maxScore) {
                maxScore = teamPoints;
                winningTeam = team;
            }
        }
        return winningTeam;
    }
}
