public class ez27RemoveElement {
    public static void main(String[] args) {

        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        ez27RemoveElement test = new ez27RemoveElement();
        int k = test.removeElement(nums, val);

        System.out.println("k value is: " + k);
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
