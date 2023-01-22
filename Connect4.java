import java.util.Scanner;

public class Connect4 {
    static Scanner reader = new Scanner(System.in);

    public int findPlace(int col, int[][] board) {
        if (col >= 0 && col < board[0].length) {
            for (int i = board.length - 1; i >= 0; i--) {
                System.out.println(i + "," + col);
                if (board[i][col] == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean checkWin(int x, int y, int[][] board, int currentPlayer) {
        return checkUpAndSides(x, y, board, currentPlayer) || checkDiagonal(x, y, board, currentPlayer);
    }

    public boolean checkUpAndSides(int x, int y, int[][] board, int currentPlayer) {
        int sumHorizontal = 0;
        int sumVertical = 0;
        for (int i = 0; i < 4; i++) {
            if (x + i < board.length)
                sumHorizontal += board[x + i][y] == currentPlayer ? 1 : 0;
            if (y + i < board[0].length)
                sumVertical += board[x][y + i] == currentPlayer ? 1 : 0;
        }

        if (sumHorizontal == 4 || sumVertical == 4) {
            return true;
        }
        sumHorizontal = 0;
        sumVertical = 0;
        for (int i = -3; i <= 0; i++) {
            if (x + i >= 0)
                sumHorizontal += board[x + i][y] == currentPlayer ? 1 : 0;
            if (y + i >= 0) {
                sumVertical += board[x][y + i] == currentPlayer ? 1 : 0;
            }
        }
        return sumHorizontal == 4 || sumVertical == 4;
    }

    public boolean checkDiagonal(int x, int y, int[][] board, int currentPlayer) {
        int sumUp = 0;
        int sumDown = 0;
        for (int i = 0; i < 4; i++) {
            if (x + i < board.length && y + i < board[0].length)
                sumUp += board[x + i][y + i] == currentPlayer ? 1 : 0;
            if (x - i >= 0 && y - i >= 0)
                sumDown += board[x - i][y - i] == currentPlayer ? 1 : 0;
        }

        if (sumDown == 4 || sumUp == 4) {
            return true;
        }

        sumUp = sumDown = 0;
        for (int i = 0; i < 4; i++) {
            if (x - i >= 0 && y + i < board[0].length)
                sumDown += board[x - i][y + i] == currentPlayer ? 1 : 0;
            if (x + i < board.length && y - i >= 0) {
                sumUp += board[x + i][y - i] == currentPlayer ? 1 : 0;

            }
        }

        return sumUp == 4 || sumDown == 4;
    }

     public int StartGame(GameBoard board, Player p1, Player p2)
     {
         int choice , found;
         Player curr = p1; // starting player
         while(!(board.isFull()))
         {
             board.printBoard();
             System.out.println(curr.getName() + "'s turn, choose a column to place your piece: ");
             choice = reader.nextInt();
             found = findPlace(choice, board.board);
             while (found < 0)
             {
                 System.out.println("couldn't place a piece, try again");
                 choice = reader.nextInt();
                 found = findPlace(choice, board.board);
             }
             board.placePiece(found,choice,curr.getCode());
             if (checkWin(found,choice,board.board, curr.getCode())) {
                 System.out.println(curr.getName() + " won!");
                    return curr.getCode();
             }
             curr = curr == p1 ? p2 : p1 ;
         }
         System.out.println("Draw!");

         return 0;
     }
}

