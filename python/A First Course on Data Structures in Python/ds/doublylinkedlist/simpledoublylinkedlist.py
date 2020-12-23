from .listnode import ListNode


class SimpleDoublyLinkedList:
    def __init__(self):
        self._head = None
        self._tail = None
        self._length = 0

    def add_first(self, item):
        if len(self) == 0:
            self._head = self._tail = ListNode(item, None, None)
        else:
            new_node = ListNode(item, None, self._head)
            self._head.prev = new_node
            self._head = new_node
        self._length += 1

    def add_last(self, item):
        if len(self) == 0:
            self._head = self._tail = ListNode(item, None, None)
        else:
            new_node = ListNode(item, self._tail, None)
            self._tail.link = new_node
            self._tail = new_node
        self._length += 1

    def __len__(self):
        return self._length
