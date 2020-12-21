import unittest

from ds.stack import ListStack;

class TestStack(unittest.TestCase):
    def testinit(self):
        ls = ListStack()
    
    def test_push(self):
        ls = ListStack()
        n = 100
        for i in range(n):
            ls.push(i)
        self.assertEqual(len(ls), n)
    
    def test_pop(self):
        ls = ListStack()
        for i in range(5):
            ls.push(i)
        for i in range(5):
            ls.pop()
            self.assertEqual(len(ls), 5 - i -1)

    def test_ierator(self):
        ls = ListStack()
        for x in range(1, 21):
            ls.push(x)
        for i, v in enumerate(ls):
            self.assertEqual(v, i + 1)

        

if __name__ == "__main__":
    unittest.main()
