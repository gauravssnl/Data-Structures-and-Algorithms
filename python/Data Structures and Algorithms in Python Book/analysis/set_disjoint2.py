"""
The test a == b is evaluated O(n2) times.
The rest of the time spent depends upon how many matching (a,b) pairs exist.
As we have noted, there are at most n such pairs, and so the management of the loop
over C, and the commands within the body of that loop, use at most O(n2) time.
"""
# Overall complexity: O(n ** 2)
def disjoint2(A, B, C):
    for a in A:
        for b in B:
            if a == b:
                for c in C: # O(n**2) not n ** 3
                    if a == c:
                        return False
    return True


if __name__ == "__main__":
    a = {1, 2, 3}
    b = {3, 4, 5}
    c = {5, 6, 7}
    print("Three sets {}, {}, and {} are disjoint: {}".format(a, b, c, disjoint2(a, b, c)) )
    a = {1, 2, 3}
    b = {3, 2, 5}
    c = {5, 6, 2}
    print("Three sets {}, {}, and {} are disjoint: {}".format(a, b, c, disjoint2(a, b, c)) )