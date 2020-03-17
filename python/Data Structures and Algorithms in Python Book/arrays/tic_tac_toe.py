class TicTacToe:
    """Management of a Tick-Tack-Toe game (no strategy for computer to play & win)"""

    def __init__(self):
        """Start a new game"""
        self._board = [[''] * 3 for j in range(3)]
        self._player = 'X'                              # set 'X' as default 1st player

    def mark(self, i, j):
        """Put a 'X' or 'O' mark at posistion (i, j)"""
        if not (0 <= i < 3 and 0 <= j < 3):
            raise ValueError("Invalid board position")
        if self._board[i][j] != '':  # the position is already filled, raise error
            raise ValueError("Board position occupied")
        # if there is already a winner, game is complete, raise error
        if self.winner() is not None:
            raise ValueError("Game is already won")
        # fill position with the symbol of current player
        self._board[i][j] = self._player

        # change player for next player's chance
        self._player = 'O' if self._player == 'X' else 'X'

    def _is_win(self, mark):
        """Check whether board configuartion is a win for the given player"""
        board = self._board  # local variable for shortand name use

        # check whether user wins in all 3 rows first
        for i in range(3):              # row index
            if board[i][0] == board[i][1] == board[i][2] == mark:
                return True

        # check whether users win in the 3 columns
        for j in range(3):  # column index
            if board[0][i] == board[1][i] == board[2][i] == mark:
                return True

        # check whether players wins in daigonal ( from top-left to rightmost-bottom)
        # [(0, 0), (1, 1), (2, 2)]
        diagonal_coordinates = list(zip(range(3), range(3)))
        # print("diagonal_coordinates: ", diagonal_coordinates)
        for i, j in diagonal_coordinates:
            if board[i][j] == mark:
                if i == j == 2: # whole diagonal is visited
                    return True
            else: break
        

        # check whether players wins in reverse diagonal
        reverse_diagonal_coordinates = list(
            zip(range(3), reversed(range(3))))  # [(0, 2), (1, 1), (2, 0)]
        # print("reverse_diagonal_coordinates: ", reverse_diagonal_coordinates)
        for i, j in reverse_diagonal_coordinates:
            if board[i][j] == mark:
                if i  == 2 and j == 0: # whole reverse diagonal is visited
                    return True
            else: break
        
        # finally return False
        return False
    
    def winner(self):
        for mark in ['X', 'O']: # we can also use string 'XO'
            if self._is_win(mark):
                return mark
        return None
    
    def __str__(self):
        rows = ['  |'.join(self._board[r]) for r in range(3)]
        return '\n----------\n'.join(rows) + '\n' # add extra new line add the end of tic tac toe
    
if __name__ == "__main__":
    tic_tac_toe = TicTacToe()

    tic_tac_toe.mark(0, 0) # X
    print(tic_tac_toe)

    tic_tac_toe.mark(1, 0) # O`
    print(tic_tac_toe)

    tic_tac_toe.mark(0, 1) # X
    print(tic_tac_toe)

    tic_tac_toe.mark(1, 1) # O
    print(tic_tac_toe)

    tic_tac_toe.mark(0, 2) # X
    print(tic_tac_toe)

    print("The winner is:", tic_tac_toe.winner())

    # this will throw error as game is already over, uncomment to test
    # tic_tac_toe.mark(2, 2) 
    # print(tic_tac_toe)

    # new game
    print("\nNew Game")
    tic_tac_toe = TicTacToe()

    tic_tac_toe.mark(0, 0) # X
    print(tic_tac_toe)

    tic_tac_toe.mark(1, 0) # O
    print(tic_tac_toe)

    tic_tac_toe.mark(1, 1) # X
    print(tic_tac_toe)

    tic_tac_toe.mark(1, 2) # O
    print(tic_tac_toe)

    tic_tac_toe.mark(2, 2) # X
    print(tic_tac_toe)

    print("The winner is:", tic_tac_toe.winner())

    
