
using System;

public class Solution
{
    private static readonly int ALPHABET_SIZE = 26;
    private readonly int[] frequency = new int[ALPHABET_SIZE];

    public string SortString(string input)
    {
        foreach (char letter in input)
        {
            ++frequency[letter - 'a'];
        }

        int index = 0;
        bool increasing = true;
        char[] alternatingIncreasingDecreasing = new char[input.Length];

        while (index < alternatingIncreasingDecreasing.Length)
        {
            index = AddLetters(alternatingIncreasingDecreasing, index, increasing);
            index = AddLetters(alternatingIncreasingDecreasing, index, !increasing);
        }

        return string.Join("", alternatingIncreasingDecreasing);
    }

    private int AddLetters(char[] alternatingIncreasingDecreasing, int index, bool increasing)
    {
        int start = increasing ? 0 : ALPHABET_SIZE - 1;
        int end = increasing ? ALPHABET_SIZE : -1;
        int step = increasing ? 1 : -1;

        for (int letter = start; letter != end; letter += step)
        {
            if (frequency[letter] > 0)
            {
                --frequency[letter];
                alternatingIncreasingDecreasing[index] = (char)(letter + 'a');
                ++index;
            }
        }
        return index;
    }
}
