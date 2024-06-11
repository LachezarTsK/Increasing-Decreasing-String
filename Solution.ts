
function sortString(input: string): string {
    this.ALPHABET_SIZE = 26;
    this.frequency = new Array<number>(this.ALPHABET_SIZE).fill(0);
    for (let i = 0; i < input.length; ++i) {
        ++this.frequency[input.codePointAt(i) - 'a'.codePointAt(0)];
    }

    let index = 0;
    let increasing = true;
    const alternatingIncreasingDecreasing = new Array<string>(input.length);

    while (index < alternatingIncreasingDecreasing.length) {
        index = addLetters(alternatingIncreasingDecreasing, index, increasing);
        index = addLetters(alternatingIncreasingDecreasing, index, !increasing);
    }

    return alternatingIncreasingDecreasing.join('');
};

function addLetters(alternatingIncreasingDecreasing: string[], index: number, increasing: boolean): number {
    let start = increasing ? 0 : this.ALPHABET_SIZE - 1;
    let end = increasing ? this.ALPHABET_SIZE : -1;
    let step = increasing ? 1 : -1;

    for (let letter = start; letter !== end; letter += step) {
        if (this.frequency[letter] > 0) {
            --this.frequency[letter];
            alternatingIncreasingDecreasing[index] = String.fromCodePoint(letter + 'a'.codePointAt(0));
            ++index;
        }
    }
    return index;
}
