package main

func Digital(n int) int {
	//n = 38 -> 3 + 8 = 11 -> 1 + 1 = 2
	sum := 0
	if n < 10 {
		return n
	}
	for n >= 10 {

		for n > 0 {

			sum += n % 10 //iteration 1:sum=0+123%10=>3        iteration2:3+12%10=>3+2=>5    iteration3: 5+1%10=>6
			n = n / 10    //iteration 1:n=123/10=>12           iteration2:12/10=>1           iteration3:1/10=0
		}
	}
	return sum

}
