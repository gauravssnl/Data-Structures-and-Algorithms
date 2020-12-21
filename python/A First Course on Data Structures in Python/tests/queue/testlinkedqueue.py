import unittest

from ds.queue import LinkedQueue

from .testqueue import QueueTests

class TestLinkedQueue(unittest.TestCase, QueueTests):
    Queue = LinkedQueue

if __name__ == '__main__':
    unittest.main()