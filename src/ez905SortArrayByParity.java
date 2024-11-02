public class ez905SortArrayByParity {


    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        ez905SortArrayByParity test = new ez905SortArrayByParity();
        int[] result = test.sortArrayByParity(nums);
        for (int i :
                result) {
            System.out.println(i);
        }
    }


    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while (left < right){
            while(left < right && (nums[left] % 2 == 0)){
                left ++;
            }
            while (right > 0 && (nums[right] % 2 != 0)){
                right --;
            }
            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
