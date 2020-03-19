class Empty(Exception):
    """Raise exception if container is empty."""
    pass

class ArrayDeque:
    """Doble-ended queue implementation using Python's list as underlying storage."""
    DEFAULT_CAPACITY = 10

    def __init__(self):
        "Create an empty double-ended queue (deque) "
        self._data = [None] * ArrayDeque.DEFAULT_CAPACITY
        self._front = 0
        self._size = 0
    
    def __len__(self):
        """Return the number of elements in Deque"""
        return self._size
    
    def is_empty(self):
        """Return True if there are no elements in Deque; False otherwise."""
        return self._size == 0
    
    def first(self):
        """Return ( but not remove) the elemnt at the front of the Deque.
        Raise Empty Exception if Deque is empty."""
        if self.is_empty():
            raise Empty("Deque is empty.")
        return self._data[self._front]
    
    def last(self):
        """Return (but not remove) the elemnt at the end of the Deque.
        Raise Empty exception if Deque is empty."""
        if self.is_empty():
            raise Empty("Deque is empty.")
        # calcluate index for elemnt at the end of deque
        back = (self._front + self._size - 1 ) % len(self._data)    # index will be 1 lesser than the sum of front & size
    
    def add_first(self, e):
        """Add element to the front of the Deque"""
        if self._size == len(self._data):                           # storage is full
            self._resize(2 * len(self._data))                       # double the capacity
        self._front = (self._front -1 ) % len(self._data)           # store item in front of item at current front index
        self._data[self._front] = e
        self._size += 1
    
    def add_last(self, e):
        """Add element e to the end of Deque"""
        if self._size == len(self._data):                           # storage is full
            self._resize(2 * len(self._data))                       # double the capacity
        back = (self._front + self._size) % len(self._data)         # get index of end of deuqe
        self._data[back] = e
        self._size += 1
    
    def delete_first(self):
        """Return and remove the element at the front of Deque.
        Raise Empty Exception if Deque is empty."""
        if self.is_empty():
            raise Empty("Deque is empty.")
        answer = self._data[self._front]                            # store item at the front of deque; will return this
        self._data[self._front] = None                              # garbage collection
        self._front = (self._front + 1) % len(self._data)           # change front value to the next index
        self._size -= 1
    
    def delete_last(self):
        """Return and remove the element at the end of the Deque.
        Raise Empty exception if Deque is empty."""
        if self.is_empty():
            raise Empty("Deque is empty.")
        back = (self._front + self._size -1 ) % len(self._data)       # get the index of the elementg at the end of deque
        answer = self._data[back]                                     # store this value for returning later
        self._data[back] = None                                       # garbage collection
        self._size -= 1
        return answer
    
    def _resize(self, capacity):
        old =self._data                                                 # store current Deque elements
        self._data = [None] * capacity                                  # set the new capacity for storage
        walk = self._front                                              # get the value of front so that we can copy old data
        for k in range(len(old)):
            self._data[k] = old[walk]                             # copy data from old to new storage; start from front of old 
            walk = (walk +1) % len(old)                                  # ponit walk to the next index
        self._front = 0                                                  # set front value to the 0th index of new storage

    def __str__(self):
        return '<DeQueue: {}, storage: {}>'.format(self._data[self._front: self._front+self._size], self._data)      

if __name__ == "__main__":
    array_deque = ArrayDeque()
    print(array_deque) 
    array_deque.add_first(1)
    print(array_deque) 
    array_deque.add_first(2)
    print(array_deque) 
    print(array_deque.add_last(3))