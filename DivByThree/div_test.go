package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test(t *testing.T) {
	tests := []struct {
		n   int
		res bool
	}{
		{3, true},
		{5, false},
		{-3, true},
	}
	for _, tt := range tests {
		t.Run("", func(t *testing.T) {
			actual := div(tt.n)
			assert.Equal(t, tt.res, actual)
		})
	}
}
