import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ez557ReverseWordsinaStringIII {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ez557ReverseWordsinaStringIII test = new ez557ReverseWordsinaStringIII();
        System.out.println(test.reverseWords(s));
    }

    public String reverseWords(String s) {
        // Change string to chars array, then change every word
        char[] chars = s.toCharArray();
        int wordStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                reverse(chars, wordStartIndex, i-1);
                wordStartIndex = i + 1;
            }
        }
        reverse(chars, wordStartIndex, chars.length - 1);
        return new String(chars);

        // 先切开单词，再reverse每一个单词，再拼接起来
        // String[] words = s.split(" ");
        // for (int i = 0; i < words.length; i++) {
        //     words[i] = reverse(words[i]);
        // }
        // return String.join(" ", words);

        // reverse所有，再切开，再反着拼接起来
//        s = reverse(s);
//        String[] words = s.split(" ");
//        Collections.reverse(Arrays.asList(words));
//        return String.join(" ", words);
    }

    public String reverse (String str){
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public void reverse(char[] chars, int start, int end){
        while(start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
