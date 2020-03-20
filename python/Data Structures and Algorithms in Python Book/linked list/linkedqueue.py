class Empty(Exception):
    """Exception class to be used if the container is empty"""
    pass

class LinkedQueue:
    """FIFO queue implementation using a singly linked list for storage"""

    class _Node:
        """Lightwight, nonpublic class for storing a singly linked node"""
        __slots__ =['_element', '_next']            # streamline memory usage 

        def __init__(self, element, next):
            """Create a new Node"""
            self._element = element 
            self._next = next
        
        def __str__(self):
                return "{} -> {}".format(self._element, self._next)
    
    # LinkedQueue methods
    def __init__(self):
        """Create an empty Queue"""
        self._head = None
        self._tail = None
        self._size = 0                      # no. of elements in queue
    
    def __len__(self):
        """Return the no. of elements in the queue"""
        return self._size
    
    def is_empty(self):
        """Return True if queue is empty; False otherwise."""
        return self._size == 0
    
    def first(self):
        """Return (but don't remove) the element at the front of the queue.
        Raise Empty exception if queue is empty."""
        if self.is_empty():
            raise Empty("Queue is empty")
        return self._head._element
    
    def deque(self):
        """Remove and return the element at the head (front) of  the queue.
        Raise Empty exception if queue is empty."""
        if self.is_empty():
            raise Empty("Queue is empty")
        answer = self._head._element
        self._head = self._head._next
        self._size -= 1
        if self.is_empty():             # queue is empty now
            self._tail = None           # removed head that had been tail 
        return answer
    
    def enque(self, e):
        """Add element e at the tail/back of the queue."""
        newest = self._Node(e, None)                        # pass None as the next element to make Node as tail
        if self.is_empty():                                 # queue is empty, no element at the head
            self._head = newest                             # set new node as head
        else:                                               # head exists
            self._tail._next = newest                       # set the refrence to the newest node from existing tail node
        self._tail= newest                                 # upadate the tail to the new node
        self._size += 1                                     # increase size
    
    def __str__(self):
        return '< LinkeQueue: [{}] >'.format(self._head)

if __name__ == "__main__":
    linked_queue = LinkedQueue()
    print(linked_queue)

    for i in range(1,6):
        linked_queue.enque(i)
    print(linked_queue)
    print("Queue size: ", len(linked_queue))
    print("Element at head of queue:", linked_queue.first())
    
    for i in range(1, 6):
        linked_queue.deque()
    print(linked_queue)
    print("Queue size: ", len(linked_queue))

