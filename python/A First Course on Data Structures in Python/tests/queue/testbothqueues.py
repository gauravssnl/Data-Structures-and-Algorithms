import unittest

from ds.linkedlist import LinkedList
from ds.queue import LinkedQueue, ListQueue
from .testqueue import QueueTests

def _test(queue_class):
    class QueueTestCase(unittest.TestCase, QueueTests):
        Queue = queue_class
    return QueueTestCase

TestLinkedQueue = _test(LinkedQueue)
TestListQueue =  _test(ListQueue)
if __name__ == '__main__':
    unittest.main()
