package com.example.stickhero;

import java.util.ArrayList;
import java.util.HashMap;

public class storage {
    HashMap<player, Integer> topSores = new HashMap<player, Integer>();
    ArrayList<player>  players = new ArrayList<player>();


    public HashMap<player, Integer> getTopSores() {
        return topSores;
    }

    public void setTopSores(HashMap<player, Integer> topSores) {
        this.topSores = topSores;
    }

    public ArrayList<player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<player> players) {
        this.players = players;
    }

    public storage(HashMap<player, Integer> topSores, ArrayList<player> players) {
        this.topSores = topSores;
        this.players = players;
    }
}
