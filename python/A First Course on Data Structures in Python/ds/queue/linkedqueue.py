from ..linkedlist import LinkedList


class LinkedQueue:
    def __init__(self):
        self._L = LinkedList()

    def enqueue(self, item):
        self._L.add_last(item)

    def dequeue(self):
        return self._L.remove_first()

    def peek(self):
        # or we have to use remove_first() and add_first() to get item at head
        return self._L.get_head()

    def __len__(self):
        return len(self._L)

    def is_empty(self):
        return len(self) == 0
