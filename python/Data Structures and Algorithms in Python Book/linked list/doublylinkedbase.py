class _DoublyLinkedBase:
    """A base class providing a doubly linked list representation."""

    class _Node:
        """Lightweight, nonpublic class for storing a doubly linked node."""
        __slots__ = ['_element', '_previous', '_next']

        def __init__(self, element, previous, next):
            """Create a new node."""
            self._element = element
            self._previous = previous
            self._next = next
        
        def __str__(self):
                return "({})".format(self._element)
    
    # _DoublyLinkedBase methods
    def __init__(self):
        """Create a new list."""
        self._header = self._Node(None, None, None)
        self._trailer = self._Node(None, None, None)
        self._header._next = self._trailer                      # trailer is after header
        self._trailer._previous = self._header                  # header is before trailer
        self._size = 0                                          # set size to 0
    
    def __len__(self):
        """Return the no. of elements in the list."""
        return self._size
    
    def is_empty(self):
        """Return True if list is empty; False otherwise."""
        return self._size == 0
    
    def _insert_between(self, e, predecessor, successor):
        """Add element e between existing nodes and return new node."""
        newest = self._Node(e, predecessor, successor)        # linked to neighbours
        predecessor._next = newest
        successor._previous = newest
        self._size += 1
        return newest
    
    def _delete_node(self, node):
        """Delete nonsentinel node from the list and return its element."""
        predecessor = node._previous
        successor = node._next
        predecessor._next = successor
        successor._previous = predecessor
        self._size -= 1
        element = node._element                                 # store deleted node element for returning later
        node._previous = node._next = node._element = None      # helps garbage collection
        return element
    
    def __str__(self):
        """Return the Deque data as string."""
        current_node = self._header                             # set current node as header sentinel 
        result = ""                                             # will return this result
        while current_node != self._trailer:                    # traverse till we reach trailer sentinel
            result += " <- {} -> ".format(current_node)
            current_node = current_node._next                   # set current node to the next one
        result += " <- {} -> ".format(current_node)             # add trailer sentinel data
        return "< Deque: {}>".format(result)
    