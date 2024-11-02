public class ez338CountingBits {

    public static void main(String[] args) {
        int n = 64;
        ez338CountingBits test= new ez338CountingBits();
        test.countBits(n);

    }

    public int[] countBits(int n) {
        int[] arr = new int[n+1];
//        for (int i = 0; i < arr.length; i++) {
//            int j = i;
//            int temp = 0;
//            while (j > -1){
//                if(((i>>j) & 1) == 1){
//                    ++temp;
//                }
//                --j;
//            }
//            arr[i] = temp;
//        }


        for (int i = 0; i < arr.length; i++) {
            arr[i] = countOnes(i);
        }
        return arr;
    }

    public int countOnes (int n){
        int ones = 0;
        while (n!=0){
            n &= n-1;
            ones++;
        }
        return ones;
    }
}
