public class md209MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int target = 213;
        md209MinimumSizeSubarraySum test = new md209MinimumSizeSubarraySum();
        int result = test.minSubArrayLen(target,nums);
        System.out.println(result);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;
        int i = 0;
        while (j < nums.length){
            sum += nums[j++];
            while (sum >= target){
                sum -= nums[i++];
            }
            min = Math.min(min, j-i+1);
        }
        return min == Integer.MAX_VALUE ? 0: min;

//        while (left < nums.length && right<nums.length){
//            while (right < nums.length && sum < target){
//                sum += nums[right];
//                right++;
//            }
//            if(left == 0 && right == nums.length && sum < target){
//                return 0;
//            }
//            while (left<nums.length && sum >= target){
//                sum -= nums[left];
//                left++;
//            }
//
//            if(min != 0){
//                min = Math.min(min, right-left+1);
//            }else {
//                min = right - left+1;
//            }
//        }
//        return min;
    }
}
