public class ez674LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        ez674LongestContinuousIncreasingSubsequence test = new ez674LongestContinuousIncreasingSubsequence();
        int result = test.findLengthOfLCIS(nums);
        System.out.println(result);
    }

    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length){
            if(j > 0 && nums[j] >= nums[j-1]){
                i = j;
            }
            ans = Math.max(ans, j - i + 1);
            j++;

        }
        return ans;

//        int ans = 1;
//        int len = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i] > nums[i-1]){
//                len ++;
//            }else{
//                ans = Math.max(ans, len);
//                len = 1;
//            }
//        }
//        ans = Math.max(ans, len);
//        return ans;
    }
}
