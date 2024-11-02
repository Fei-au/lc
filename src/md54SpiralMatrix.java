import java.util.ArrayList;
import java.util.List;

public class md54SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        md54SpiralMatrix test = new md54SpiralMatrix();
        List<Integer> l = test.spiralOrder(matrix);
        System.out.println('h');

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        // 一圈一圈绕
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> l = new ArrayList<>();
        while (top <= down && left<=right){
            for (int i = left; i <= right; i++) {
                l.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= down ; i++) {
                l.add(matrix[i][right]);
            }
            right--;

            for (int i = right; i >= left && top <= down; i--) {
                l.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i>= top && left <= right; i--) {
                l.add(matrix[i][left]);
            }
            left++;
        }
        return l;

        // 每个rxc矩阵都是由最外层+r-2xc-2矩阵组成，递归即可
//        int r = matrix.length;
//        int c = matrix[0].length;
//
//        int[] tp = {0,0};
//        int[] br =  {r-1, c-1};
//        return order(matrix,tp, br);
    }

    public List<Integer> order(int[][] matrix, int[] topLeft, int[] bottomRight){
        int c = bottomRight[1] - topLeft[1];
        int r = bottomRight[0] - topLeft[0];
        if(c<0 || r<0){
            return null;
        }
        List<Integer> l = new ArrayList<>();
        for (int i = topLeft[1]; i <= bottomRight[1]; i++) {
            l.add(matrix[topLeft[0]][i]);
        }
        for (int i = topLeft[0]+1; i <= bottomRight[0]; i++) {
            l.add(matrix[i][bottomRight[1]]);
        }
        for (int i = bottomRight[1] -1; i >= topLeft[1] && r>0; i--) {
            l.add(matrix[bottomRight[0]][i]);
        }
        for (int i = bottomRight[0] -1; i >= topLeft[0]+1 && c>0; i--) {
            l.add(matrix[i][topLeft[1]]);
        }
        int[] tl = {topLeft[0]+1, topLeft[1]+1};
        int[] br = {bottomRight[0]-1, bottomRight[1]-1};
        List<Integer> nl = order(matrix, tl, br);
        if(nl !=null){
            l.addAll(nl);
        }
        return l;
    }

    public void diagonalManipulate (int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[0].length; j++) {
                swap(matrix, i,j);
            }
        }
    }

    public void upDownSwap(int[][] matrix){
        for (int i = 0; i < matrix.length / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 -i];
            matrix[matrix.length - 1 -i] = temp;
        }
    }

    public void swap (int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
