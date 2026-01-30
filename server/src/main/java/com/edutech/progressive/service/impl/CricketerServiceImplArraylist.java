
package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.CricketerService;

public class CricketerServiceImplArraylist implements CricketerService {

    private List<Cricketer> cricketers = new ArrayList<>();

    public CricketerServiceImplArraylist() {
       
        Team t101 = new Team(101, null, null, null, 0);
        Team t102 = new Team(102, null, null, null, 0);
        Team t103 = new Team(103, null, null, null, 0);
        Team t104 = new Team(104, null, null, null, 0);

       
        cricketers.add(new Cricketer(1, t101, "Virat Kohli", 35, "India", 15, "Batsman", 12000, 4));
        cricketers.add(new Cricketer(2, t102, "Mitchell Starc", 35, "Australia", 12, "Bowler", 400, 250));
        cricketers.add(new Cricketer(3, t101, "Ravindra Jadeja", 37, "India", 14, "All-rounder", 2500, 180));
        cricketers.add(new Cricketer(4, t103, "Jos Buttler", 35, "England", 11, "Wicketkeeper", 3000, 0));
        cricketers.add(new Cricketer(5, t104, "Rashid Khan", 27, "Afghanistan", 9, "Bowler", 600, 130));
    }

    @Override
    public List<Cricketer> getAllCricketers() {
        return new ArrayList<>(cricketers);
    }

    @Override
    public Integer addCricketer(Cricketer cricketer) {
        cricketers.add(cricketer);
        return cricketers.size();
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() {
        List<Cricketer> copy = new ArrayList<>(cricketers);
        Collections.sort(copy); 
        return copy;
    }

    @Override
    public void emptyArrayList() {
        cricketers = new ArrayList<>();
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) {
        for (Cricketer c : cricketers) {
            if (c.getCricketerId() == cricketerId) return c;
        }
        return null;
    }

    @Override
    public void updateCricketer(Cricketer cricketer) {
        if (cricketer == null) return;
        for (int i = 0; i < cricketers.size(); i++) {
            if (cricketers.get(i).getCricketerId() == cricketer.getCricketerId()) {
                cricketers.set(i, cricketer);
                return;
            }
        }
    }

    @Override
    public void deleteCricketer(int cricketerId) {
        cricketers.removeIf(c -> c.getCricketerId() == cricketerId);
    }
}