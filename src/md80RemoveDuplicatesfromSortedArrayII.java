public class md80RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        md80RemoveDuplicatesfromSortedArrayII test = new md80RemoveDuplicatesfromSortedArrayII();
        int result = test.removeDuplicates(nums);
        System.out.println("result is "+result);
    }

    public int removeDuplicates(int[] nums) {
        int k = 0;
        boolean hasShowTwice = false;

        for (int i = 1; i < nums.length; i++) {
            if(nums[k] != nums[i]){
                k++;
                nums[k] = nums[i];
                hasShowTwice = false;
            }else if(!hasShowTwice){
                k++;
                nums[k] = nums[i];
                hasShowTwice = true;
            }
        }

        return k + 1;
    }
}
