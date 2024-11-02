public class ez485MaxConsecutiveOnes {
    public static void main(String[] args) {

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int right = 0;
        int max = 0;
        while (start<nums.length && right<nums.length){
            start = right;
            while (start<nums.length && nums[start] == 0){start++;}
            right = start;
            while (right<nums.length && nums[right] == 1){right++;}
            max = Math.max(right-start, max);
        }
        return max;
    }
}
