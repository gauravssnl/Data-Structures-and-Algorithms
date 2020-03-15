from progression import Progression

class ArithmeticProgression(Progression):

    def __init__(self, start=0, increment=1):
        super().__init__(start)
        self._increment = increment

    def _advance(self):
       self._current += self._increment
       


if __name__ == "__main__":
    aritmetic_progression = ArithmeticProgression(start = 1, increment=3)
    aritmetic_progression.print_progression(20)