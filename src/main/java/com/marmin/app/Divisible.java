package com.marmin.app;

 public class Divisible{
   
    boolean isDiv(int n){
        int lastdigit=Math.abs(n%10);
            return lastdigit==0 || lastdigit==5;
    }
}

