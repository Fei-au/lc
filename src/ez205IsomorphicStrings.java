import java.util.HashMap;
import java.util.Map;

public class ez205IsomorphicStrings {

    public static void main(String[] args) {
        ez205IsomorphicStrings test = new ez205IsomorphicStrings();
        boolean result = test.isIsomorphic("abbca", "bccdb");
        System.out.println(result);
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hm = new HashMap<>();
//        StringBuilder sb = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//        int c = 97;
//        for (int i = 0; i < s.length(); i++) {
//            if(!hm.containsKey(s.charAt(i))){
//                hm.put(s.charAt(i), (char)c++);
//            }
//            sb.append(hm.get(s.charAt(i)));
//        }
//        c = 97;
//        hm.clear();
//        for (int i = 0; i < t.length(); i++) {
//            if(!hm.containsKey(t.charAt(i))){
//                hm.put(t.charAt(i), (char)c++);
//            }
//            sb2.append(hm.get(t.charAt(i)));
//        }
//
//        return sb.toString().equals(sb2.toString());

        for (int i = 0; i < s.length(); i++) {
            if(!hm.containsKey(s.charAt(i))) {
                if(hm.containsValue(t.charAt(i))){
                    return false;
                }
                hm.put(s.charAt(i), t.charAt(i));
                continue;
            }
            if(hm.get(s.charAt(i))  != t.charAt(i)){
                return false;
            }
        }
        return true;
    }

}
