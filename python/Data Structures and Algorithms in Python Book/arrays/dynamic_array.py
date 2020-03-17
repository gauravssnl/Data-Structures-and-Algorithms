import ctypes

class DynamicArray:
    """A dynamic array class similar to Python list class"""

    def __init__(self):
        """Create an empty array"""
        self._n = 0                                     # actual no. of stored elements
        self._capacity = 1                              # default array capacity 
        self._A = self._make_array(self._capacity)      # low level array
    
    def __len__(self):
        """Returns the no of elemnts stored in array"""
        return self._n
    
    def __getitem__(self, k):
        """Return item at index k"""
        if not 0 <= k < self._n:
            raise IndexError("Inavlid Index")
        return self._A[k]
    
    def append(self, obj):
        """Add object obj to the end of array"""
        # print("Append() Capacity:", self._capacity, "No of elements:", self._n)
        if self._n == self._capacity:           #not enough space
            self._resize(2 * self._capacity )   # double the capacity
        self._A[self._n] = obj
        self._n += 1
    
    def _resize(self, capacity):
        """Resize internal array to new capacity"""
        B = self._make_array(capacity)          # new bigger array   
        for k in range(self._n):
            B[k] = self._A[k]                   # store old array elemnts into new bigger array
        self._A = B
        self._capacity = capacity                            # assign new bigger array to the old array
    
    def _make_array(self, capacity):
        """Make new array object with the given capacity"""
        # print("Make array new capacity: ", capacity)
        return (capacity * ctypes.py_object)()
    
    def __str__(self):
        return '< Dynamic Array {} >'.format(list(self._A)) # convert PyArray object into list to print 
    

if __name__ == "__main__":
    dynamic_array = DynamicArray()
    dynamic_array.append(1)
    print(dynamic_array)
    print(dynamic_array[0])
    dynamic_array.append(2)
    dynamic_array.append(3)
    dynamic_array.append(4)
    print(dynamic_array)