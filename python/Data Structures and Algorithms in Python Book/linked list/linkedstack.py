
class Empty(Exception):
    """Exception class to be used when container is empty."""
    pass

class LinkedStack:
    """LIFO stack implementation using a singly linked list for storage"""

    # nested _Node class for the nodes of the singly linked list
    class _Node:
        """Lightweight, nonpublic class for storing singly linked list node"""
        __slots__ = ['_element', '_next']    # streamline memory usage

        def __init__(self, element, next):
            """Initialze node"""
            self._element = element         # reference to node's field
            self._next = next               # reference to next node
        
        def __str__(self):
            return "{} -> {}".format(self._element, self._next)
    
    # LinkedStack methods
    def __init__(self):
        """Create an empty stack"""
        self._head = None                   # reference to the head node
        self._size = 0                      # no. of elements in stack
    
    def __len__(self):
        """Return the no. of elements in the stack"""
        return self._size
    
    def is_empty(self):
        """Return True if the stack is empty"""
        return self._size == 0
    
    def push(self, e):
        """Add element e to the top of the stack"""
        self._head = self._Node(e, self._head)               # Create and link new node
        self._size +=1     
    
    def top(self):
        """Return (but don't remove) the element at the top of the stack.
        Raise Empty Exception if the stack is enmpty."""
        if self.is_empty():
            raise Empty("Stack is empty")
        return self._head._element                       # top of the stack is at the head of the list
    
    def pop(self):
        """Return and remove the element at the top of the stack.
        Raise Empty exception if the stack is empty."""
        if self.is_empty():
            raise Empty("Stack is empty")
        element = self._head._element                     # get the element at the top of stack/ head of the list 
        self._head = self._head._next                    # set head to the next node 
        self._size -= 1                                   # reduce stack size
        return element
    
    def __str__(self):
        return "< LinkedStack: [{}] >".format(self._head)

if __name__ == "__main__":
    linked_stack = LinkedStack()
    print(linked_stack)
    linked_stack.push(1)
    print(linked_stack)

    print("Size of linked stack:", len(linked_stack))
    for i in range(2, 11):
        linked_stack.push(i)
    print(linked_stack)
    print("Size of linked stack:", len(linked_stack))

    print("Element at the head of list:", linked_stack.top())

    for i in range(1, 6):   # pop first 5 elements at top of stack
        linked_stack.pop()
    print(linked_stack)
    print("Size of linked stack:", len(linked_stack))

    for i in range(1, 6):   # pop next 5 elements at top of stack
        linked_stack.pop()
    print(linked_stack)
    print("Size of linked stack:", len(linked_stack))
    # print("Element at the head of list:", linked_stack.top())  # uncomment to see the empty stack exception 

    linked_stack.push(1)
    print(linked_stack)


        
