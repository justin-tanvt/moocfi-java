package ticTacToe.domain;

import java.util.Scanner;

public class TicTacToeGame {

    public static final char[] PLAYERS = {'X', 'O'};
    public static final char EMPTY_CELL_VALUE = '.';
    private static final int MAX_MOVES_PER_GAME = 9;

    private final char[][] gameBoard;
    protected boolean gameOver;
    private int currentTurnIndex;
    private int movesPlayed;

    // TODO - remove scanner
    private final Scanner scan = new Scanner(System.in);

    public TicTacToeGame() {
        this.gameBoard = new char[3][3];
        setupNewGame();
    }

    public void setupNewGame() {
        clearBoard();
        this.gameOver = false;
        this.currentTurnIndex = 0;
        this.movesPlayed = 0;
    }

    public boolean playMove(int rowIdx, int colIdx) {
        char currentPlayerSymbol = PLAYERS[this.currentTurnIndex];

        if (this.gameBoard[rowIdx][colIdx] == EMPTY_CELL_VALUE) {
            this.gameBoard[rowIdx][colIdx] = currentPlayerSymbol;
            this.movesPlayed++;
            moveToNextTurn();
            this.gameOver = checkOverallGameOver();
            return true;
        } else {
            return false;
        }
    }

    public String getGameStatusMessage() {
        if (!this.gameOver) {
            return "Turn: " + PLAYERS[this.currentTurnIndex];
        } else {
            return "The end!";
        }
    }

    public boolean isOver() {
        return this.gameOver;
    }

    public String getCellValue(int rowIdx, int colIdx) {
        return String.valueOf(this.gameBoard[rowIdx][colIdx]);
    }

    // TODO - make showBoard package access
    void showBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(this.gameBoard[row][col] + " ");
            }
            System.out.println();
        }
    }

    // TODO - remove receiveMove
    void receiveMove() {
        System.out.print("which row >");
        int moveRow = Integer.parseInt(scan.nextLine());
        System.out.print("which column >");
        int moveCol = Integer.parseInt(scan.nextLine());

        playMove(moveRow, moveCol);
    }

    private void moveToNextTurn() {
        int maxPlayerTurnIndex = PLAYERS.length - 1;

        int nextPlayerTurnIndex;
        if (this.currentTurnIndex == maxPlayerTurnIndex) {
            nextPlayerTurnIndex = 0;
        } else {
            nextPlayerTurnIndex = this.currentTurnIndex + 1;
        }

        this.currentTurnIndex = nextPlayerTurnIndex;
    }

    private void clearBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.gameBoard[row][col] = EMPTY_CELL_VALUE;
            }
        }
    }

    private boolean checkOverallGameOver() {
        return checkRanOutOfMoves() || checkHorizontalGameOver() || checkVerticalGameOver() || checkDiagonalGameOver();
    }

    private boolean checkRanOutOfMoves() {
        return movesPlayed >= MAX_MOVES_PER_GAME;
    }

    private boolean checkHorizontalGameOver() {
        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            char[] values = this.gameBoard[rowIdx];
            if (sameAndNonEmpty(values)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkVerticalGameOver() {
        for (int colIdx = 0; colIdx < 3; colIdx++) {
            char[] values = {
                    this.gameBoard[0][colIdx],
                    this.gameBoard[1][colIdx],
                    this.gameBoard[2][colIdx]
            };
            if (sameAndNonEmpty(values)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkDiagonalGameOver() {
        // top left to bottom right diagonal
        char[] values1 = new char[3];
        for (int i = 0; i < 3; i++) {
            values1[i] = this.gameBoard[i][i];
        }

        // top right to bottom left diagonal
        char[] values2 = new char[3];
        for (int i = 0; i < 3; i++) {
            values2[i] = this.gameBoard[i][3-1-i];
        }

        return sameAndNonEmpty(values1) || sameAndNonEmpty(values2);
    }

    private boolean sameAndNonEmpty(char[] values) {
        return values[0] != EMPTY_CELL_VALUE && values[0] == values[1] && values[1] == values[2];
    }
}
