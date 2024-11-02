import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class CharToInt {
    public static void main(String[] args){
//        String a = "123";
//        int B = 345;
//        String b = String.valueOf(B);
//        int[] arr = {8,4,5,0,0,0,0,7};
//        duplicateZeros(arr);


        Random rm = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(rm.nextInt(3));
        }
    }

    public static int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }

//    public static int[] duplicateZeros(int[] arr) {
//        int [] result = new int[arr.length];
//        int j = 0;
//        for(int i = 0; i < arr.length; i++){
//            result[j] = arr[i];
//            if(arr[i]==0){
//                if(j+1 == arr.length){
//                    return result;
//                }
//                result[++j] = arr[i];
//            }
//            if(++j == arr.length){
//                return result;
//            }
//        }
//        return result;
//    }

    public static void duplicateZeros(int[] arr) {
        int dups = 0;
        int len = arr.length;
        for(int i = 0; i < len-1 - dups; i++){
            if(arr[i] == 0){
                if(i+1 == len-1 - dups){
                    arr[len-1] = 0;
                    len--;
                    break;
                }
                dups++;
            }
        }
        System.out.println("dups is" + dups);
        System.out.println("dups is" + len);

        for(int i = len-1; i >= 0; i--){
            if(arr[i - dups] == 0){
                arr[i] = 0;
                if(--i >= 1){
                    arr[i] = 0;
                }else{
                    break;
                }
                dups--;
            }else{
                arr[i] = arr[i-dups];
            }
        }

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
