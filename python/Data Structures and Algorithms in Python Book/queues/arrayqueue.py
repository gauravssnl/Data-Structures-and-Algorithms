class Empty(Exception):
    """Excpetion class to be used when container is empty"""
    pass

class ArrayQueue:
    """FIFO Queue implementation using Python's list as underlying storage"""
    DEFAULT_CAPACITY = 10

    def __init__(self):
        """Create an empty queue"""
        self._data = [None] * ArrayQueue.DEFAULT_CAPACITY
        self._front = 0
        self._size = 0

    def __len__(self):
        """Returns the no. of elements in the queue"""
        return self._size
    
    def is_empty(self):
        """Returns True if queue is empty"""
        return self._size == 0
    
    def first(self):
        """Returns( not remove)  the element at the front of the queue.
        Raise Empty Exception if queue size is 0
        """
        if self.is_empty():
            raise Empty("Queue is empty")
        return self._data[self._front]
    
    def dequeue(self):
        """Remove and return the element at the front of the queue.
        Raise Empty Exception if stack is empty.
        """
        if self.is_empty():
            raise Empty("Queue is empty")
        answer = self._data[self._front]                      # store the elemnt at the front of queue 
        self._data[self._front] = None                        # help garbage collection
        self._front = (self._front + 1) % len(self._data)
        self._size -= 1
        # this logic is for shrinking storage ( not manadatory to implement queue), but good for reducing staorage
        if 0 < self._size < len(self._data) // 4:   # when no. of elements is less than the 1/4 th stoage capacity
            self._resize(len(self._data) // 2)      # reduce capacity by half  
        return answer
    
    def enqueue(self, e):
        """Add an element e to the back of queue"""
        if self._size == len(self._data):                       # no space to store
            self._resize(2 * len(self._data))                   # double the capacity
        # if the index of storing element e crosses the capacity , it will be wrapped and stored at the start of self._data
        avail = (self._front + self._size) % len(self._data)    # find index to store elemnt 'e' 
        self._data[avail] = e
        self._size += 1

    def _resize(self, capacity):
        """Resize to a new list of capacity > len(self)."""
        old = self._data                                        # store the existing queue data
        self._data = [None] * capacity                          # allocate list with new capacity
        walk = self._front                                      # store old front value of the queue
        # will store existing elements at the beginning of the new list
        for k in range(self._size):                             # only consider existing element in old queue
            self._data[k] = old[walk]                           # intentionally shift index
            walk = (walk + 1) % len(old)              # change wall value to point it to the next elemnet;use len(old) as modulus 
        self._front = 0                                         # change front value to the start of new list
    
    def __str__(self):
        """Returns Queue contenets as string"""
        # use queue size to display only existing elements  from the front of the queue
        # displaying storage size is optional, to debug shrinking of storage I have displayed
        return '<Queue: {}, storage size: {}>'.format(self._data[self._front: self._front + self._size ], len(self._data))       
if __name__ == "__main__":
    array_queue = ArrayQueue()
    print(array_queue)
    for i in range(1, 21):
        array_queue.enqueue(i)
    print(array_queue)
    print("Queue size: ", len(array_queue))
    print("Element at the front of the queue: ", array_queue.first())

    for i in range(1, 11):
        array_queue.dequeue()
    print(array_queue)
    print("Queue size: ", len(array_queue))
    print("Element at the front of the queue: ", array_queue.first())

    for i in range(1, 11):
        array_queue.dequeue()
    print(array_queue)
    print("Queue size: ", len(array_queue))
    # print("Element at the front of the queue: ", array_queue.first()) # uncomment this line to see Empty exception
    






