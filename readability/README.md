## Project: Readability


## About

Readability https://hyperskill.org/projects/39?track=1

## description

- Determines the readability level of a text inputted via command line, based upon 4 indexes: (Automated Reability, coleman liau, flesch–kincaid, SMOG). 

## code
- had to parse the text for syllables, words, sentences, characters, then use them in the formulas for the index readability scores. 
- syllables were counted based on this criteria: 

1. Count the number of vowels in the word.
2. Do not count double-vowels (for example, "rain" has 2 vowels but only 1 syllable).
3. If the last letter in the word is 'e' do not count it as a vowel (for example, "side" has 1 syllable).
4. If at the end it turns out that the word contains 0 vowels, then consider this word as a 1-syllable one.

## what i learned
- what String[] args in the main method means. When running via command line, any text after "java Main" is counted as arguments and stored in array.
- basic regex

- (?=[AEIOUYaeiouy][^aeiouy])(?!e[;,.\\s])  
wanted to use AND statements, so used positive lookahead to combine conditionals. 
- explained: positive lookahead (match) when a vowel followed by NOT a vowel. negative lookahead (dont match) when e followed by ;,. or whitespace. 
- regex is handy
