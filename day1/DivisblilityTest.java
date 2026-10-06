package com.marmin;
import org.junit.jupiter.api.Assertions;



import org.junit.jupiter.api.Test;


class Divisibilitest {
  
@Test

    void Divisiblility(){
        Divisible div=new Divisible();
        assertTrue(div.isDiv(4),false);
    


   
        assertTrue(div.isDiv(5),true);
    
    
        assertTrue(div.isDiv(0)==true);
    
    
        assertTrue(div.isDiv(-5)==true);
    }
    
}


