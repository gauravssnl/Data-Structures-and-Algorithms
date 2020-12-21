from ds.linkedlist import LinkedList


class LinkedDeque:
    """ A Deque implemnted using a LinkedList. """

    def __init__(self):
        self._L = LinkedList()

    def add_first(self, item):
        self._L.add_first(item)

    def add_last(self, item):
        self._L.add_last(item)

    def remove_first(self):
        return self._L.remove_first()

    def remove_last(self):
        return self._L.remove_last()
