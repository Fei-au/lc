import java.util.*;

public class ez219ContainsDuplicateII {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 2;
        ez219ContainsDuplicateII test = new ez219ContainsDuplicateII();
        boolean result =  test.containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                return true;
            }
            if(i >= k) set.remove(nums[i-k]);
        }
        return false;

//        Map<Integer,Integer> hm = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int first = hm.getOrDefault(nums[i], i);
//            if(i-first > 0 && i-first <= k){
//                return true;
//            }
//            hm.put(nums[i], i);
//        }
//
//        return false;
    }
}
