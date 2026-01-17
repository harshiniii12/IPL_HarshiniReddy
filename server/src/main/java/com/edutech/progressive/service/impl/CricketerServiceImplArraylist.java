package com.edutech.progressive.service.impl;
 
import java.util.ArrayList;

import java.util.List;
 
import com.edutech.progressive.entity.Cricketer;

import com.edutech.progressive.service.CricketerService;
 
import java.util.Collections;
 
public class CricketerServiceImplArraylist implements CricketerService {
 
    private List<Cricketer> cricketers = new ArrayList<>();
 
    public CricketerServiceImplArraylist() {

        // Sample in-memory data (you can modify or load dynamically as needed)

        cricketers.add(new Cricketer(1, 101, "Virat Kohli", 35, "India", 15, "Batsman", 12000, 4));

        cricketers.add(new Cricketer(2, 102, "Mitchell Starc", 35, "Australia", 12, "Bowler", 400, 250));

        cricketers.add(new Cricketer(3, 101, "Ravindra Jadeja", 37, "India", 14, "All-rounder", 2500, 180));

        cricketers.add(new Cricketer(4, 103, "Jos Buttler", 35, "England", 11, "Wicketkeeper", 3000, 0));

        cricketers.add(new Cricketer(5, 104, "Rashid Khan", 27, "Afghanistan", 9, "Bowler", 600, 130));

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

        Collections.sort(copy); // uses Cricketer.compareTo (experience)

        return copy;

    }
 
    @Override

    public void emptyArrayList() {

        // Reinitialize to clear as per requirement

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
 
 