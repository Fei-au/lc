
public class md151ReverseWordsinaString {


    public static void main(String[] args) {


        md151ReverseWordsinaString test = new md151ReverseWordsinaString();

        String result = test.reverseWords("  this is    an  example  ");
        System.out.println(result);
    }

    public String reverseWords(String s) {

        char[] c = s.toCharArray();

        reverse(c, 0, c.length - 1);
        reverseWords(c, c.length);
        String result = cleanSpace(c, c.length);
        return result;

//        StringBuilder sb = new StringBuilder();
//
//        int start = s.length()-1;
//        int end = s.length()-1;
//
//        while(end >= 0){
//            while(end >= 0 && s.charAt(end) == ' '){
//                end--;
//            }
//            if(end == -1){
//                break;
//            }
//            start = end;
//            while(start >=0 && s.charAt(start) != ' '){
//                start--;
//            }
//            sb.append(s.substring(start +1, end+1));
//            sb.append(" ");
//            end = start-1;
//        }
//
//        String str = sb.toString();
//        return str.substring(0, str.length() - 1);

    }



    String cleanSpace(char[] c, int len){
        int i = 0, j = 0;
        while(j<len){
            while(j<len && c[j] == ' ')j++;
            while(j<len && c[j] != ' '){
                c[i++] = c[j++];
            }
            while(j<len && c[j] == ' ')j++;
            if(j<len)c[i++] = ' ';
        }
        return String.valueOf(c).substring(0, i);
    }

    void reverseWords(char[] c, int len){
        int i = 0, j = 0;

        while(j < len){
            while(i<j || (i<len && c[i] == ' '))i++;
            while(j<i || (j<len && c[j] != ' '))j++;
            // "good example"
            // "  good example "
            if(i<j)reverse(c, i, j-1);
        }
    }

    void reverse(char[] c, int start, int end){
        while(start < end){
            char temp = c[start];
            c[start++] = c[end];
            c[end--] = temp;
        }
    }
}
