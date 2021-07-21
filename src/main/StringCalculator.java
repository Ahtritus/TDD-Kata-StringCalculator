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
        if(numbers.length() > 2 && numbers.startsWith("//")){
            int delim_end_index = numbers.indexOf('\n');
            
            //storing the new delimiters
            String delimiters = "";
            for(int i = 0; i < delim_end_index; i++){
                //storing each unique delimiter
                if(delimiters.indexOf(numbers.charAt(i)) == -1){
                    delimiters += numbers.charAt(i);
                }
            }

            //creates a new string, all_splitters, containing the new delimiters along with "," and "\n"
            //the '+'' after [...] allows for multiple occurrences of the delimiters
            all_splitters = "[" + delimiters + ",\n]+";

            //removes the delimiter input-format from the input string
            numbers = numbers.substring(delim_end_index+1, numbers.length());
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
                //skipping number over 1000
                if (curr_number > 1000)
                    continue;

                sum += curr_number;
            }
        }
        
        //throw error if the input string has a negative number and also return the list of negative numbers
        if (flag) {
            negative_numbers = negative_numbers.substring(0, negative_numbers.length() - 1);
            throw new IllegalArgumentException("Negatives not allowed: " + negative_numbers);
        }

        //returns the sum of the numbers
        return sum;
    }
}
