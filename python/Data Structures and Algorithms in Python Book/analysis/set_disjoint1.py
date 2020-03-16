# Three-Way Set Disjointness
# Overall complexity: O(n**3)

def disjoint1(A, B, C):
    for a in A:
        for b in B:
            for c in C:
                if a == b == c:
                    return False
    return True

if __name__ == "__main__":
    a = {1, 2, 3}
    b = {3, 4, 5}
    c = {5, 6, 7}
    print("Three sets {}, {}, and {} are disjoint: {}".format(a, b, c, disjoint1(a, b, c)) )
    a = {1, 2, 3}
    b = {3, 2, 5}
    c = {5, 6, 2}
    print("Three sets {}, {}, and {} are disjoint: {}".format(a, b, c, disjoint1(a, b, c)) )