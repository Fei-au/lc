import java.util.ArrayList;
import java.util.List;

public class ez448FindAllNumbersDisappearedinanArray {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        ez448FindAllNumbersDisappearedinanArray test = new ez448FindAllNumbersDisappearedinanArray();
        test.findDisappearedNumbers(nums);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i+1 && nums[i] != nums[nums[i] - 1]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                al.add(i+1);
            }
        }
        return al;


//        for (int i = 0; i < nums.length; i++) {
//            int index;
//            if (nums[i] < 0) {
//                index = nums[i] * -1 -1;
//            }else{
//                index = nums[i]-1;
//            }
//
//            nums[index] = nums[index] < 0 ? nums[index] : nums[index] * -1;
//        }
//
//        ArrayList<Integer> al = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] > 0){
//                al.add(i+1);
//            }
//        }
//        return al;
    }
}
