
#include <array>
#include <string>
using namespace std;

class Solution {

    static const int ALPHABET_SIZE = 26;
    array<int, ALPHABET_SIZE> frequency{};

public:
    string sortString(const string& input) {
        for (const auto& letter : input) {
            ++frequency[letter - 'a'];
        }

        int index = 0;
        bool increasing = true;
        string alternatingIncreasingDecreasing(input.length(), ' ');

        while (index < alternatingIncreasingDecreasing.size()) {
            index = addLetters(alternatingIncreasingDecreasing, index, increasing);
            index = addLetters(alternatingIncreasingDecreasing, index, !increasing);
        }

        return alternatingIncreasingDecreasing;
    }

private:
    int addLetters(string& alternatingIncreasingDecreasing, int index, bool increasing) {
        int start = increasing ? 0 : ALPHABET_SIZE - 1;
        int end = increasing ? ALPHABET_SIZE : -1;
        int step = increasing ? 1 : -1;

        for (int letter = start; letter != end; letter += step) {
            if (frequency[letter] > 0) {
                --frequency[letter];
                alternatingIncreasingDecreasing[index] = static_cast<char>(letter + 'a');
                ++index;
            }
        }
        return index;
    }
};
