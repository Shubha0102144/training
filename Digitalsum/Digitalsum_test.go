package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Digit_Sum_for_three_number(t *testing.T) {
	assert.Equal(t, 6, Digital(123)) // for more than 3 numbers

}
func Digit_Sum_for_zero(t *testing.T) {
	assert.Equal(t, 0, Digital(0))
}

func Digit_Sum_for_single_digit(t *testing.T) {
	assert.Equal(t, 7, Digital(7))
}
func Digit_Sum_for_negative_digit(t *testing.T) {
	assert.Equal(t, 0, Digital(-1))
}

func Digit_Sum_for_large_digit(t *testing.T) {
	assert.Equal(t, 9875, Digital(2))
}

func Digit_Sum_for_two_digit(t *testing.T) {
	assert.Equal(t, 38, Digital(2))
}
