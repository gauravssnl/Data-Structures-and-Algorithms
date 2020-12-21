from .listnode import ListNode


class SimpleLinkedList:
    """ A simple linked list using only head for storing/removing data. """

    def __init__(self):
        self._head = None

    def add_first(self, item):
        self._head = ListNode(item, self._head)

    def remove_first(self):
        if self._head:
            item = self._head.data
            self._head = self._head.link
            return item

    def add_last(self, item):
        if self._head is None:
            self.add_first(item)
        else:
            current_node = self._head
            while current_node:
                current_node = current_node.link
            current_node.link = ListNode(item)  # ListNode(item, None)

    def remove_last(self):
        if self._head and self._head.link is None:  # there is only 1 item , i.e. head
            return self.remove_first()
        else:
            current_node = self._head
            while current_node.link.link is not None:   # we already know that there is at least 1 item after head
                current_node = current_node.link
            item = current_node.link.data
            current_node.link = None
            return item
