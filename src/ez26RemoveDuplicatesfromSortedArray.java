public class ez26RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        ez26RemoveDuplicatesfromSortedArray test = new ez26RemoveDuplicatesfromSortedArray();
        int result = test.removeDuplicates(nums);
        System.out.println("result is: "+result);
    }

    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1] != nums[i]){
                nums[i-k] = nums[i];
            }else{
                k++;
            }
        }

        return nums.length - k;
    }
}
