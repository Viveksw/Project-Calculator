public class StringCalculator {
    public int add(String numbers) {
        if(numbers.length() > 0){
            return Integer.parseInt(numbers);
        }
        return 0;
    }
}
