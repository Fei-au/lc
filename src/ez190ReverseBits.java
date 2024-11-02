public class ez190ReverseBits {

    public static void main(String[] args) {
        int n = 0b00000010100101000001111010011100;
        ez190ReverseBits test = new ez190ReverseBits();
        test.reverseBits(n);
    }

    public int reverseBits(int n) {
        int result = 0;
        int shift = 31;
        while (shift>= 0){
            result += (n&1) << shift;
            n = n>>>1;
            shift--;
        }
        return result;
    }
}
