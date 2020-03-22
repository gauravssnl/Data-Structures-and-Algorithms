from positional_list import PositionalList
from favoritelist import FavoriteList
# if no. of acess tally, recently acesssed element is returned when top(k) is called
class FavoriteListMTF(FavoriteList):
    """List of elements ordered with move-to-front heuristics."""

    # we override _move_up to provide move-to-front semantics."""
    def _move_up(self, p):
        """Move accessed item at Position p to front of the list."""
        if p != self._data.first():
            self._data.add_first(self._data.delete(p))      # delte and reinsert at first
    
    # we override top because list is no longer sorted
    def top(self, k):
        """Generate sequence of top k elements in terms of access count."""
        if not 0 <= k <= len(self):
            raise ValueError("Illegal value for k")

        # we begin my making copy of original list, as we will modify the temprary list
        temp = PositionalList()
        for item in self._data:            # positional list supports iteration
            temp.add_last(item)
        
        # we repeatedly find, report, and remove elements with largest count from temp list
        for j in range(k):
            # find and report next highest from temp
            highPos = temp.first()
            walk = temp.after(highPos)
            while walk != None:
                if walk.element()._count > highPos.element()._count:
                    highPos = walk
                walk = temp.after(walk)
            # we have found element with the highest count
            yield highPos.element()._value                  # report element to user
            temp.delete(highPos)                            # remove from temp to get next most accessed element

    # added by me     
    def first(self):
        """Return the element at front of the list."""
        return self._data.first()
    
    def __str__(self):
        return "<FavoriteListMTF: {} >".format(self._data)
    

if __name__ == "__main__":
    move_to_front_favorite_list = FavoriteListMTF()
    move_to_front_favorite_list.access(1)
    move_to_front_favorite_list.access(2)
    move_to_front_favorite_list.access(3)
    move_to_front_favorite_list.access(4)
    move_to_front_favorite_list.access(3)
    move_to_front_favorite_list.access(3)
    move_to_front_favorite_list.access(2)
    move_to_front_favorite_list.access(2)
    print(move_to_front_favorite_list.first())
    print(move_to_front_favorite_list)

    print("Three most frequently accessed items:")
    for element in move_to_front_favorite_list.top(3):
        print(element)