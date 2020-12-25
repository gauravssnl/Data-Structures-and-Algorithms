class OrderedListSimple:
    """ A List which orders items based on their order of values during insertion. """

    def __init__(self):
        self._L = []

    def add(self, item):
        self._L.append(item)
        self._L.sort()

    def remove(self, item):
        self._L.remove(item)

    def __getitem__(self, index):
        return self._L[index]

    def __contains__(self, item):
        return item in self._L

    def __len__(self):
        return len(self._L)

    def __iter__(self):
        return iter(self._L)

    # New code
    def __str__(self):
        return "OrderedList: {}".format(self._L)


if __name__ == "__main__":
    ol = OrderedListSimple()
    ol.add(10)
    ol.add(1)
    ol.add(9)
    ol.add(8)
    ol.add(20)
    ol.add(25)
    ol.add(19)
    print("ol: ", ol)
