package main

func isDivisible(x int) bool {
	if x%3 == 0 && x%5 == 0 {
		return true
	} else {
		return false
	}
}
