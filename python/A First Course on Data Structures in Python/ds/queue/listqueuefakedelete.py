class ListQueueFakeDelete:
    def __init__(self):
        self._head = 0
        self._L = []

    def enqueue(self, item):
        self._L.append(item)

    def dequeue(self):
        item = self.pop(0)
        self._head += 1
        return item

    def peek(self):
        return self._L[self._head]

    def __len__(self):
        return len(self._L) - self._head

    def isempty(self):
        return len(self) == 0
