import java.util.Arrays;
import java.util.HashMap;

public class ez169MajorityElement {

    public static void main(String[] args) {
        int [] nums = {2,2,3};
        ez169MajorityElement test = new ez169MajorityElement();
        int result  = test.majorityElement(nums);
        System.out.println(result);
    }

    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length/2];

        //

//        HashMap<Integer, Integer> hm = new HashMap<>();
//
//        for (int num : nums) {
//            hm.merge(num, 1, Integer::sum);
//        }
//        int max = -1;
//        int result = 0;
//        for (int key : hm.keySet()){
//            if(hm.get(key) > max){
//                max = hm.get(key);
//                result = key;
//            }
//        }
//        return result;

        int marjor = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if(count == 0){
                marjor = nums[i];
                count++;
            }else if(nums[i] != marjor){
                count--;
            }else{
                count++;
            }
        }
        return marjor;
    }
}
