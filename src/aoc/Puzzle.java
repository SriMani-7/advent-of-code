package aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.ToIntFunction;

/**
 * The Puzzle interface provides utility methods for solving Advent of Code puzzles.
 */
public interface Puzzle {

    /**
     * Reads input from a file, applies a calculation function to each line, and returns the sum of the results.
     *
     * @param inputFile The path to the input file.
     * @param cal       The calculation function to be applied to each line.
     * @return The sum of the results after applying the calculation function to each line.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    static int getAnswerForInput(Path inputFile, ToIntFunction<String> cal) throws IOException {
        return Files.newBufferedReader(inputFile)
                .lines()
                .mapToInt(cal)
                .sum();
    }

    /**
     * Reads input from a file, applies a calculation function to each line, and prints the sum of the results.
     *
     * @param inputFile The path to the input file.
     * @param cal       The calculation function to be applied to each line.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    static void printAnswer(Path inputFile, ToIntFunction<String> cal) throws IOException {
        System.out.println(getAnswerForInput(inputFile, cal));
    }

    /**
     * Returns the path to the test input file for a specific year and day.
     *
     * @param year The year of the Advent of Code puzzle.
     * @param day  The day of the Advent of Code puzzle.
     * @return The path to the test input file.
     */
    static Path getTextInputFilePath(int year, int day) {
        return Path.of("input", "y" + year, "day" + day + "_test.txt");
    }

    /**
     * Returns the path to the input file for a specific year and day.
     *
     * @param year The year of the Advent of Code puzzle.
     * @param day  The day of the Advent of Code puzzle.
     * @return The path to the input file.
     */
    static Path getInputFilePath(int year, int day) {
        return Path.of("input", "y" + year, "day" + day + ".txt");
    }
}
