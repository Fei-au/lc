import java.util.*;

public class ez350IntersectionofTwoArraysII {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        ez350IntersectionofTwoArraysII test = new ez350IntersectionofTwoArraysII();
        int[] result = test.intersect(nums1,nums2);
        System.out.println(result);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int num :
                nums1) {
            if (hm.containsKey(num)) {
                hm.replace(num, hm.get(num) + 1);
            } else {
                hm.put(num, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList();

        for (int num :
                nums2) {
            if (hm.containsKey(num) && hm.get(num)>0) {
                hm.replace(num, hm.get(num) - 1);
                list.add(num);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) result[i] = list.get(i);

        return result;
    }
}
