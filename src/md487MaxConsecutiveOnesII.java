public class md487MaxConsecutiveOnesII {

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0};
        md487MaxConsecutiveOnesII test = new md487MaxConsecutiveOnesII();
        int result = test.findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }

    public int findMaxConsecutiveOnes(int[] nums){
        // solution1

//        int[] pre = new int[nums.length];
//        int[] suff = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] == 1){
//                if(i == 0){
//                    pre[i] = 1;
//                }else{
//                    pre[i] = pre[i-1] + 1;
//                }
//            }else{
//                pre[i] = 0;
//            }
//        }
//
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if(nums[i] == 1){
//                if(i == nums.length - 1){
//                    suff[i] = 1;
//                }else{
//                    suff[i] = suff[i+1] + 1;
//                }
//            }else{
//                suff[i] = 0;
//            }
//        }
//
//        if(pre[nums.length - 1] == nums.length){
//            return nums.length;
//        }
//
//        int ans = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] == 0){
//                int len = 0;
//                if(i > 0) {
//                    len+=pre[i-1];
//                }
//                if(i < nums.length -1){
//                    len+=suff[i+1];
//                }
//                ans = Math.max(len + 1, ans);
//            }
//        }
//        return ans;


        // 滑动窗口
        int max = 0;
        int len = 0;
        int nextStart = -1;
        boolean flipped = false;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] == 0){
                if(!flipped){
                    flipped = true;
                    len ++;
                    if(nextStart == -1){
                        nextStart = i;
                    }
                }else{
                    max = Math.max(max, len);

                    if(nums[nextStart] == 0){
                        len = i - nextStart;
                        max = Math.max(max, i - nextStart); // 0110 结束
                        nextStart = nextStart == i - 1 ? i : nextStart; // 00
                    }else{
                        len = i - nextStart + 1;
                        nextStart = i;
                    }
                }
            }else{
                if(flipped && len == 1){
                    nextStart = i;
                }
                len ++;
            }
        }
        max = Math.max(max, len);

        return max;
    }
}
