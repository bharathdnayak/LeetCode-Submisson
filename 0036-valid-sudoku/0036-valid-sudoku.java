
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                boolean row=rowchecker(board,i,j);
                if(row==false){
                    return false;
                }
                boolean col=colchecker(board,i,j);
                if(col==false){
                    return false;
                }
                boolean box=boxchecker(board,i,j);
                if(box==false){
                    return false;
                }
            }
        }
        return true;
    }
    boolean boxchecker(char[][] board, int row, int col) {

    Set<Character> set = new HashSet<>();

    int startRow = (row / 3) * 3;
    int startCol = (col / 3) * 3;

    for (int i = startRow; i < startRow + 3; i++) {
        for (int j = startCol; j < startCol + 3; j++) {

            if (board[i][j] == '.') {
                continue;
            }

            if (set.contains(board[i][j])) {
                return false;
            }

            set.add(board[i][j]);
        }
    }

    return true;
}

    boolean rowchecker(char[][] board,int row,int col){
        Set<Character> set=new HashSet<>();
        for(int i=0;i<board.length;i++){
            if (board[row][i] == '.') {
            continue;
             }
            if(set.contains(board[row][i])){
                return false;
            }
            set.add(board[row][i]);
        }
        return true;
    }
    boolean colchecker(char[][] board,int row,int col){
        Set<Character> set=new HashSet<>();
        for(int i=0;i<board.length;i++){
            if (board[i][col] == '.') {
            continue;
             }
            if(set.contains(board[i][col])){
                return false;
            }
            set.add(board[i][col]);
        }
        return true;
    }
}
