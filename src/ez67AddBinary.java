public class ez67AddBinary {

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        ez67AddBinary test = new ez67AddBinary();
        String result = test.addBinary(a, b);
        System.out.println(result);
    }

    public String addBinary(String a, String b) {
        // 注意题目字符长度，超过了32 int 4个byte的长度，long 8 字节 64的长度。所以是不考虑最前面正负号的单纯正数相加
        // String to number
        // add two numbers
        // number to binary string


        // 用进位
        int al = a.length() - 1;
        int bl = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int sum;
        int carry = 0;
        while (al >= 0 || bl >= 0 ){
            sum = carry;
            if (al >= 0){
                sum+=a.charAt(al--) - '0';
            }

            if (bl >= 0){
                sum+=b.charAt(bl--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0){
            sb.append(carry);
        }

        return  sb.reverse().toString();
    }

    public Long stringToNum(String a){
        Long numA = 0l;
        for (int i = 0; i < a.length(); i++) {
            numA += (long)(Integer.parseInt(a.substring(a.length()-1-i, a.length() - i)) * Math.pow(2, i));
        }
        return numA;
    }

    public String numTobinaryString(Long a){
        StringBuilder sb = new StringBuilder();
        if(a == 0){
            return  "0";
        }
        while (a!=0){
            Long remainder = a % 2;
            sb.insert(0, remainder);
            a /= 2;
        }
        return sb.toString();
    }
}
