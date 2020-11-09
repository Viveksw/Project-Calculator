public class StringCalculator {
    public int add(String numbers) {

        if("".equals(numbers))
            return 0;
        String[] nums = numbers.split(",");
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
