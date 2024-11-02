public class ez66PlusOne {


    public static void main(String[] args) {
         ez66PlusOne test = new ez66PlusOne();
         int[] digits = {9};
         test.plusOne(digits);
    }
    public int[] plusOne(int[] digits) {
        int addon = 0;
        for(int i = digits.length -1; i>=0; i--){
            if(i == digits.length -1){
                digits[i] = (digits[i] + 1) % 10;
                addon = (digits[i] + 1) / 10;
            }else{
                digits[i] = (digits[i] + addon) % 10;
                addon = (digits[i] + addon) / 10;
            }
            if(addon != 1){
                break;
            }
        }

        if(addon == 1){
            int[] newDigits = new int[digits.length +1];
            newDigits[0] = addon;
            for(int i = 1; i<newDigits.length; i++){
                newDigits[i] = digits[i-1];
            }
            return newDigits;
        }

        return digits;
    }
}
