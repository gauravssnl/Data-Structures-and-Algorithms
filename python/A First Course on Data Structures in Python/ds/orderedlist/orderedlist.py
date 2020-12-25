from .orderedlistsimple import OrderedListSimple


class OrderedList:
    """ A List which orders items based on their order of values during insertion. """

    def __contains__(self, item):
        left, right = 0, len(item)
        while right - left > 1:
            median = (left + right) // 2
            if item < self._L[median]:
                right = median
            else:
                left = median
        return right > left and self._L[left] == item
