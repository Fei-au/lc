import java.util.ArrayList;
import java.util.List;

public class ez118PascalTriangle {
    public static void main(String[] args) {
        ez118PascalTriangle test = new ez118PascalTriangle();
        List<List<Integer>> l = test.generate(5);
        System.out.println("hh");
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> l = new ArrayList<>(numRows);
        List<Integer> l0 = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            l0.add(1);
            for (int j = l0.size()-2; j >= 1; j--) {
                l0.set(j, l0.get(j)+l0.get(j-1));
            }
            l.add(new ArrayList<>(l0));
        }
        return l;

//        List<List<Integer>> l = new ArrayList<>(numRows);
//        List<Integer> l0 = new ArrayList<>();
//        l0.add(1);
//        l.add(l0);
//        for (int i = 1; i < numRows; i++) {
//            List<Integer> tempL = new ArrayList<>(i+1);
//            tempL.add(1);
//            List<Integer> lastL = l.get(i-1);
//            for (int j = 1; j < lastL.size(); j++) {
//                tempL.add(lastL.get(j-1) + lastL.get(j));
//            }
//            tempL.add(1);
//            l.add(tempL);
//        }
//        return l;
    }
}