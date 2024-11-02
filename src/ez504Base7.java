public class ez504Base7 {

    public static void main(String[] args) {
        int num = -10;
        ez504Base7 test = new ez504Base7();
        String r = test.convertToBase7(num);
        System.out.println(r);
    }

    public String convertToBase7(int num) {
//        String result = "";
//        boolean isNegative = num < 0;
//        if(num < 0){
//            num = num*-1;
//        }
//        while (num >= 7){
//            result = (num % 7) + result;
//            num = num / 7;
//        }
//        return isNegative ? "-" + num + result : num + result;

        if(num < 0) return "-" + convertToBase7(-num);
        if(num < 7) return Integer.toString(num);
        return convertToBase7(num / 7) + Integer.toString(num % 7);
    }
}
