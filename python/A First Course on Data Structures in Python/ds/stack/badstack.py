from .stack import ListStack


class BadStack(ListStack):
    def push(self, item):
        """ Push item to the begining of the list in stack. """
        self._L.insert(0, item)

    def pop(self):
        """ Pop item from thr begining of the list in stack. """
        return self.pop(0)

if __name__ == "__main__":
    bad_stack = BadStack()
