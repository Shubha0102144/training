package com.marmin.app.Plantmanager;

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

    public String addPlant(Plantmanager p) {
        if (p == null) {
            throw new IllegalArgumentException("plant cannot be null");

        }

        for (Plantmanager plant : list) {
            if (plant.plantid.equals(p.plantid)) {
                throw new IllegalArgumentException("plant with this id already exists,enter  unique id");

            }

        }
        list.add(p);
        return "plant added";

    }

    public String waterPlant(String id) {

        for (Plantmanager p : list) {

            if (p.plantid.equals(id)) {

                p.dayssincelastwatered = 0;

                return p.plantid + " " + getStatus(p);

            }

        }
        throw new IllegalArgumentException("plant with this id is not registered");

    }

    public void incrementdays() {
        for (Plantmanager p : list) {
            p.dayssincelastwatered++;
        }
    }

    public String dueList() {
        int due = 0;
        String result = "";
        for (Plantmanager p : list) {
            if (p.care.interval <= p.dayssincelastwatered) {
                due += p.dayssincelastwatered - p.care.interval;
                result += p.plantid + " " + "has" + " " + due + " " + "duedays";

            } else {
                result += p.plantid + " " + "is not on due";
            }

        }
        if (result.isEmpty()) {
            return "no plants in garden";

        }
        return result;
    }

    public void setCareInterval(String id, int careinterval) {
        if (careinterval <= 0) {
            throw new IllegalArgumentException("invalid careinterval");

        }
        for (Plantmanager p : list) {
            if (p.plantid.equals(id)) {
                p.care.interval = careinterval;
                System.out.println(p.display());
                return;

            }
        }
        throw new IllegalArgumentException("plant with this id does not exists");
    }

    public String dueListClassification() {
        String result = "";

        for (Plantmanager p : list) {
            if (p.care.interval == p.dayssincelastwatered) {
                result += p.plantid + "is on due";
            } else if (p.care.interval <= p.dayssincelastwatered) {
                result += p.plantid + "is on overdue\n";
            } else {
                result += p.plantid + "is not on due\n";
            }
        }
        if (result.isEmpty()) {
            return "no plants in garden";

        }
        return result;
    }

    public String plantDue() {
        String result = "";

        for (Plantmanager p : list) {
            if (p.dayssincelastwatered >= p.care.interval) {
                result += p.display() + "\n";
            }
        }
        if (result.isEmpty()) {
            return "there is no plant with watering interval ellapsed";

        }
        if (result.isEmpty()) {
            return "no plants in garden";

        }
        return result;
    }

    public String greenHouseOverview() {
        int due = 0, overdue = 0, notyetdue = 0;
        String result = "";
        for (Plantmanager p : list) {
            if (p.care.interval == p.dayssincelastwatered) {
                due++;
                result += "total no of due plant:" + due;
            } else if (p.dayssincelastwatered > p.care.interval) {
                overdue++;
                result += "total no of overdue plants:" + overdue + "\n";
            } else {
                notyetdue++;
                result += "total no of not yet due plnats:" + notyetdue + "\n";
            }

            result += "total no of plants:" + total_Number_Of_Plants();
        }
        if (result.isEmpty()) {
            return "no plants in garden";

        }
        return result;
    }

    public String filterBySpecies(String species) {

        if (species == null) {
            throw new IllegalArgumentException("species cannot be null");
        }
        species = species.trim();
        int count = 1;
        String result = "";

        for (Plantmanager p : list) {
            if (species.equalsIgnoreCase(p.species.trim())) {
                result += p.plantid + " " + species + " " + count++;
            }
        }
        return result;
    }

    public String filterByCare(String status) {
        status = status.trim();
        String result = "";
        int count = 1;
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("staus cannot be empty or null");
        }
        if (!status.equalsIgnoreCase("due") && !status.equalsIgnoreCase("notyetdue")
                && !status.equalsIgnoreCase("overdue")) {
            throw new IllegalArgumentException("specified status is invalid");
        }

        for (Plantmanager p : list) {

            if (status.equalsIgnoreCase(getStatus(p).trim())) {
                result += p.plantid + " " + status + " " + count++;

            }
        }
        return result;
    }

    public String getStatus(Plantmanager p) {

        if (p.care.interval == p.dayssincelastwatered) {
            return "due";
        } else if (p.dayssincelastwatered > p.care.interval) {
            return "overdue";
        }

        return "notyetdue";

    }

    public String moveStatus() {
        String status = "";
        for (Plantmanager p : list) {
            if (p.dayssincelastwatered == 0 || p.dayssincelastwatered < p.care.interval) {
                status += "no-due";

            } else if (p.dayssincelastwatered == p.care.interval) {
                status += "due";
            } else {
                status += "overdue";
            }
        }
        return status;
    }

    public String list_All() {
        String result = "";
        for (Plantmanager p : list) {
            result += p.display() + "\n";
        }
        if (result.isEmpty()) {
            return "there is no plant in garden";

        }
        if (result.isEmpty()) {
            return "no plants in garden";

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

    public int total_Number_Of_Plants() {
        return list.size();
    }

}

class Careprofile {

    int interval;

    Careprofile(int interval) {

        this.interval = interval;

    }

}
