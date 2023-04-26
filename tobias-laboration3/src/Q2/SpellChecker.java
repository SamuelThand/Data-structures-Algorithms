package Q2;

import util.THA3LinkedList;
import util.THOpenHashTable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class SpellChecker {
    private THOpenHashTable dictionary;
    private String wordFilePath = "tobias-laboration3/src/util/words";

    /**
     * Constructor for a spell checker that loads the dictionary standard path.
     */
    public SpellChecker() {
        this.loadDictionary();
    }

    /**
     * Constructor for a spell checker that loads the dictionary from a given path.
     * The dictionary file must have linebreaks between each word.
     *
     * @param wordFilePath path to dictionary file
     */
    public SpellChecker(String wordFilePath) {
        this.wordFilePath = wordFilePath;
        this.loadDictionary();
    }

    /**
     * Check if the given word is in the dictionary.
     *
     * @param word word to check
     *
     * @return true if the word is in the dictionary, false otherwise
     */
    public boolean isCorrect(String word) {
        return this.dictionary.contains(word.toLowerCase());
    }

    /**
     * Check each word in the sentence against the dictionary and returns the sentence as a string with misspelled words
     * replaced with a list of near misses.
     *
     * @param words sentence to check
     * @return sentence with misspelled words replaced with a list of near misses
     */
    public String getCorrectWordsFromSentence(String words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words.split(" ")) {
            if (this.isCorrect(word)) {
                sb.append(word).append(" ");
            } else {
                sb.append("[ ");
                getNearMisses(word).forEach(nearMiss -> sb.append(nearMiss).append(" "));
                sb.append("] ");
            }
        }
        return sb.toString();
    }

    /**
     * Finds near misses and inserts them into a list.
     *
     * @param word word to find near misses for
     *
     * @return list of near misses
     *
     * @see SpellChecker#addLessCharsMatches
     * @see SpellChecker#addMoreReplaceCharsMatches
     * @see SpellChecker#addSwapCharsMatches
     * @see SpellChecker#addMissedSpaceMatches
     */
    public THA3LinkedList<String> getNearMisses(String word) {
        THA3LinkedList<String> nearMisses = new THA3LinkedList<>();
        word = word.toLowerCase();
        addLessCharsMatches(word, nearMisses);
        addMoreReplaceCharsMatches(word, nearMisses);
        addSwapCharsMatches(word, nearMisses);
        addMissedSpaceMatches(word, nearMisses);
        return nearMisses;
    }

    /**
     * Construct every string that can be made by deleting one letter from the word.
     * Adds matches to the list of near misses.
     *
     * @param word       word to remove chars from
     * @param nearMisses list to add match to
     */
    private void addLessCharsMatches(final String word, final THA3LinkedList<String> nearMisses) {
        String newWord;
        for (int i = 0; i < word.length(); i++) {
            newWord = word.substring(0, i) + word.substring(i + 1);
            if (this.isCorrect(newWord)) {
                nearMisses.addLast(newWord);
            }
        }
    }

    /**
     * Construct every string that can be made by inserting any letter of the alphabet at any position in the string.
     * Construct every string that can be made by replacing each letter in the word with some alphabet letter.
     * Adds matches to the list of near misses.
     *
     * @param word       word to insert chars in
     * @param nearMisses list to add match to
     */
    private void addMoreReplaceCharsMatches(final String word, final THA3LinkedList<String> nearMisses) {
        String newWord;
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                // Insert char
                newWord = word.substring(0, i)
                        + c
                        + word.substring(i);
                if (this.isCorrect(newWord)) {
                    nearMisses.addLast(newWord);
                }
                // Replace char
                newWord = word.substring(0, i)
                        + c
                        + word.substring(i + 1);
                if (this.isCorrect(newWord)) {
                    nearMisses.addLast(newWord);
                }
            }
        }
    }

    /**
     * Construct every string that can be made by swapping two neighboring characters.
     * Adds matches to the list of near misses.
     *
     * @param word       word to swap chars in
     * @param nearMisses list to add match to
     */
    private void addSwapCharsMatches(final String word, final THA3LinkedList<String> nearMisses) {
        String newWord;
        for (int i = 0; i < word.length() - 1; i++) {
            newWord = word.substring(0, i)
                    + word.charAt(i + 1)
                    + word.charAt(i)
                    + word.substring(i + 2);
            if (this.isCorrect(newWord)) {
                nearMisses.addLast(newWord);
            }
        }
    }

    /**
     * Construct every pair of strings that can be made by inserting a space into the word.
     * If both resulting words are in the dictionary, add the pair to the list of near misses.
     *
     * @param word       word to split
     * @param nearMisses list to add match to
     */
    private void addMissedSpaceMatches(final String word, final THA3LinkedList<String> nearMisses) {
        String firstWord;
        String secondWord;
        for (int i = 1; i < word.length(); i++) {
            firstWord = word.substring(0, i);
            secondWord = word.substring(i);
            if (this.isCorrect(firstWord) && this.isCorrect(secondWord)) {
                nearMisses.addLast(firstWord + " " + secondWord);
            }
        }
    }

    /**
     * Loads the dictionary from a file to class hash table
     */
    private void loadDictionary() {
        int tableSize = getNextPrime((int) (countLines(this.wordFilePath) * 0.8));
        this.dictionary = new THOpenHashTable(tableSize);
        loadWordsToHashTable(this.wordFilePath, this.dictionary);
    }

    /**
     * Counts the number of lines in a file
     *
     * @param filePath path to file
     *
     * @return number of lines in file
     *
     * @throws RuntimeException if file could not be read
     */
    private static int countLines(String filePath) {
        Path path = Paths.get(filePath);

        try (Stream<String> lines = Files.lines(path)) {
            return (int) lines.count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads words from a file to a hash table
     *
     * @param filePath  path to file
     * @param hashTable hash table to load words to
     *
     * @throws RuntimeException if file could not be read
     */
    private static void loadWordsToHashTable(String filePath, THOpenHashTable hashTable) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(line -> hashTable.add(line.toLowerCase()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the next prime number from the given number
     *
     * @param number number to start from (inclusive)
     *
     * @return the next prime number from the given number
     */
    private static int getNextPrime(int number) {
        if (number % 2 == 0) {
            number++;
        }
        while (!isPrime(number)) {
            number += 2;
        }
        return number;
    }

    /**
     * Checks if a number is a prime number
     *
     * @param number number to check
     *
     * @return true if number is a prime number, false otherwise
     */
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else if (number <= 3) {
            return true;
        } else if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dictionary from: %s")
                .append(this.wordFilePath)
                .append("\nDictionary size: %d")
                .append(this.dictionary.size())
                .append("\nDictionary: %s").append(this.dictionary);
        return sb.toString();
    }
}
