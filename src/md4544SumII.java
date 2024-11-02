import java.util.HashMap;
import java.util.Map;

public class md4544SumII {

    public static void main(String[] args) {

    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums1.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hm.put(nums3[i] + nums4[j],hm.getOrDefault(nums3[i] + nums4[j], 0)+1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(hm.get(-nums1[i]-nums2[j]) != null){
                    count+=hm.get(-nums1[i]-nums2[j]);
                }
            }
        }
        return count;
    }
}
