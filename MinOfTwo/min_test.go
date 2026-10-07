package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test(t *testing.T) {
	tests := []struct {
		a, b int
		res  int
	}{
		{10, 12, 10},
		{-1, 2, -1},
		{0, -1, -1},
		{0, 0, 0},
	}
	for _, tt := range tests {
		t.Run("", func(t *testing.T) {
			actual := minn(tt.a, tt.b)
			assert.Equal(t, tt.res, actual)
		})
	}

}
