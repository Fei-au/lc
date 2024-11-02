import java.util.HashSet;
import java.util.Set;

public class ez136SingleNumber {


    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                set.remove(num);
            }
        }
        for (int num : set) {
            return num;
        }
        return 0;
    }
}
