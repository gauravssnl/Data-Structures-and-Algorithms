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
    
    # def __str__(self):
    #     return '< Dynamic Array {} >'.format(list(self._A)) # convert PyArray object into list to print 
    
    def insert(self, k, val):
        """Insert value at index k, and shift subsequent elements to the right"""
        if not 0 <= k < self._n:
            raise IndexError("Invalid Index")
        if self._n == self._capacity:
            self._resize(2 * self._capacity)
        for j in range(self._n, k, -1):             # shift elements after k  to the next right index
            self._A[j] = self._A[j-1]
        self._A[k] =  val                           # store newest element
        self._n += 1
        # print("Insert: " , self._A, self._capacity, self._n)
  

if __name__ == "__main__":
    dynamic_array = DynamicArray()
    dynamic_array.append(1)
    # print(dynamic_array)
    print(dynamic_array[0])
    dynamic_array.append(2)
    dynamic_array.append(3)
    dynamic_array.append(4)
    dynamic_array.append(5)
    dynamic_array.append(6)
    dynamic_array.append(7)
    dynamic_array.append(8)
    dynamic_array.append(9)
    dynamic_array.append(10)
    # print(dynamic_array)
    dynamic_array.insert(1, 100)
    
    for i in range(len(dynamic_array)):
        print("Value at index {} : {}".format(i, dynamic_array[i]))