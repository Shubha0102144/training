package com.marmin.app;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class Digitalsumtest {
    Digitalsum tests=new Digitalsum();

    @ParameterizedTest
    @CsvSource({
        "38,2",
        "7,7",
        "0,0"
    })

    void test(int input,int expected){
        int actual=tests.Digital(input);
        assertEquals(expected,actual);
    }
    

}

