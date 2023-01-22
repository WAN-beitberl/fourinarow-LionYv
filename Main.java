import java.util.Scanner;

public class Main {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard(6,7);
        Connect4 game = new Connect4();
        Player p1 = new Player("yoav", 1);
        Player p2 = new Player("lion", 2);
        game.StartGame(gameBoard, p1, p2);

    }
}