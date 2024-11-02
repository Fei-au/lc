public class md75SortColors {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        md75SortColors test = new md75SortColors();
        test.sortColors(nums);
    }

    public void sortColors(int[] nums) {

        int len = nums.length;
        if (len < 2) {
            return;
        }
        int zero = -1;
        int two = len - 1;
        int i = -1;
        while (i < two) {
            if (nums[i+1] == 0) {
                zero++;
                swap(nums, i+1, zero);
                i++;
            } else if (nums[i+1] == 1) {
                i++;
            } else {
                swap(nums, i+1, two);
                two--;
            }
        }

//        int red = 0;
//        int white = 0;
//        int blue = 0;
//        for (int num : nums) {
//            switch (num){
//                case 0:
//                    red++;
//                    break;
//                case 1:
//                    white++;
//                    break;
//                case 2:
//                    blue++;
//                    break;
//            }
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if(red > 0){
//                nums[i] = 0;
//                red--;
//            }else if(white > 0){
//                nums[i] = 1;
//                white--;
//            }else if(blue > 0){
//                nums[i] = 2;
//                blue--;
//            }
//        }
        for (int num :
                nums) {
            System.out.println(num);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
