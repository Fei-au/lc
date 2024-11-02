public class ez28FindtheIndexoftheFirstOccurrenceinaString {

    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        int len = needle.length();

        for (int i = 0; i < haystack.length() - (len-1); i++) {
            if(haystack.substring(i, i+1+len-1).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
