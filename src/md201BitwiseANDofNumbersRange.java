public class md201BitwiseANDofNumbersRange {

    public static void main(String[] args) {
        int a = 1;
        int b = 124354234;
//        System.out.println(Math.log(a));
//        System.out.println(Math.log(b));
//        System.out.println((int)(Math.log(a) / Math.log(b)));
        md201BitwiseANDofNumbersRange test = new md201BitwiseANDofNumbersRange();
        int result = test.rangeBitwiseAnd(a,b);
        System.out.println(result);

//        System.out.println(5>>1 & 1);
    }

    public int rangeBitwiseAnd(int left, int right) {
//        int shift = 0;
//        while (left != 0){
//            if(left == right){
//                break;
//            }
//            left>>=1;
//            right>>=1;
//            shift++;
//        }
//        while (shift!=0){
//            left = left << 1;
//            shift--;
//        }
//        return left;

        // Brian Kernighan

        while (left < right){
            right &= right-1;
        }
        return right;
    }
}
