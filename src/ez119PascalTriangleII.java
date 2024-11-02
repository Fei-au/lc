import java.util.ArrayList;
import java.util.List;

public class ez119PascalTriangleII {
    public static void main(String[] args) {
        ez119PascalTriangleII test = new ez119PascalTriangleII();
        List<Integer> l = test.getRow(4);
        for (Integer i :
                l) {
            System.out.println(i);
        }
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<>(rowIndex+1);
        for (int i = 0; i < rowIndex+1; i++) {
            l.add(1);
            for (int j =l.size() - 2; j >= 1 ; j--) {
                l.set(j, l.get(j-1) + l.get(j));
            }
        }
        return l;
    }
}
