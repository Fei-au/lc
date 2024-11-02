import java.util.HashMap;
import java.util.Map;

public class ez1TwoSum {
    public static void main(String[] args) {
        ez1TwoSum test = new ez1TwoSum();

        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = test.twoSum(nums, target);

        for (int i :
                result) {
            System.out.println(i);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(hm.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = hm.get(target - nums[i]);
                return result;
            }
            hm.put(nums[i], i);
        }
        return result;

    }
}
