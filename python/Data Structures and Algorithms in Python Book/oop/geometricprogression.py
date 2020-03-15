from progression import Progression

class GeometricProgression(Progression):
    
    def __init__(self, start=1, base = 2):
        super().__init__(start=start)
        self._base = base
    
    def _advance(self):
       self._current *= self._base


if __name__ == "__main__":
    geometric_progression = GeometricProgression(start = 3, base = 2)
    geometric_progression.print_progression(20)
