from .listnode import ListNode


class DoublyLinkedList:
    def __init__(self):
        self._head = None
        self._tail = None
        self._length = 0

    def __len__(self):
        return self._length

    def _add_between(self, item, before, after):
        new_node = ListNode(item, before, after)
        if after is self._head:
            self._head = new_node
        if before is self._tail:
            self._tail = new_node
        self._length += 1

    def add_first(self, item):
        self._add_between(item, None, self._head)

    def add_last(self, item):
        self._add_between(item, self._tail, None)

    def _remove(self, node):
        before, after = node.prev, node.link
        if node is self._head:
            self._head = after
        else:
            before.link = after
        if node is self._tail:
            self._tail = before
        else:
            after.prev = before
        self._length -= 1
        return node.data

    def remove_first(self):
        return self._remove(self._head)

    def remove_last(self):
        return self._remove(self._tail)

    # Concatenating Doubly Linked Lists
    def __iadd__(self, other):
        if other._head is not None:
            if self._head is None:
                self._head = other._head
            else:
                other._head.prev = self._tail
                self._tail.link = other._head
            self._tail = other._tail
            self._length += other._length

            # Clean up the other list to remove LisNode references
            other.__init__()
            # similar to __iter__, we need to return self
            return self
    
    # code added by Gaurav
    def get_head(self):
        return self._head
    
    def get_tail(self):
        return self._tail

if __name__ == "__main__":
    L = DoublyLinkedList()
    [L.add_last(i) for i in range(11)]
    B = DoublyLinkedList()
    [B.add_last(i + 11) for i in range(10)]
    L += B
    n = L.get_head()
    while n is not None:
        print(n.data, end=' ')
        n = n.link
