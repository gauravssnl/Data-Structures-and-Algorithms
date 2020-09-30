package fds;

import java.util.Arrays;

/** A class for high scores */
public class ScoreBoard {
    private int numEnteries = 0; // number of actual enteries
    // board will store list of high scores; first element will be the highest score
    private GameEntry[] board; // array of game enteries ( names & scores )

    /**
     * Construct an empty scoreboard with the given capacity for storing enteries.
     */
    public ScoreBoard(int capacity) {
        board = new GameEntry[capacity];
    }

    /** Attempt to add a new score to the collection (if it is high enough). */
    public void add(GameEntry gameEntry) {
        int newScore = gameEntry.getScore();
        // is the new entry e really a high score ?
        // the last element in board array is the lowest among all high scores.
        if (numEnteries < board.length || newScore > board[numEnteries - 1].getScore()) {
            if (numEnteries < board.length) { // no score drops from the board
                numEnteries++;
            }
            // shift any lower scores rightward to make room for new entry;
            int j = numEnteries - 1;
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1]; // shift lower score rightwards
                j--; // decrement j
            }
            board[j] = gameEntry; // when done add new entry
        }
    }

    /** Remove and return the high score at index i */
    public GameEntry remove(int index) {
        if (index < 0 || index > numEnteries)
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        GameEntry temp = board[index]; // save the object to be removed
        for (int j = index; j < numEnteries - 1; j++) // count up from index ( not down)
            board[j] = board[j + 1]; // move one cell to the left
        board[numEnteries - 1] = null; // null out the old last score
        return temp; // return the removed object
    }

    public int getNumEnteries() {
        return numEnteries;
    }

    @Override
    public String toString() {
        return "ScoreBoard [board=" + Arrays.toString(board) + ", numEnteries=" + numEnteries + "]";
    }

    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard(10);
        GameEntry gameEntry = new GameEntry("Rahul", 78);
        scoreBoard.add(gameEntry);
        gameEntry = new GameEntry("Saurav", 80);
        scoreBoard.add(gameEntry);
        gameEntry = new GameEntry("Mickey", 50);
        scoreBoard.add(gameEntry);
        gameEntry = new GameEntry("Ravi", 85);
        scoreBoard.add(gameEntry);
        gameEntry = new GameEntry("Nur", 65);
        scoreBoard.add(gameEntry);
        gameEntry = new GameEntry("Rahul", 75);
        scoreBoard.add(gameEntry);
        gameEntry = new GameEntry("Neha", 71);
        scoreBoard.add(gameEntry);
        gameEntry = new GameEntry("Hans", 81);
        scoreBoard.add(gameEntry);
        gameEntry = new GameEntry("Nagraj", 55);
        scoreBoard.add(gameEntry);
        gameEntry = new GameEntry("Suraj", 77);
        scoreBoard.add(gameEntry);
        System.out.println(scoreBoard);
        System.out.println(scoreBoard.getNumEnteries());
        gameEntry = new GameEntry("Shweta", 77);
        scoreBoard.add(gameEntry);
        System.out.println(scoreBoard);
        gameEntry = new GameEntry("Gs", 55);
        scoreBoard.add(gameEntry);
    }
}