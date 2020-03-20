class Empty(Exception):
    """Use this class to raise exception if a container is empty."""
    pass

class CircularQueue:
    """Queue implemented using cicrcularly linked list for storage."""

    class _Node:
        """Lightweight, nonpublic class  for storing a singly linked node."""
        __slots__ = ["_element", "_next"]                       # streamline menory usage

        def __init__(self, element, next):
            self._element = element
            self._next = next
        
        def __str__(self):
           """Represents the node elemnt."""
           return "{}".format(self._element)
    
    # CircularQueue methods
    def __init__(self):
        """Create an empty queue."""
        self._tail = None                                       # will represent tail of queue
        self._size = 0
    
    def __len__(self):
        """Return the no. of elements in the queue."""
        return self._size
    
    def is_empty(self):
        """Return True if queue is empty; False otherwise."""
        return self._size == 0
    
    def first(self):
        """Return (but don't remove) the element at the head of the queue.
        Raise Empty Exception if queue is empty."""
        if self.is_empty():
            raise Empty("Queue is empty")
        head = self._tail._next
        return head._element
    
    def deque(self):
        """Remove and return the first element of the queue.
        Raise Empty exception if queue is empty."""
        if self.is_empty():
            raise Empty("Queue is empty")
        old_head = self._tail._next
        if self._size == 1:                                 # removing only element which existed
            self._tail = None                               # queue becomes empty
        else:                                               # head exists
            self._tail._next = old_head._next               # bpass oldhead head and point to the next node
        self._size -=1
        return old_head._element
    
    def enque(self, e):
        """Add element e to the end of queue(tail of linked list)."""
        newest = self._Node(e, None)                         # create a new tail node
        if self.is_empty():                                  # queue is empty
            newest._next = newest                            # initialize circularly
        else:                                                # tail element exists
            newest._next = self._tail._next                  # new node points to head
            self._tail._next = newest                        # old tail points to the new node
        self._tail = newest                                  # new node becomes the new node
        self._size += 1                                       # increase size
    
    def __str__(self):
        """Return the Circular Queue data as string"""
        result = ""
        # we will traverse from tail node to head node(if any)
        # as it is circularly linked list, we will stop traversal if we arrive back to the same tail node
        tail_node = self._tail                                  # store tail node
        if self._size == 0:                                     # queue is enmpty
            result += str(tail_node) + "->"                     # no need to traverse furthur
        else:
            next_node = tail_node._next                         # get the next node of tail node
            while next_node != tail_node:                       # traverse untill we arrive back to the tail node
                result += str(next_node) + " -> "               # add next node information
                next_node = next_node._next                     # chnge next_node to the subsequent next node 
            result += str(tail_node) + " -> "                   # add the tail node information finally
        return "< CircularQueue: [{}] >".format(result)

if __name__ == "__main__":
    circular_queue = CircularQueue()
    print(circular_queue)

    circular_queue.enque(1)
    print(circular_queue)
    print("Element at the front of queue:", circular_queue.first())
    print("Queue size:", len(circular_queue))

    circular_queue.deque()

    for i in range(1, 11):
        circular_queue.enque(i)
        print(circular_queue)
    print("Element at the front of queue:", circular_queue.first())
    print("Queue size:", len(circular_queue))
   

    for i in range(1, 11):
        circular_queue.deque()
        print(circular_queue)
        if not circular_queue.is_empty():
            print("Element at the front of queue:", circular_queue.first())
        print("Queue size:", len(circular_queue))
    
   

    

    

    
