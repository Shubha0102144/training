package com.marmin.app;

public class Digitalsum{
   

   public int Digital(int n) {
	
	
	if (n < 10) {
		return n;
	}
	while(n >= 10 ){
        int sum=0;

		while(n > 0) {

			sum += n % 10 ;//iteration 1:sum=0+123%10=>3        iteration2:3+12%10=>3+2=>5    iteration3: 5+1%10=>6
			n = n / 10;    //iteration 1:n=123/10=>12           iteration2:12/10=>1           iteration3:1/10=0
		}
        n=sum;
	}
	return n;

}

}
