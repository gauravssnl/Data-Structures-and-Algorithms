from doublylinkedbase import _DoublyLinkedBase

class PositionalList(_DoublyLinkedBase):
    """A sequential container of elements allowing positional access."""

    # nested Position class
    class Position:
        """An abstraction representing the location of a single element."""

        def __init__(self, container, node):
            """Constructor should not be invoked by the user."""
            self._container = container
            self._node = node
        
        def element(self):
            """Return the element stored at this position."""
            return self._node._element
        
        def __eq__(self, other):
            """Return True if other is a Position representing the same location."""
            return type(other) is type(self) and other._node is self._node
        
        def __ne__(self, other):
            """Return True if other does not repersent the same location."""
            return not self == other                    # internally uses __eq__
        
        def __str__(self):
            """Returns Posistion data as string"""
            return "Position for Node {}".format(self._node)
        
    # utility method of PositionalList
    def _validate(self, p):
        """Return position's node or raise appropriate error if invalid."""
        if not isinstance(p, self.Position):
            raise TypeError("p must be of Position type")
        if p._container is not self:
            raise ValueError("p does not belong to this container.")
        if p._node._next is None:                                       # convention for deprecated nodes
            raise ValueError("p is no longer valid")
        return p._node
    
    # utility method
    def make_position(self, node):
        """Return Position instance for a given node(or None if sentinel)."""
        if  node is self._header or node is self._trailer:
            return None                                                 # boundary violation
        return self.Position(self, node)                                # legitimate position
    
    # accessor
    def first(self):
        """Return the first Position in the list(or None if empty)."""
        return self.make_position(self._header._next)
    
    def last(self):
        """Return the last Position in the list(or None if empty)."""
        return self.make_position(self._trailer._previous)
    
    def before(self, p):
        """Return the Position just before Position p (or None if p is first)."""
        node = self._validate(p)
        return self.make_position(node._previous)
    
    def after(self, p):
        """Return the Position just after Position p (or None if p is first)."""
        node = self._validate(p)
        return self.make_position(node._next)
    
    def __iter__(self):
        """Generate forward iteration of the elements of the list."""
        cursor = self.first()
        while cursor is not None:
            yield cursor.element()
            cursor = self.after(cursor)
    
    # mutators
    # override inherited version to return Position rather than Node
    def _insert_between(self, e, predecessor, successor):
        """Add element between existing nodes and return new Position"""
        node = super()._insert_between(e, predecessor, successor)
        return self.make_position(node)
    
    def add_first(self, e):
        """Insert elemet at the front of the list and return new Position."""
        return self._insert_between(e, self._header, self._header._next)
    
    def add_last(self, e):
        """Insert elemet at the end of the list and return new Position."""
        return self._insert_between(e, self._trailer._previous, self._trailer)
    
    def add_before(self, p, e):
        """Insert the eklement e into the list  before the Position P and return new Position."""
        node = self._validate(p)
        return self._insert_between(e, node._previous, node)
    
    def add_after(self, p, e):
        """Insert the eklement e into the list  after the Position P and return new Position."""
        node = self._validate(p)
        return self._insert_between(e, node, node._next)
    
    def delete(self, p):
        """Remove and return the elemet at Position p."""
        node = self._validate(p)
        element = node._element
        return self._delete_node(node)

    def replace(self, p, e):
        """Replace the element at Position p.
        Return the elemnent formerly at Position p."""
        node = self._validate(p)
        old_value = node._element
        node._element = e
        return old_value
    
    def __str__(self):
        """Return PositionalList as string."""
        result = ""
        for index, element in enumerate(self):                       # __iter__(self) returns element
            result += "(Index {}: Element: {}),".format(index, element)
        return "PositionalList: [{}]".format(result[:-1])   # strip last trailing comma
    
    def insertion_sort(L):
        """Sort PositionalList of comparable elements into non-decreasing order."""
        if len(L) > 1:                                      # no need to sort otherwise
            marker = L.first()
            while marker != L.last():
                pivot = L.after(marker)
                value = pivot.element()
                if value > marker.element():                # pivot is already sorted
                    marker = pivot                          # pivot becones new marker
                else:                                       # must relocate pivot
                    walk = marker                           # find leftmost item greater than pivot value
                    while walk != L.first() and L.before(walk).element() > value:
                        walk = L.before(walk)
                    L.delete(pivot)
                    L.add_before(walk, value)
    
if __name__ == "__main__":
    positional_list = PositionalList()
    print(positional_list)
    positional_list.add_first(1)
    positional_list.add_first(2)
    positional_list.add_last(3)
    print(positional_list)
    positional_list.add_before(positional_list.first(), 100)
    print(positional_list)
    positional_list.add_after(positional_list.first(), 200)
    print(positional_list)
    print(positional_list.before(positional_list.last()))
    print(positional_list.after(positional_list.first()))

    deleted_element = positional_list.delete(
        positional_list.after(
            positional_list.after( positional_list.first() )
        )
    )
    print("Deleted element:", deleted_element)
    print(positional_list)

    replaced_element = positional_list.replace(positional_list.after(positional_list.first()), 300)
    print("Replaced element:", replaced_element)
    print(positional_list)

    positional_list.insertion_sort()
    print(positional_list)



        