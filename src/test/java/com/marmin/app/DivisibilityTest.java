package com.marmin.app;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DivisibilityTest {
  
    @Test
    void Divisiblility(){
        Divisible div=new Divisible();
        Assertions.assertFalse(div.isDiv(4));
    


   
        Assertions.assertTrue(div.isDiv(-5));
    
    
        Assertions.assertTrue(div.isDiv(0));
    
    
       Assertions.assertTrue(div.isDiv(5));
    }
    
}


