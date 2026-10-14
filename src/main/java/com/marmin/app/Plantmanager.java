package com.marmin.app;

import java.util.*;

public class Plantmanager {
    String plantid;
    String name;

    String species;

    Careprofile care;
    int dayssincelastwatered;

    Plantmanager(String plantid, String name, String species, Careprofile care, int dayssincelastwatered) {

        if (plantid == null || plantid.isBlank() || name == null || name.isBlank() || species == null
                || species.isBlank() || care == null || dayssincelastwatered < 0 || care.interval < 0
                || care.interval == 0) {
            throw new IllegalArgumentException("invalid data");
        }

        this.plantid = plantid;
        this.name = name;
        this.species = species;
        this.care = care;

        this.dayssincelastwatered = dayssincelastwatered;
    }

    public String display() {
        return "plantid: " + plantid + " name: " + name + " species:" + species + " interval: " + care.interval
                + " dayssincelastwatered: " + dayssincelastwatered;

    }
}

class PlantCareService {
    ArrayList<Plantmanager> list = new ArrayList<>();

    public String Addplant(Plantmanager p) {

        for (Plantmanager plant : list) {
            if (plant.plantid.equals(p.plantid)) {
                throw new IllegalArgumentException("plant with this id already exists,enter  unique id");

            }

        }
        list.add(p);
        return "plant added";

    }

    public void waterplant(String id) {
        if (!list.contains(id)) {

            throw new IllegalArgumentException("plant with this id is not registered");
        }
        for (Plantmanager p : list) {

            if (p.plantid.equals(id)) {

                p.dayssincelastwatered = 0;
                System.out.println("following plant watered" + p.display());
                return;

            }

        }

    }

    public int duelist() {
        int due = 0;
        for (Plantmanager p : list) {
            if (p.care.interval <= p.dayssincelastwatered) {
                due = p.dayssincelastwatered - p.care.interval;
                return due;
            }

        }
        return due;
    }

    public void setCareInterval(String id, int careinterval) {
        for (Plantmanager p : list) {
            if (p.plantid.equals(id)) {
                p.care.interval = careinterval;
                System.out.println(p.display());

            }
            throw new IllegalArgumentException("plant with this id does not exists");
        }

    }

    public String dueListClassification() {
        for (Plantmanager p : list) {
            if (p.care.interval == p.dayssincelastwatered) {
                return p.plantid + "is on due";
            } else if (p.care.interval <= p.dayssincelastwatered) {
                return p.plantid + "is on overdue";
            } else {
                return p.plantid + "is not on due";
            }
        }
        throw new IllegalArgumentException("no plants in the garden");
    }

    public String plantdue() {
        String result = " ";

        for (Plantmanager p : list) {
            if (p.dayssincelastwatered >= p.care.interval) {
                result += p.display() + "\n";
            }
        }
        if (result.isEmpty()) {
            return "there is no plant with watering interval ellapsed";

        }
        return result;
    }

    public String list_all() {
        String result = " ";
        for (Plantmanager p : list) {
            result += p.display() + "\n";
        }
        if (result.isEmpty()) {
            return "there is no plant in garden";

        }
        return result;
    }

    public String display(String id) {

        for (Plantmanager p : list) {
            if (p.plantid.equals(id)) {

                return p.display();

            }
        }
        return "plant with the mentioned id is not registered";

    }

    public int total_no_of_plants() {
        return list.size();
    }

}

class Careprofile {

    int interval;

    Careprofile(int interval) {

        this.interval = interval;

    }

}
