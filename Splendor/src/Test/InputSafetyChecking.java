package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class is use to check all the user input
// including correct integer input, correct string input for selecting tokens etc.
/**
 * The InputSafetyChecking class is used to check all user input for exceptions
 */

public class InputSafetyChecking {

    private static final String WHITE = "WHITE";
    private static final String BLUE = "BLUE";
    private static final String GREEN = "GREEN";
    private static final String RED = "RED";
    private static final String BLACK = "BLACK";

    /**
     * Returns a valid integer after checking for exceptions
     * @param sc Scanner
     * @param invalidPrompt Prompt if user input invalid
     * @return integer
     */
    public static int safeInt(Scanner sc, String invalidPrompt) {
        while (!sc.hasNextInt()) {
            sc.next();
            if (invalidPrompt != null && !invalidPrompt.isBlank()) {
                System.out.print(invalidPrompt);
            }
        }
        return sc.nextInt();
    }

    /**
     * Returns valid number within specified range
     * @param sc Scanner
     * @param minInclusive Minimum number of range inclusive
     * @param maxInclusive Maximum number of range inclusive
     * @param prompt Prompt for input
     * @return valid user input of number within the specified range
     */
    public static int readIntInRange(Scanner sc, int minInclusive, int maxInclusive, String prompt) {
        while (true) {
            if (prompt != null && !prompt.isBlank()) {
                System.out.print(prompt);
            }

            int color = safeInt(sc, "Please enter a valid number: ");
            sc.nextLine();
            if (color >= minInclusive && color <= maxInclusive) {
                return color;
            }
            System.out.println("Invalid choice, try again.");
        }
    }

    /**
     * Returns a list of 3 token colors if colors valid, null otherwise
     * @param rawInput String input of 3 token colors
     * @param takeColors String array of all token colors
     * @return list of 3 valid token colors, null otherwise
     */
    public static List<String> parseThreeColorsFlexibly(String rawInput, String[] takeColors) {

        if (rawInput == null) {
            return null;
        }

        String normalized = normalizeUpper(rawInput);
        if (normalized.isEmpty()) {
            return null;
        }

        String[] chunks = normalized.split("[^A-Z]+");
        ArrayList<String> colors = new ArrayList<>();

        for (String chunk : chunks) {
            if (chunk.isEmpty()) {
                continue;
            }

            int i = 0;
            while (i < chunk.length()) {
                String matched = matchColor(chunk, i);
                if (matched == null) {
                    return null;
                }
                colors.add(matched);
                i += matched.length();
            }
        }

        if (colors.size() != 3) {
            return null;
        }

        if (colors.get(0).equals(colors.get(1)) || colors.get(0).equals(colors.get(2))
                || colors.get(1).equals(colors.get(2))) {
            return null;
        }

        return colors;
    }

    /**
     * Returns uppercase of input without whitespaces in the front and back
     * @param input String input
     * @return input trimmed and uppercase
     */
    public static String normalizeUpper(String input) {
        if (input == null) {
            return "";
        }
        return input.trim().toUpperCase();
    }

    /**
     * Returns token color that matches with the start of the input from starting index
     * @param chunk String input
     * @param start Starting index of string input to look at
     * @return token color that matches with the start of the input from starting index
     */
    public static String matchColor(String chunk, int start) {
        if (chunk.startsWith(WHITE, start)) {
            return WHITE;
        }
        if (chunk.startsWith(BLUE, start)) {
            return BLUE;
        }
        if (chunk.startsWith(GREEN, start)) {
            return GREEN;
        }
        if (chunk.startsWith(RED, start)) {
            return RED;
        }
        if (chunk.startsWith(BLACK, start)) {
            return BLACK;
        }
        return null;
    }
}
