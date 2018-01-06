package com.example.codeclan.summit;

import java.util.ArrayList;

/**
 * Created by sophiemullins on 06/01/2018.
 */

public class Summits {

    private ArrayList<Summit> list;

    public Summits() {

        list = new ArrayList<Summit>();
        list.add(new Summit("Ben Nevis", 1345, "Grampian Mountains", "Scotland"));
        list.add(new Summit("Càrn Mòr Dearg", 1221, "Grampian Mountains", "Scotland"));
        list.add(new Summit("Scald Law", 579, "Pentland Hills", "Scotland"));
        list.add(new Summit("Carnethy Hill", 573, "Pentland Hills", "Scotland"));
        list.add(new Summit("East Cairn Hill", 567, "Pentland Hills", "Scotland"));
        list.add(new Summit("West Cairn Hill", 562, "Pentland Hills", "Scotland"));
        list.add(new Summit("West Kip", 551, "Pentland Hills", "Scotland"));
        list.add(new Summit("Byrehope Mount", 536, "Pentland Hills", "Scotland"));
        list.add(new Summit("East Kip", 534, "Pentland Hills", "Scotland"));
        list.add(new Summit("Allermuir Hill", 493, "Pentland Hills", "Scotland"));
        list.add(new Summit("Castlelaw Hill", 488, "Pentland Hills", "Scotland"));
        list.add(new Summit("Le Brévent", 2525, "Aiguilles Rouges", "France"));
        list.add(new Summit("Mont Blanc", 4810, "Alps", "France"));
        list.add(new Summit("Col Ferret", 2490, "Alps", "Italy-Switzerland"));
        list.add(new Summit("Montgó", 753, "Cordillera Prebética", "Spain"));
    }

    public ArrayList<Summit> getList() {
        return list;
    }

}
