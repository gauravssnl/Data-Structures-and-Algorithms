class ListDeque:
    def __init__(self):
        self._L = []

    def add_first(self, item):
        self._L.insert(0, item)

    def add_last(self, item):
        self._L.append(item)

    def remove_first(self):
        return self._L.pop(0)

    def remove_last(self):
        return self._L.pop()
