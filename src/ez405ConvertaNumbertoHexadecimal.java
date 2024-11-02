public class ez405ConvertaNumbertoHexadecimal {
    public static void main(String[] args) {
        int num = -1;
        ez405ConvertaNumbertoHexadecimal test = new ez405ConvertaNumbertoHexadecimal();
        String result = test.toHex(num);
        System.out.println(result);
//        System.out.println(Integer.toBinaryString(-1));

    }

    public String toHex(int num) {
        if(num==0)return "0";
        StringBuilder str = new StringBuilder();
        for (int i = 7; i >= 0 ; i--) {
            int val = num >> (i*4) & 0xf;
            if(str.length() > 0 || val > 0){
                char hx = hexChar(val);
                str.append(hx);
            }
        }
        return str.toString();
    }

    public char hexChar(int num) {
        if(num < 10){
            return (char)(num + '0');
        }else{
            return (char)(num - 10 + 'a');
        }
    }



}
