class GameEntry:
    """Represents 1 entry of high scores"""
    
    def __init__(self, name, score):
        self._name = name
        self._score = score
    
    def get_name(self):
        return self._name
    
    def get_score(self):
        return self._score
    
    def __str__(self):
        return '({0}, {1})'.format(self._name, self._score)

class ScoreBoard:
    """Fixed length sequence of high scores in decreasing order"""

    def __init__(self, capacity=10):
       self._board = [None] * capacity                              # space for future scores
       self._n = 0                                                  # no. of actaul entries
    
    def __getitem__(self, k):
        return self._board[k]
    
    def __str__(self):
        return '\n'.join(str(self._board[j]) for j in range(self._n))
    
    def __len__(self):
        return self._n
    
    def add(self, entry):
        """Consider adding entry to high scores"""
        score = entry.get_score()

        # Does new entry qualify as good score
        # answer is yes if board not full or score is higher than the last entry
        good =  self._n < len(self._board) or self._board[-1].get_score() < score

        if good:
            if self._n < len(self._board):              # no need to drop scores from list
                self._n += 1                            # so overall number increases

                # shift lower scores rightward to make room for new entry
                j = self._n - 1
                while j > 0 and self._board[j-1].get_score() < score:
                    self._board[j] = self._board[j-1]    # shift entry from index j -1 to j
                    j -= 1                               # decremnt j 
                self._board[j] = entry                    # when done add entry since j-1 index has higher value

if __name__ == "__main__":
    scoreBoard = ScoreBoard()

    entry1 = GameEntry('Anna', 660) 
    scoreBoard.add(entry1)

    entry2 = GameEntry('Paul', 720)
    scoreBoard.add(entry2)

   

    entry3 = GameEntry('Rose', 590)
    scoreBoard.add(entry3)

    entry4 = GameEntry('Jack', 510)
    scoreBoard.add(entry4)

    entry5 = GameEntry('Mike', 1105)
    scoreBoard.add(entry5)

   

    entry5 = GameEntry('Rob', 750)
    scoreBoard.add(entry5)

    entry6 = GameEntry('Jill', 740)
    scoreBoard.add(entry6)

    print(scoreBoard, len(scoreBoard))


    