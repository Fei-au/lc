import java.sql.Array;

public class md167TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        md167TwoSumIIInputArrayIsSorted test = new md167TwoSumIIInputArrayIsSorted();
        int[] res = test.twoSum(nums, 9);
        for (int i :
                res) {
            System.out.println(i);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (true){
            if(numbers[left] + numbers[right] > target){
                right --;
            }else if(numbers[left] + numbers[right] < target){
                left++;
            }else {
                return new int[]{left+1, right+1};
            }
        }
//        int a = 0;
//        int b = 0;
//        for (int i = 0; i < numbers.length; i++) {
//             a = numbers[i];
//            for (int j = i+1; j < numbers.length; j++) {
//                if(numbers[j] == target - a){
//                    return new int[]{i+1,j+1};
//                }
//            }
//        }
//        return new int[2];
    }
}
