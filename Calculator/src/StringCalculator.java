import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) throws Exception {

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
        if(nums.length == 1) {
            int number = Integer.parseInt(numbers);
            if(number < 0)
                throw new Exception("negatives not allowed:" + number);
            return number;
        }

        StringBuilder negativeNumbers = new StringBuilder();
        if(nums.length > 1){
            int result = 0;
            for(int count = 0; count < nums.length; count++){
                int num = Integer.parseInt(nums[count]);
                if(num < 0){
                    negativeNumbers.append(num).append(" ");
                }
                result += num;
            }
            if(!"".equals(negativeNumbers.toString()))
                throw new Exception("negatives not allowed:" + negativeNumbers);
            return result;
        }
        return -1;
    }
}
