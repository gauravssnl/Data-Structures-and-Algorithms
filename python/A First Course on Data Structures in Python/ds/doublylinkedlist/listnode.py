class ListNode:
    """ List Node for a doubly linked list. """

    def __init__(self, data, prev=None, link=None):
        self.data = data
        self.prev = prev
        self.link = link
        if prev is not None:
            self.prev.link = self  # set the link of previous node to the current node
        if link is not None:
            self.link.prev = self  # set the previous of next node to the current node
