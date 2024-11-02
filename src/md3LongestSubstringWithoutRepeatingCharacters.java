import java.util.HashMap;
import java.util.Map;

public class md3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abba";
        md3LongestSubstringWithoutRepeatingCharacters test = new md3LongestSubstringWithoutRepeatingCharacters();
        int res = test.lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        // Two pointers, one slow as start index, the fast go retreive each char.
        // If the fast get one that in the hashmap and between the start index to fast pointer
        // it updates max len and start index as repeat char's next position.
        Map<Character,Integer> hm = new HashMap<>();
        int startIndex = 0;
        int maxLen = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(hm.containsKey(c) && hm.get(c) >= startIndex){
                maxLen = Math.max(i - startIndex,maxLen);
                startIndex = hm.get(c)+1;
            }
            hm.put(c,i);
        }
        maxLen = Math.max(s.length() - startIndex,maxLen);
        return maxLen;

//        Map<Character,Integer> hm = new HashMap<>();
//
//        int len = 0;
//        int maxLen = 0;
//        char c;
//        for (int i = 0; i < s.length(); i++) {
//            c = s.charAt(i);
//            if(!hm.containsKey(c)){
//                hm.put(c,i);
//                len++;
//
//            }else{
//                int startIndex = hm.get(c);
//                hm.clear();
//                maxLen = Math.max(len,maxLen);
//                len = 0;
//                for (int j = startIndex+1; j <= i ; j++) {
//                    hm.put(s.charAt(j),j);
//                    len++;
//                }
//            }
//        }
//        maxLen = Math.max(len,maxLen);
//
//        return maxLen;
    }
}
