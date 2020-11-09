import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {

        if("".equals(numbers))
            return 0;

        String delimiter = ",|\n";
        if(numbers.contains("//")) {
            Pattern pattern = Pattern.compile("//(.)\\n(.*)");
            String[] numbersWithDeli = pattern.matcher(numbers).replaceAll("$1 $2").split(" ");
            numbers = numbersWithDeli[1];
            delimiter = numbersWithDeli[0];
            // handle special characters which has special meaning in regex
            if(".$^*!".contains(delimiter))
                delimiter = "\\"+delimiter;
        }

        String[] nums = numbers.split(delimiter);
        if(nums.length == 1)
            return Integer.parseInt(numbers);

        if(nums.length > 1){
            int result = 0;
            for(int count = 0; count < nums.length; count++){
                result += Integer.parseInt(nums[count]);
            }
            return result;
        }
        return -1;
    }
}
