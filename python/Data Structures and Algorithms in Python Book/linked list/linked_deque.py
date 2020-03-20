from doublylinkedbase import _DoublyLinkedBase;

class Empty(Exception):
    """Use this exception if container is empty."""
    pass

class LinkedDeque(_DoublyLinkedBase):
    """Doubly-ended queue implementation based on doubly linked list."""

    def first(self):
        """Return (but do not remove) the element at the front of the deque.
        Raise Empty exception if deque is empty."""
        if self.is_empty():
            raise Empty("Deque is empty")
        return self._header._next._element                # real item is after header sentinel
    
    def last(self):
        """Return (but do not remove) the element at the end of the deque.
        Raise Empty exception if deque is empty."""
        if self.is_empty():
            raise Empty("Deque is empty")
        return self._trailer._previous._element            # real item is before trailer sentinel

    def insert_first(self, e):
        """Add an element e to the front of the deque."""
        self._insert_between(e, self._header, self._header._next)    # insert after header
    
    def insert_last(self, e):
        """Add an element e at the end of the deque."""
        self._insert_between(e, self._trailer._previous, self._trailer)  #insert before trailer
    
    def delete_first(self):
        """Remove and return the element at the front of the deque.
        Raise Empty Exception if deque is empty."""
        if self.is_empty():
            raise Empty("Deque is empty")
        return self._delete_node(self._header._next)        # delete the node after header sentinel
    
    def delete_last(self):
        """Remove and return the element at the end of the deque.
        Raise Empty exception if deque is empty."""
        if self.is_empty():
            raise Empty("Deque is empty")
        return self._delete_node(self._trailer._previous)
    
   

if __name__ == "__main__":
    linked_deque = LinkedDeque()
    print(linked_deque)

    linked_deque.insert_first(1)
    print(linked_deque)
    print("Elemet at the front of deque:", linked_deque.first())

    linked_deque.insert_last(2)
    print(linked_deque)
    print("Elemet at the end of deque:", linked_deque.last())

    deleted_element= linked_deque.delete_first()
    print("Delted element:", deleted_element)
    print(linked_deque)
    print("Elemet at the front of deque:", linked_deque.first())

    linked_deque.insert_first(3)
    print(linked_deque)
    print("Elemet at the front of deque:", linked_deque.first())

    deleted_element = linked_deque.delete_last()
    print("Delted element:", deleted_element)
    print(linked_deque)
    print("Elemet at the front of deque:", linked_deque.first())


