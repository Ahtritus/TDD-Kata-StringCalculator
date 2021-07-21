package main;

public class StringCalculator {
    public static int Add(String numbers) {
        //checks if input string numbers is empty
        if (numbers == null || numbers.length() == 0) {
            return 0;
        }

        //splits the input string into a list of numbers
        //each number is separated by a comma or new_line
        String all_splitters = "[,\n]+";

        //checks if the input string has a different delimiter
        //input string has a different delimiter if it starts with "//"
        //single number input string will not be checked
        if(numbers.length() > 2 && numbers.substring(0,2).equals("//")){
            //storing the new delimiter
            char current_delimiter = numbers.charAt(2);

            //creates a new string, all_splitters, containing the new delimiter along with "," and "\n"
            all_splitters = "[" + current_delimiter + ",\n]+";

            //removes the delimiter input format from the input string
            numbers = numbers.substring(4, numbers.length());
        }

        //splits the input string into a list of numbers
        //each number is separated by one of the characters in the all_splitters string
        String[] split_numbers = numbers.split(all_splitters);

        //initializes the sum of the numbers
        int sum = 0;
        String negative_numbers = "";
        boolean flag = false;
        
        //iterates through the list of numbers and calculates the sum
        for (String number : split_numbers) {
            int curr_number = Integer.parseInt(number);

            //checks if the input string has a negative number
            if (curr_number < 0) {
                negative_numbers += curr_number + ",";
                flag = true;
                continue;
            }
            if (!flag) {
                sum += curr_number;
            }
        }
        if (flag) {
            negative_numbers = negative_numbers.substring(0, negative_numbers.length() - 1);
            throw new IllegalArgumentException("Negatives not allowed: " + negative_numbers);
        }

        return sum;
    }
}
