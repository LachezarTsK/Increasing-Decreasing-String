
public class Solution {

    private static final int ALPHABET_SIZE = 26;
    private final int[] frequency = new int[ALPHABET_SIZE];

    public String sortString(String input) {
        for (char letter : input.toCharArray()) {
            ++frequency[letter - 'a'];
        }

        int index = 0;
        boolean increasing = true;
        char[] alternatingIncreasingDecreasing = new char[input.length()];

        while (index < alternatingIncreasingDecreasing.length) {
            index = addLetters(alternatingIncreasingDecreasing, index, increasing);
            index = addLetters(alternatingIncreasingDecreasing, index, !increasing);
        }

        return String.valueOf(alternatingIncreasingDecreasing);
    }

    private int addLetters(char[] alternatingIncreasingDecreasing, int index, boolean increasing) {
        int start = increasing ? 0 : ALPHABET_SIZE - 1;
        int end = increasing ? ALPHABET_SIZE : -1;
        int step = increasing ? 1 : -1;

        for (int letter = start; letter != end; letter += step) {
            if (frequency[letter] > 0) {
                --frequency[letter];
                alternatingIncreasingDecreasing[index] = (char) (letter + 'a');
                ++index;
            }
        }
        return index;
    }
}
