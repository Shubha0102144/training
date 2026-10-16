package com.marmin.app.Plantmanager;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Plantmanagertest {

    @Test
    void test_data_using_display() {
        Careprofile care = new Careprofile(3);
        Plantmanager plant = new Plantmanager("4m1", "abc", "bc", care, 1);

        String expected = "plantid: 4m1 name: abc species:bc interval: 3 dayssincelastwatered: 1";

        assertEquals(expected, plant.display());
    }

    @Test
    void test_invalid_id() {
        Careprofile care = new Careprofile(3);
        assertThrows(IllegalArgumentException.class, () -> new Plantmanager(
                "", "abc", "hs", care, 1));
    }

    @Test
    void test_null_id() {
        Careprofile care = new Careprofile(3);
        assertThrows(IllegalArgumentException.class, () -> new Plantmanager(
                null, "abc", "hs", care, 1));
    }

    @Test
    void test_invalid_name() {
        Careprofile care = new Careprofile(3);
        assertThrows(IllegalArgumentException.class, () -> new Plantmanager(
                "4m2", " ", "hs", care, 1));
    }

    @Test
    void test_null_name() {
        Careprofile care = new Careprofile(3);
        assertThrows(IllegalArgumentException.class, () -> new Plantmanager(
                "4m2", null, "hs", care, 1));
    }

    @Test
    void test_invalid_speceis() {
        Careprofile care = new Careprofile(3);
        assertThrows(IllegalArgumentException.class, () -> new Plantmanager(
                "4m2", "abc", " ", care, 1));
    }

    @Test
    void test_null_speceis() {
        Careprofile care = new Careprofile(3);
        assertThrows(IllegalArgumentException.class, () -> new Plantmanager(
                "4m2", "abc", null, care, 1));
    }

    @Test
    void test_invalid_interval() {
        Careprofile care = new Careprofile(0);
        assertThrows(IllegalArgumentException.class, () -> new Plantmanager(
                "4m3", "abc", "hs", care, 1));
    }

    @Test
    void test_negative_interval() {
        Careprofile care = new Careprofile(-1);
        assertThrows(IllegalArgumentException.class, () -> new Plantmanager(
                "4m3", "abc", "hs", care, 1));
    }

    @Test
    void test_null_care() {
        Careprofile care = null;
        assertThrows(IllegalArgumentException.class, () -> new Plantmanager(
                "4m3", "abc", "hs", care, 1));
    }

    void test_invalid_days() {
        Careprofile care = new Careprofile(3);
        assertThrows(IllegalArgumentException.class, () -> new Plantmanager(
                "4m4", "aa", "hs", care, -10));
    }

    void test_Add_plant_using_size() {
        PlantCareService plant = new PlantCareService();
        Careprofile care = new Careprofile(3);

        Plantmanager p = new Plantmanager("4m0", "rose", "flower", care, 1);

        plant.addPlant(p);

        assertEquals(1, plant.total_Number_Of_Plants());
    }

    void test_display_for_specific_plant() {
        PlantCareService plant = new PlantCareService();
        Careprofile care = new Careprofile(3);

        plant.addPlant(
                new Plantmanager("4m6", "rose", "flower", care, 1));

        assertTrue(plant.display("4m6").contains("rose"));
    }

    @Test
    void test_unknown_plant() {
        PlantCareService plant = new PlantCareService();

        assertEquals("plant with the mentioned id is not registered", plant.display("P999"));
    }

    @Test
    void test_total_no_of_plants() {
        PlantCareService plant = new PlantCareService();
        Careprofile care = new Careprofile(3);

        plant.addPlant(
                new Plantmanager("4m7", "rose", "flower", care, 1));
        plant.addPlant(
                new Plantmanager("4m8", "tulsi", "herb", care, 0));

        assertEquals(2, plant.total_Number_Of_Plants());
    }

    @Test
    void test_due_classification() {
        PlantCareService plant = new PlantCareService();
        Careprofile care = new Careprofile(2);
        plant.addPlant(new Plantmanager("4m7", "rose", "flower", care, 2));
        assertEquals("4m7:due", plant.dueListClassification());
    }

    @Test
    void test_greenhouse_overview() {
        PlantCareService plant = new PlantCareService();
        Careprofile care = new Careprofile(2);
        plant.addPlant(new Plantmanager("4m7", "rose", "flower", care, 2));
        assertEquals("total no of due plant:1total no of plants:1", plant.greenHouseOverview());
    }

    @Test
    void test_filter_by_species() {
        PlantCareService plant = new PlantCareService();
        Careprofile care = new Careprofile(2);
        plant.addPlant(new Plantmanager("4m7", "rose", "flower", care, 2));
        assertEquals("4m7 flower 1", plant.filterBySpecies("flower"));
    }
   
    @Test
    void test_filter_by_care_status() {
        PlantCareService plant = new PlantCareService();
        Careprofile care = new Careprofile(2);
        plant.addPlant(new Plantmanager("4m7", "rose", "flower", care, 2));
        assertEquals("4m7 due total matching :2", plant.filterByCare("due"));
    }

    @Test
    void test_filter_by_getStatus() {

        Careprofile care = new Careprofile(2);
        PlantCareService plant = new PlantCareService();
        String actual = plant.getStatus(new Plantmanager("4m7", "rose", "flower", care, 2));
        assertEquals("due", actual);
    }

    @Test
    void test_waterPlant() {

        PlantCareService plant = new PlantCareService();
        Careprofile care = new Careprofile(2);
        plant.addPlant(new Plantmanager("4m7", "rose", "flower", care, 2));
        String expected = "4m7 notyetdue";
        String actual = plant.waterPlant("4m7");
        assertEquals(expected, actual);
    }

    @Test
    void test_due_list() {
        PlantCareService plant = new PlantCareService();
        Careprofile care = new Careprofile(2);
        plant.addPlant(new Plantmanager("4m7", "rose", "flower", care, 3));
        String actual = plant.dueList();
        String expected = "4m7 is overdued by 1 days";
        assertEquals(expected, actual);
    }

    @Test
    void test_save() {
        PlantCareService plant = new PlantCareService();

        Careprofile care = new Careprofile(2);
        Plantmanager p = new Plantmanager("4m0", "rose", "flower", care, 1);

        plant.addPlant(p);
        String actual = plant.saveData();
        String expected = "Data added to the file successfully";
        assertEquals(expected, actual);
    }

    @Test
    void test_retreive() {
        PlantCareService plant = new PlantCareService();

        String actual = plant.retreive();
        String expected = "4m0 flower rose 2 1";
        assertEquals(expected, actual);
    }

}
