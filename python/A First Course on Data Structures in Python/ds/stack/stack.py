class ListStack:
    def __init__(self):
        self._L = []

    def push(self, item):
        self._L.append(item)

    def pop(self):
        return self._L.pop()

    def peek(self):
        return self._L[:-1]

    def __len__(self):
        return len(self._L)

    def isempty(self):
        return len(self) == 0

    # new code added by Gaurav

    def __iter__(self):
        return iter(self._L)

    def __str__(self):
        return "ListStack [{}]".format(" ".join(self._L))
