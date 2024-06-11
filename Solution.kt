
class Solution {

    private companion object {
        const val ALPHABET_SIZE = 26
    }

    private val frequency = IntArray(ALPHABET_SIZE)

    fun sortString(input: String): String {
        for (letter in input) {
            ++frequency[letter - 'a']
        }

        var index = 0
        val increasing = true
        val alternatingIncreasingDecreasing = CharArray(input.length)

        while (index < alternatingIncreasingDecreasing.size) {
            index = addLetters(alternatingIncreasingDecreasing, index, increasing)
            index = addLetters(alternatingIncreasingDecreasing, index, !increasing)
        }

        return alternatingIncreasingDecreasing.joinToString("")
    }

    private fun addLetters(alternatingIncreasingDecreasing: CharArray, index: Int, increasing: Boolean): Int {
        val start = if (increasing) 0 else (ALPHABET_SIZE - 1)
        val end = if (increasing) ALPHABET_SIZE else (-1)
        val step = if (increasing) 1 else (-1)

        var i = index
        var letter = start

        while (letter != end) {
            if (frequency[letter] > 0) {
                --frequency[letter];
                alternatingIncreasingDecreasing[i] = (letter + 'a'.code).toChar()
                ++i
            }
            letter += step
        }
        return i
    }
}
