package ca.hccis.util;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

/**
 * Has some useful methods to be used in our programs.
 *
 * @author bjmaclean
 * @since Oct 19, 2021
 */
public class CisUtility {

    private static Scanner input = new Scanner(System.in);

    /**
     * Convert the inputString string to a string that has the first letter capitalized and
     * the remainder lower case
     */
    public static String convertToFirstLetterUppercase(String inputString) {
        inputString = inputString.toLowerCase();
        String firstLetterString = inputString.substring(0, 1);
        firstLetterString = firstLetterString.toUpperCase();
        String restOfString = inputString.substring(1);
        inputString = firstLetterString + restOfString;
        return inputString;
    }

    /**
     * Return the default currency String value of the double passed in as a
     * parameter.
     *
     * @param inputDouble double to be formatted
     * @return String in default currency format
     * @author BJM
     * @since 20211020
     */
    public static String toCurrency(double inputDouble) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(inputDouble);
    }

    /**
     * Get input from the user using the console
     *
     * @param prompt Prompt for the user
     * @return String entered by the user
     * @author BJM
     * @since 20211020
     */
    public static String getInputString(String prompt) {

        System.out.println(prompt + " -->");
        String output = input.nextLine();
        return output;
    }

    /**
     * Get input from the user using the console
     *
     * @param prompt Prompt for the user
     * @return The double entered by the user
     * @author BJM
     * @since 20211020
     */
    public static double getInputDouble(String prompt) {

        String inputString = getInputString(prompt);
        double output = Double.parseDouble(inputString);
        return output;
    }

    /**
     * Get input from the user using the console
     *
     * @param prompt Prompt for the user
     * @return The double entered by the user
     * @author BJM
     * @since 20211020
     */
    public static int getInputInt(String prompt) {

        String inputString = getInputString(prompt);
        int output = Integer.parseInt(inputString);
        return output;
    }

    /**
     * Get input boolean from the user using the console
     *
     * @param prompt Prompt for the user
     * @return boolean as specified by user input
     * @author BJM
     * @since 20211108
     */
    public static boolean getInputBoolean(String prompt) {

        String inputString = getInputString(prompt + " (y/n)");
        if (inputString.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get input boolean from the user using the console
     *
     * @param prompt Prompt for the user
     * @return boolean as specified by user input
     * @author BJM
     * @since 20211108
     */
    public static boolean getInputBoolean(String prompt, boolean askUntilValid) {

        String inputString = getInputString(prompt + " (y/n)");

        if (askUntilValid) {
            while (!(inputString.equalsIgnoreCase("y")
                    || inputString.equalsIgnoreCase("n"))) {
                inputString = getInputString("Invalid entry-" + prompt + " (y/n)");
            }
            boolean valueEntered = inputString.equalsIgnoreCase("y");
            return valueEntered;
        } else {
            if (inputString.equalsIgnoreCase("y")) {
                return true;
            } else {
                return false;
            }
        }
    }


    /**
     * Get input boolean from the user using the console
     *
     * @param prompt Prompt for the user
     * @return boolean as specified by user input
     * @author BJM
     * @since 20211108
     */
    public static boolean getInputBoolean(String prompt, String affirmative, String negative) {

        String inputString = getInputString(prompt + " (" + affirmative + "/" + negative + ")");
        if (inputString.equalsIgnoreCase(affirmative)) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * Provide today's date in the specified format
     *
     * @param format Date format desired
     * @return Today's date in specified format
     * @author BJM
     * @since 20211021
     */
    public static String getTodayString(String format) {
        //https://www.javatpoint.com/java-get-current-date

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

    }

    /**
     * Get a random number between min and max
     *
     * @author BJM
     * @since 20211109
     */
    public static int getRandom(int min, int max) {
        Random rand = new Random();
        int theRandomNumber = rand.nextInt((max - min) + 1) + min;
        return theRandomNumber;
    }


}
