package lab5;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private char[][] board;
    public boolean checkRows() { 
        for(int i = 0; i < board.length; i++){
            if(board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                return true;
            }
        }
        return false;
    }
    public boolean checkColumns(){
        for(int i = 0; i < board.length; i++){
            if(board[0][i] != EMPTY && board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                return true;
            }
        }
        return false;
    }
    public boolean checkDiagonals(){
        if(board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            return true;
        }
        if(board[0][2] != EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        boolean isWin = false;
        TicTacToe game = new TicTacToe();
        game.board = new char[][]{
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'O', 'X', 'X'}
        };
        isWin = game.checkRows() || game.checkColumns() || game.checkDiagonals();
        System.out.println(isWin);
    }
}
