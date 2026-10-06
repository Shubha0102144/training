package com.marmin;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;




class MinNumberTest {
  
    @Test
    void Min(){
        MinNumber minn=new MinNumber();
        assertEquals(minn.min(4,5),4);
    


   
        assertEquals(minn.min(5,0),0);
    
    
        assertEquals(minn.min(-1,-2),-2);
    
         assertEquals(minn.min(0,0),0);
    }
    
}


