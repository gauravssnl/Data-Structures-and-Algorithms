class Progression:
    """Iterator producing a generic progression"""

    def __init__(self, start=0):
        self._current = start

    def _advance(self):
        self._current += 1
    
    def __next__(self):
        if self._current is None:
            raise StopIteration()
        else:
            answer = self._current
            self._advance()
            return answer
    
    def __iter__(self):
        """By convention, an iterator must return itself as an iterator"""
        return self

    def print_progression(self, n):
        print(' '.join(str(next(self)) for j in range(n))) #conversion to str is necessary as join accept str not int


if __name__ == "__main__":
    progression = Progression(start = 1)
    progression.print_progression(20)
