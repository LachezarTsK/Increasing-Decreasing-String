
package main

import (
	"fmt"
	"strings"
)

var ALPHABET_SIZE = 26
var frequency = make([]int, ALPHABET_SIZE)

func sortString(input string) string {
	for _, letter := range input {
		frequency[letter-'a']++
	}

	var index = 0
	var increasing = true
	var alternatingIncreasingDecreasing *strings.Builder = &strings.Builder{}

	for index < len(input) {
		index = addLetters(alternatingIncreasingDecreasing, index, increasing)
		index = addLetters(alternatingIncreasingDecreasing, index, !increasing)
	}

	return alternatingIncreasingDecreasing.String()
}

func addLetters(alternatingIncreasingDecreasing *strings.Builder, index int, increasing bool) int {
	start := Ternary(increasing, 0, ALPHABET_SIZE-1)
	end := Ternary(increasing, ALPHABET_SIZE, -1)
	step := Ternary(increasing, 1, -1)

	for letter := start; letter != end; letter += step {
		if frequency[letter] > 0 {
			frequency[letter]--
			alternatingIncreasingDecreasing.WriteByte(byte(letter) + byte('a'))
			index++
		}
	}

	return index
}

func Ternary[T any](condition bool, first T, second T) T {
	if condition {
		return first
	}
	return second
}
