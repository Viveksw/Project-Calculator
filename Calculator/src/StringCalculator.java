public class StringCalculator {
    public int add(String numbers) {
        if(numbers.length() > 0){
            String[] nums = numbers.split(",");
            if(nums.length == 2){
                return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
            }
            return Integer.parseInt(numbers);
        }
        return 0;
    }
}
