package com.marmin.app;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;




class MinNumberTest {
  
    
       public MinNumber minn=new MinNumber();
       
    @Test
    void testLargest() {
        int expected = 10;
        int actual = minn.min(10, 20); 
        assertEquals(expected, actual);
    }
    @Test
    void testOneLargest() {
        int expected = 99;
        int actual = minn.min(99, 120); 
        assertEquals(expected, actual);
    }
    @Test
    void testTwoLargest() {
        int expected = -20;
        int actual = minn.min(-10, -20); 
        assertEquals(expected, actual);
    }
    @Test
    void testThreeLargest() {
        int expected = 100;
        int actual = minn.min(100, 100); 
        assertEquals(expected, actual);
    }


    }
