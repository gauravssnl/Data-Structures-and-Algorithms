class Empty(Exception):
    """Error class for acessing element from an empty container/stack"""
    pass    # do nothing excpet inheriting Exception class

class ArrayStack:
    """LIFO Stack implementation using Python's list for storage"""

    def __init__(self):
        """Creates an empty stack"""
        self._data = []
    
    def __len__(self):
        """Return length of stack"""
        return len(self._data)
    
    def is_empty(self):
        """Return True if stack is empty"""
        return len(self._data) == 0
    
    def push(self, e):
        """Add element e to the top of the stack"""
        self._data.append(e)                            # store at the end of the list
    
    def top(self):
        """Return (but not remove) the elemnent at the top of the stack
        Raise Empty Exception if stack is empty
        """
        if self.is_empty():
            raise Empty("Stack is empty")

        return self._data[-1]                           # element at top of stack
    
    def pop(self):
        """Remove and return the elementy at the top od stack"""
        if self.is_empty():
            raise Empty("Stack is empty")
        return self._data.pop()
    
    def __str__(self):
        """Retutrn Stack data"""
        return '<Stack: {}>'.format(self._data)
    
if __name__ == "__main__":
    array_stack = ArrayStack()
    array_stack.push(1)
    array_stack.push(2)
    array_stack.push(3)
    print(array_stack, len(array_stack))
    print("element at the top of stack:", array_stack.top())
    array_stack.pop()
    print(array_stack, len(array_stack))
    print(array_stack, len(array_stack))