package tictactoe;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String[][] board = new String[3][3];
    static boolean gameOver = false;
    static int turn = 1;
    static String player = "X";

    public static void main(String[] args) {
        createBoard();
        printBoard();
        while (!gameOver) {
            gamePlay();
            checkWinner(board);
        }
    }

    public static void createBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = " ";
            }
        }
    }

    public static void checkWinner(String[][] arr) {
        for (int i = 0; i < 3 && !gameOver; i++) {
            if (arr[i][0].equals(player) && arr[i][1].equals(player) && arr[i][2].equals(player)
                    || arr[0][i].equals(player) && arr[1][i].equals(player) && arr[2][i].equals(player)
                    || arr[0][0].equals(player) && arr[1][1].equals(player) && arr[2][2].equals(player)
                    || arr[0][2].equals(player) && arr[1][1].equals(player) && arr[2][0].equals(player)) {
                System.out.println(player + " wins");
                gameOver = true;
            }
        }
    }

    public static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + board[i][0] + " " + board[i][1] + " " + board[i][2] + " |");
        }
        System.out.println("---------");
    }

    private static void gamePlay() {
        int x, y;

        if (turn == 10) {
            System.out.print("Draw");
            gameOver = true;
            return;
        }
        System.out.print("Enter the coordinates: ");
        String coordX = !sc.hasNextInt() ? sc.next() + "notInt" : sc.next();
        String coordY = !sc.hasNextInt() ? sc.next() + "notInt" : sc.next();

        if (coordX.contains("notInt") || coordY.contains("notInt")) {
            System.out.println("You should enter numbers!");
            return;
        } else {
            x = Integer.parseInt(coordX) - 1;
            y = Integer.parseInt(coordY) - 1;
        }

        if (x < 0 || x > 2 || y < 0 || y > 2) {
            System.out.println("Coordinates should be from 1 to 3!");
        } else if (board[x][y].contains("X") || board[x][y].contains("O")) {
            System.out.println("This cell is occupied! Choose another one!");
        } else {
            player = turn % 2 == 0 ? "O" : "X";
            board[x][y] = player;
            printBoard();
            turn++;
        }
    }
}
