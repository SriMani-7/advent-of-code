package aoc.y2023;

import aoc.Puzzle;

import java.io.IOException;

/**
 * --- Day 1: Trebuchet?! ---
 * <p>
 * See : <a href="https://adventofcode.com/2023/day/1">Advent of code 2023: day 1</a>
 */
public class Day01 {

    static final String[] digits = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static int calibrationValue(String line) {
        int left = 0;
        int right = 0;
        int length = line.length();
        for (int start = 0, end = length - 1; start < length - 1 && end >= 0; start++, end--) {
            int c = Character.digit(line.charAt(start), 10);
            int r = Character.digit(line.charAt(end), 10);
            if (c > -1 && left == 0) left = c;
            if (r > -1 && right == 0) right = r;
            if (left != 0 && right != 0) break;
        }
        if (left == 0) left = right;
        else if (right == 0) right = left;
        return left * 10 + right;
    }

    public static int calibrationValueText(String line) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < line.length(); i++) {
            int c = Character.digit(line.charAt(i), 10);
            if (c > -1) {
                if (first == -1) first = c;
                last = c;
            }
            for (int j = 0; j < digits.length; j++) {
                if (line.startsWith(digits[j], i)) {
                    if (first == -1) first = j + 1;
                    last = j + 1;
                }
            }
        }
        return first * 10 + last;
    }

    public static void main(String[] args) throws IOException {
        var testInput = Puzzle.getTextInputFilePath(2023, 1);
        var input = Puzzle.getInputFilePath(2023, 1);

        // Part 1: Calculate calibration value based on digits.
        Puzzle.printAnswer(testInput, Day01::calibrationValue);
        Puzzle.printAnswer(input, Day01::calibrationValue);

        // Part 2: Calculate calibration value based on text representations.
        Puzzle.printAnswer(testInput, Day01::calibrationValueText);
        Puzzle.printAnswer(input, Day01::calibrationValueText);
    }
}
