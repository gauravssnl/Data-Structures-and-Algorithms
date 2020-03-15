from progression import Progression

class FibonacciProgression(Progression):
    
    def __init__(self, first=0, second=1):
        super().__init__(start=first)
        self._previous = second - first
    
    def _advance(self):
        self._previous, self._current = self._current, self._previous + self._current


if __name__ == "__main__":
    fibonacci_progresssion = FibonacciProgression(first= 1, second= 2)
    fibonacci_progresssion.print_progression(20)
