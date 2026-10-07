package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestDiv(t *testing.T) {
	tests := []struct {
		x, y, z int
		result  int
	}{
		{1, 2, 3, 3},
		{2, 5, 6, 6},
		{-2, -1, -3, -1},
		{-10, 0, -1, 0},
		{0, 0, 0, 0},
	}
	for _, tt := range tests {
		t.Run("", func(t *testing.T) {

			actual := maxOf3(tt.x, tt.y, tt.z)
			assert.Equal(t, tt.result, actual)

		})
	}
}
