import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ez599MinimumIndexSumofTwoLists {
    public static void main(String[] args) {
        String[] l1 = {"happy","sad","good"};
        String[] l2 = {"sad","happy","good"};

        ez599MinimumIndexSumofTwoLists test = new ez599MinimumIndexSumofTwoLists();

        String[] result = test.findRestaurant(l1,l2);
        for (String s :
                result) {
            System.out.println(s);
        }
    }


    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> hm = new HashMap<>();
        Map<String, Integer> hm2 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            hm.put(list1[i], i);
        }
        String s = "";
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            s = list2[i];
            if(hm.containsKey(s)){
                int v = hm.get(s)+i;
                if(v< min){
                    hm2.clear();
                    hm2.put(s,v);
                    min = v;
                }else if(v == min){
                    hm2.put(s, v);
                }
            }
        }

        return hm2.keySet().toArray(new String[0]);


//        Map<String, Integer> hm = new HashMap<>();
//        Map<String, Integer> hm2 = new HashMap<>();
//
//        for (int i = 0; i < list1.length; i++) {
//            hm.put(list1[i], i);
//        }
//        String s = "";
//        for (int i = 0; i < list2.length; i++) {
//            s = list2[i];
//            if(hm.containsKey(s)){
//                hm2.put(s,hm.get(s) + i);
//            }
//        }
//
//        int min = Integer.MAX_VALUE;
//        Set<String> set = new HashSet<>();
//        for (String str :
//                hm2.keySet()) {
//            if(hm2.get(str) < min){
//                set.clear();
//                set.add(str);
//                min = hm2.get(str);
//            }else if(hm2.get(str) == min){
//                set.add(str);
//            }
//        }
//        return set.toArray(new String[0]);
    }


}
