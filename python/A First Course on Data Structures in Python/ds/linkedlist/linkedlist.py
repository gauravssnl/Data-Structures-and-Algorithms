from .listnode import ListNode


class LinkedList:
    """ An optimal linked list using two members - head and tail to make performace better. """

    def __init__(self):
        self._head = None
        self._tail = None
        self._length = 0

    def add_first(self, item):
        self._head = ListNode(item, self._head)
        if self._tail is None:
            self._tail = self._head
        self._length += 1

    def add_last(self, item):
        if self._head is None:
            self.add_first(item)
        else:
            self._tail.link = ListNode(item, self._tail)
            self._tail = self._tail.link
            self._length += 1

    def remove_first(self):
        if self._head:
            item = self._head.data
            self._head = self._head.link
            if self._head is None:
                self._tail = None
            self._length -= 1
            return item

    def remove_last(self):
        if self._head is self._tail:
            return self.remove_first()
        else:
            current_node = self._head
            while current_node.link and current_node is not self._tail:
                current_node = current_node.link
            item = self._tail.data
            self._tail = current_node  # set the node previous to tail as the new tail node
            self._tail.link = None
            self._length -= 1
            return item

    def __len__(self): 
        return self._length
    
    # code added by Gaurav
    def get_head(self):
        return self._head
    
    def get_tail(self):
        return self._tail
