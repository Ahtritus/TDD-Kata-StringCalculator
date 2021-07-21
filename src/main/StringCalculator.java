package main;

public class StringCalculator {
    public static int Add(String numbers) {
        //checks if input string numbers is empty
        if (numbers == null || numbers.length() == 0) {
            return 0;
        }

        //splits the input string into a list of numbers
        //each number is separated by a non digit character
        String[] split_numbers = numbers.split("[,\n]+");
        //initializes the sum of the numbers
        int sum = 0;

        //iterates through the list of numbers and calculates the sum
        for (String number : split_numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
