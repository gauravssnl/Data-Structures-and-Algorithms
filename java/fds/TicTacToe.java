package fds;

/** Simulation of a Tic-Tac-Toe game (does not do strategy). */
public class TicTacToe {
    public static final int X = 1, O = -1; // players
    public static final int EMPTY = 0; // empty cell
    private int board[][] = new int[3][3]; // game board
    private int player; // current player

    /** Constructor. */
    public TicTacToe() {
        clearBoard();
    }

    /** Clears the board. */
    public void clearBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = EMPTY; // every cell should be empty
        player = X; // the first player is 'X'
    }

    /** Puts an X or O mark at position i, j. */
    public void putMark(int i, int j) throws IllegalArgumentException {
        if (i < 0 || i > 2 || j < 0 || j > 2)
            throw new IllegalArgumentException("Invalid board position.");
        if (board[i][j] != EMPTY)
            throw new IllegalArgumentException("Board position already occupied.");
        board[i][j] = player;
        // swap player
        player = -player; // since 'X' = -'O' as X value is 1 and 'O' value is -1
    }

    /** Checks whether the board configuration is a win for the given player. */
    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark * 3) // row 0
                || (board[1][0] + board[1][1] + board[1][2] == mark * 3) // row 1
                || (board[2][0] + board[2][1] + board[2][2] == mark * 3) // row 2
                || (board[0][0] + board[1][1] + board[2][2] == mark * 3) // diagonal
                || (board[2][0] + board[1][1] + board[0][2] == mark * 3)); // reverse diagonal

    }

    /**
     * Returns the winning player's code, or 0 to indicate a tie(or unfinished
     * game).
     */
    public int winner() {
        if (isWin(X))
            return X;
        else if (isWin(O))
            return O;
        return 0; // default return value
    }

    /** Returns a simple character string showing the current board. */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case X:
                        sb.append("X");
                        break;
                    case O:
                        sb.append("O");
                        break;
                    case EMPTY:
                        sb.append(" ");
                        break;
                }
                if (j < 2)
                    sb.append("|"); // column boundary
            }
            if (i < 2)
                sb.append("\n-----\n"); // row boundary
        }
        return sb.toString();
    }

    /** Test run of a simple game */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        System.out.println("Current board now: ");
        System.out.println(game);
        /* X moves */                   /* O Moves */
        game.putMark(1, 1);             game.putMark(0, 2);
        game.putMark(2, 2);             game.putMark(0, 0);
        game.putMark(1, 2);             game.putMark(1, 0);
        game.putMark(2, 0);
        System.out.println("Current board now: ");
        System.out.println(game);
        int winningPlayer = game.winner();
        String[] outcome = {"O wins", "Tie", "X wins"}; // rely on ordering
        System.out.println(outcome[1 + winningPlayer]);
    }
}
