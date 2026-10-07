package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestDiv(t *testing.T) {

	tests := []struct {
		x   int
		res bool
	}{
		{10, false},
		{30, true},
		{60, true},
		{-15, true},
		{0, true},
	}
	for _, tt := range tests {
		t.Run("", func(t *testing.T) {

			actual := isDivisible(tt.x)
			assert.Equal(t, tt.res, actual)
		})
	}
}
