from ds.iterator.bufferediterator import BufferedIterator


def merge(A, B):
    a = BufferedIterator(A)
    b = BufferedIterator(B)
    while a.hasnext() or b.hasnext():
        if not b.hasnext() or (a.hasnext() and a.peek() < b.peek()):
            yield next(a)
        else:
            yield next(b)


def mergesort(L):
    if len(L) > 1:
        mid = len(L) // 2
        A, B = L[:mid], L[mid:]
        mergesort(A)
        mergesort(B)
        L[:] = merge(A, B)


if __name__ == "__main__":
    l = [1, 30, 5, 13, 10, 6, 4, 15, 2]
    mergesort(l)
    print(l)
