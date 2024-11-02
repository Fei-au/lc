import java.util.HashMap;
import java.util.Map;

public class ez387FirstUniqueCharacterinaString {

    public static void main(String[] args) {
        String s = "leetcode";
        ez387FirstUniqueCharacterinaString test = new ez387FirstUniqueCharacterinaString();
        int firUnicChar = test.firstUniqChar(s);
        System.out.println(firUnicChar);
    }

    public int firstUniqChar(String s) {

        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] == 1){
                return i;
            }
        }
        return -1;

//        Map<Character, Integer> hm = new HashMap<>();
//        char c;
//        for (int i = 0; i < s.length(); i++) {
//            c = s.charAt(i);
//            if(hm.containsKey(c)){
//                hm.put(c, i*-1);
//            }else{
//                hm.put(c, i);
//            }
//        }
//        int min = Integer.MAX_VALUE;
//        for (Character character:
//             hm.keySet()) {
//            if(hm.get(character) >= 0){
//                min = hm.get(character) <= min ? hm.get(character) : min;
//            }
//        }
//        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
