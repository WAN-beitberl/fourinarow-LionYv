public class GameBoard {
    int[][]board;
    public GameBoard(int row, int col)
    {
        board = new int[row][col];
    }
    public void placePiece(int row, int col, int value) {
        board[row][col] = value;
    }

    public void printBoard()
    {
        System.out.println("--------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }
    public boolean isFull()
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0){return false;}
            }
        }
            return true;
    }


}
