public class ez977SquaresofaSortedArray {

    public static void main(String[] args) {

    }

    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        int[] result = new int[nums.length];
        for (int k = nums.length - 1; k >= 0; k--) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                result[k] = nums[i] * nums[i];
                i++;
            }else{
                result[k] = nums[j] * nums[j];
                j--;
            }
        }
        return  result;
    }
}
