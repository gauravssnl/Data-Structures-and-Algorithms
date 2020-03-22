from positional_list import PositionalList

#  Note: if no. of acess tally, most recent element is returned when top(k) is called
class FavoriteList:
    """List of elements ordered from most frequently accessed to least."""

    # Nested class
    class _Item:
        __slots__ = '_value', '_count'                          # streamline menmory usage
        def __init__(self, e):
            self._value = e                                     # element
            self._count = 0                                     # access count of the element
        
        def __str__(self):
            return "<Item : {}, count: {}>".format(self._value, self._count)
        
    # nonpublic utilites
    def _find_position(self, e):
        """Search for element e and returns its Position (or None if not found)."""
        walk = self._data.first()           # (_data is member of FavoriteList) consider moving
        while walk is not None and walk.element()._value != e:
            walk = self._data.after(walk)
        return walk
    
    def _move_up(self, p):
        """Move item at Position p earlier in the list based on acess count."""
        if p != self._data.first():           # move only if it is not 1st position
            cnt = p.element()._count
            walk = self._data.before(p)
            while walk != self._data.first() and cnt > self._data.before(walk).element()._count :
                walk = self._data.before(walk)
            self._data.add_before(walk, self._data.delete(p))           # delete and reinsert before walk
    
    # public methods
    def __init__(self):
        """Crate an empty list of favotites."""
        self._data = PositionalList()                                   # will be list of _Item instances
    
    def __len__(self):
        """Return no. of entries on favorite list."""
        return len(self._data)
    
    def is_empty(self):
        """Return True if list is empty."""
        return len(self._data) == 0
    
    def access(self, e):
        """Acess element e, thereby increases its access count."""
        p = self._find_position(e)                              # try to locate existing element
        if p is None:
            p = self._data.add_last(self._Item(e))              # srore element as _Item
        p.element()._count += 1                                 # always increment count
        self._move_up(p)                                        # consider moving forward

    def remove(self, e):
        """Remove element e from the list of favorites."""
        p = self._find_position(e)
        if p is not None:
            self._data.delete(p)
    
    def top(self, k):
        """Generate sequence of top k elements in terms of access count."""
        if not 1 <= k <= len(self):
            raise ValueError("Illegal value for k")
        walk = self._data.first()
        for j in range(k):
            item = walk.element()                                 # element of list is _Item
            yield item._value                                     # report user's element
            walk = self._data.after(walk)

if __name__ == "__main__":
    favorite_list = FavoriteList()
    favorite_list.access(1)
    favorite_list.access(2)
    favorite_list.access(3)
    favorite_list.access(4)
    favorite_list.access(1)
    favorite_list.access(1)
    favorite_list.access(2)
    favorite_list.access(2)
    # print most 2 accessed elements
    for elememt in favorite_list.top(2):
        print(elememt)
