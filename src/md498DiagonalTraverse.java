public class md498DiagonalTraverse {

    public static void main(String[] args) {
        md498DiagonalTraverse test = new md498DiagonalTraverse();
        int[][] t = new int[2][2];
        t[0][0] = 1;
        t[0][1] = 2;
        t[1][0] = 3;
        t[1][1] = 4;
        test.findDiagonalOrder(t);
    }
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int i = 0, j = 0;
        int cur = 0;
        boolean dirRight = true;
        while (i < m && j < n) {
            result[cur++] = mat[i][j];
            if (dirRight) {
                if (i - 1 >= 0 && j + 1 < n) {
                    i--;
                    j++;
                    continue;
                }
                if (i - 1 < 0 && j + 1 < n) {
                    j++;
                }else if(j+1 ==n) {
                    i++;
                }
//                 if(j+1 ==n){
//                     i++;
//                 }
//                if (i - 1 >= 0 && j + 1 == n) {
//                    i++;
//                }
//                if (i - 1 < 0 && j + 1 == n) {
//                    i++;
//                }
                dirRight = false;
            } else {
                if (i + 1 < m && j - 1 >= 0) {
                    i++;
                    j--;
                    continue;
                }
                 if(i+1 == m){
                     j++;
                 }else if(j - 1 < 0){
                     i++;
                 }
//                if (i + 1 < m && j - 1 < 0) {
//                    i++;
//                }

//                if (i + 1 == m && j - 1 >= 0) {
//                    j++;
//                }
//                if (i + 1 == m && j - 1 < 0) {
//                    j++;
//                }

                dirRight = true;
            }
        }
        return result;
    }

}
