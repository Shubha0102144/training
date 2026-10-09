package main

func perfect_number(n int) bool {
	var sum int = 0
	for i := 1; i < n; i++ { //for ex:n=6
		if n%i == 0 { // iteration 1:i=2,6%2==0=true    iteration 1:i=3 ,6%3==0=>true
			sum += i //iteration 1:sum=0+2=>2          iteration2: sum=2+3=>5
		}

	}
	if sum == n {
		return true
	} else {
		return false
	}
}
