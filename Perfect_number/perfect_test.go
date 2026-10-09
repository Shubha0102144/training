package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func check_single_digit_number_is_perfect(t *testing.T) {
	assert.Equal(t, true, perfect_number(6)) // 6=1+2+3
}
func check_two_digit_number_is_perfect(t *testing.T) {
	assert.Equal(t, true, perfect_number(28)) //1+2+4+7+14=28
}

func check_number_is_not_perfect(t *testing.T) {
	assert.Equal(t, false, perfect_number(12)) //1+2+3+4+6=>16
}

func check_number_1_not_perfect(t *testing.T) {
	assert.Equal(t, false, perfect_number(1))
}

func check_number_large_no_is_perfect(t *testing.T) {
	assert.Equal(t, true, perfect_number(496))
}
