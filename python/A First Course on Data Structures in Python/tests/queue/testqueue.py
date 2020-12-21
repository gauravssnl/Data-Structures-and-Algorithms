class QueueTests:
    def test_init(self):
        q = self.Queue()

    def test_add_and_remove_oneitem(self):
        q = self.Queue()
        q.enqueue(3)
        self.assertEqual(q.dequeue(), 3)

    def test_alternating_addremove(self):
        q = self.Queue()
        for i in range(1000):
            q.enqueue(i)
            self.assertEqual(q.dequeue(), i)

    def test_manyoperations(self):
        q = self.Queue()
        for i in range(1000):
            q.enqueue(2 * i + 3)
        for i in range(1000):
            self.assertEqual(q.dequeue(), 2 * i + 3)

    def test_length(self):
        q = self.Queue()
        self.assertEqual(len(q), 0)
        for i in range(10):
            q.enqueue(i)
        self.assertEqual(len(q), 10)
        for i in range(10):
            q.enqueue(i)
        self.assertEqual(len(q), 20)
        for i in range(15):
            q.dequeue()
        self.assertEqual(len(q), 5)
