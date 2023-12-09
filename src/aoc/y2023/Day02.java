package aoc.y2023;

import aoc.Puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * --- Day 2: Cube Conundrum ---
 * <p>
 * See : <a href="https://adventofcode.com/2023/day/2">Advent of code 2023: day 2</a>
 */
public class Day02 {
    final static String regex = "(1[3-9] red)|(1[4-9] green)|(1[5-9] blue)|([2-9]\\d+ (red|green|blue))";
    final static Pattern part1Pattern = Pattern.compile(regex);
    final static Pattern part2Pattern = Pattern.compile("(\\d+) (red|green|blue)");

    public static int possibleGame(String line) {
        final Matcher matcher = part1Pattern.matcher(line);
        if (matcher.find()) return 0;
        else {
            var arr = line.split("[ :]",3);
            System.out.println(Arrays.toString(arr));
            return Integer.parseInt(arr[1]);
        }
    }

    public static int powerOfFewestCubes(String line) {
        int red = 1;
        int green = 1;
        int blue = 1;
        var matcher = part2Pattern.matcher(line);

        while (matcher.find()) {
            var value = Integer.parseInt(matcher.group(1));
            switch (matcher.group(2)) {
                case "red": red = Math.max(red, value); break;
                case "green": green = Math.max(green, value); break;
                case "blue": blue = Math.max(blue, value); break;
            }
        }
        return red*green*blue;
    }


    public static void main(String[] args) throws IOException {
        var testPath = Puzzle.getTextInputFilePath(2023, 2);
        var input = Puzzle.getInputFilePath(2023, 2);

        // Part 1 solution
//        Puzzle.printAnswer(testPath, Day02::possibleGame);
        Puzzle.printAnswer(input, Day02::possibleGame);

        // Part 2 solution
//        Puzzle.printAnswer(testPath, Day02::powerOfFewestCubes);
        Puzzle.printAnswer(input, Day02::powerOfFewestCubes);
    }
}
