from .listqueuefakedelete import ListQueueFakeDelete

class ListQueue(ListQueueFakeDelete):
    def dequeue(self):
        item = self._L[self._head]
        self._head += 1
        if self._head > len(self._L) // 2:
            self._L = self._L[self._head:len(self._L)] # we need to discard deleted items
            self._head = 0 # set head again to 0
        return item