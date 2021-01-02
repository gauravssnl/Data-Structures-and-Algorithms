# Python's easier to ask forgiveness than permission (EAFP) approach example.
class BufferedIterator:
    def __init__(self, i):
        self._i = iter(i)
        self._hasNext = True
        self._buffer = None
        self._advance()

    def hasnext(self):
        return self._hasNext

    def peek(self):
        return self._buffer

    def __iter__(self):
        return self

    def _advance(self):
        try:
            self._buffer = next(self._i)
        except StopIteration:
            self._hasNext = False
            self._buffer = None

    def __next__(self):
        if self.hasnext():
            output = self.peek()
            self._advance()
            return output
        else:
            raise StopIteration


if __name__ == "__main__":
    bf = BufferedIterator(range(1, 10))
    for x in bf:
        print(x, end=" ")
    print("")
    
    bf = BufferedIterator([1, 2, 3, 4, 5,6])
    for x in bf:
        print(x, end=" ")
    print("")
