import java.util.Arrays;
import java.util.HashSet;

public class ez1346CheckIfNandItsDoubleExist {
    public static void main(String[] args) {
        int[] nums = {3,1,7,2};

        ez1346CheckIfNandItsDoubleExist test = new ez1346CheckIfNandItsDoubleExist();
        boolean result = test.checkIfExist(nums);
        System.out.println(result);
    }


    public boolean checkIfExist(int[] arr) {

        //solution2
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(hs.contains(arr[i] * 2) || (arr[i]%2 == 0 && hs.contains(arr[i] / 2))){
                return true;
            }else{
                hs.add(arr[i]);
            }
        }
        return false;

        // solution1
//        for (int i = 0; i < arr.length; i++) {
//            if(checkn(arr, i)){
//                return true;
//            }
//        }
//        return false;
    }

    public static boolean checkn(int[] arr, int index){
        for (int i = 0; i < arr.length; i++) {
            if(i == index){
                continue;
            }
            if(arr[i] == arr[index]*2){
                return true;
            }
        }
        return false;
    }
}
