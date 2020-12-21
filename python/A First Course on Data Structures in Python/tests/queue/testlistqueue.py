import unittest

from ds.queue import ListQueue
from .testqueue import QueueTests


class TestListQueue(unittest.TestCase, QueueTests):
    Queue = ListQueue


if __name__ == "__main__":
    unittest.main()
