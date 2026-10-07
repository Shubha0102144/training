package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test(t *testing.T) {
	tests := []struct {
		n   int
		res int
	}{
		{2, 4},
		{-2, -4},
		{4, 8},
		{0, 0},
	}
	for _, tt := range tests {
		t.Run("", func(t *testing.T) {
			actual := double(tt.n)
			assert.Equal(t, tt.res, actual)
		})
	}
}
