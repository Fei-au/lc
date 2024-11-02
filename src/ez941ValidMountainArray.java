public class ez941ValidMountainArray {
    public static void main(String[] args) {
        int[] nums = {0,3,2,1};
        ez941ValidMountainArray test = new ez941ValidMountainArray();
        boolean result = test.validMountainArray(nums);
        System.out.println(result);
    }

    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n-1;
        while (i+1 < n && arr[i] < arr[i+1]){
            i++;
        }
        while(j-1 >= 0 && arr[j] < arr[j-1]){
            j--;
        }
        return i > 0 && j < n-1 && i == j;


        //solution1
//        int maxIndex = 0;
//        boolean up = false;
//        boolean down = false;
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[maxIndex] < arr[i]){
//                maxIndex = i;
//            }
//        }
//        for(int i = 1; i <= maxIndex; i++){
//            if(arr[i] <= arr[i-1]){
//                return false;
//            }
//            up = true;
//        }
//
//        for(int i = maxIndex+1; i < arr.length; i++){
//            if(arr[i] >= arr[i-1]){
//                return false;
//            }
//            down = true;
//        }
//        return up && down;

        // solution2

//        if(arr.length < 3){
//            return false;
//        }
//        boolean door = true;
//        boolean up = false;
//        boolean down = false;
//        for (int i = 1 ; i < arr.length; i++) {
//            if(arr[i] == arr[i-1]){
//                return false;
//            }
//            if(door){
//                if(arr[i] > arr[i-1]){
//                    up = true;
//                }else{
//                    door = false;
//                    down = true;
//                }
//            }else{
//                if(arr[i] > arr[i-1]){
//                    return false;
//                }
//            }
//        }
//        return up && down;
    }
}
