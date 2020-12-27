class Foo:
    def __init__(self, a, b, c):
        self.a = a
        self.b = b
        self.c = c

    # used in sort method of list
    def __lt__(self, other):
        return other.b < self.b  # sort in descending order
        # return self.b < other.b # sort in ascending order

    # we can use the blow code also for sorting
    # def __gt__(self, other):
    #     return self.b > other.b

    def __str__(self):
        return '(%d, %d, %d)' % (self.a, self.b, self.c)

    # used when we pass key function to sort
    def geta(self):
        return self.a


if __name__ == "__main__":
    from random import randrange
    f = Foo(randrange(100), randrange(100), randrange(100))
    print(f)
    L = [f] * 6
    print(L)
    for x in L:
        print(x)

    L = [Foo(randrange(100), randrange(100), randrange(100)) for i in range(6)]
    print(L)
    for x in L:
        print(x)
    L.sort()
    print("List after sorting")
    for x in L:
        print(x)

    # sort on the basis of property 'c' in ascending order
    L.sort(key=lambda x: x.c)
    print("List after sorting by key function")
    for x in L:
        print(x)
    L.sort(key=getattr(Foo, 'geta'))
    print("List after sorting by key function")
    for x in L:
        print(x)

    L.sort(key=lambda x: x.c)
    L.sort(key=Foo.geta)
    print("List after sorting by key function")
    for x in L:
        print(x)
