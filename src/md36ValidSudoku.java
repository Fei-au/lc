import java.util.HashSet;

public class md36ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        md36ValidSudoku test = new md36ValidSudoku();
        boolean result = test.isValidSudoku(board);
        System.out.println(result);
    }


    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hs = new HashSet<>();
        // row
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                boolean isNewValue = hs.add(board[i][j]);
                if(!isNewValue){
                    return false;
                }
            }
            hs.clear();
        }
        // column
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[j][i] == '.'){
                    continue;
                }
                boolean isNewValue = hs.add(board[j][i]);
                if(!isNewValue){
                    return false;
                }
            }
            hs.clear();
        }
        // sub box
        for(int i = 0; i < board.length; i+=3){
            for(int j = 0; j < board.length; j+=3){
                boolean isValid = validSquare(board, new int[]{i, j});
                if(!isValid){
                    return false;
                }
            }
        }
        return true;
    }

    boolean validSquare(char[][] board, int[] start){
        HashSet<Character> hs = new HashSet<>();
        for(int i = start[0]; i < start[0] + 3; i++){
            for(int j = start[1]; j < start[1] + 3; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                boolean isNewValue = hs.add(board[i][j]);
                if(!isNewValue){
                    return false;
                }
            }
        }
        return true;
    }
}
