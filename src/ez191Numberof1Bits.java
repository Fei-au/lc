public class ez191Numberof1Bits {

    public static void main(String[] args) {
        int n = 255;
        ez191Numberof1Bits test = new ez191Numberof1Bits();
        System.out.println(test.hammingWeight(11));
        System.out.println(0b10111111111111111111111111111111);
        int a = 0b10111111111111111111111111111111;
        String str = "10111111111111111111111111111111";
        System.out.println(Integer.parseUnsignedInt(str, 2));
        System.out.println(a);
    }

    public int hammingWeight(int n) {
        int result = 0;
        while (n!=0){
                result = (n&1) + result;
                n = n >>> 1;
        }
        return result;
    }
}
