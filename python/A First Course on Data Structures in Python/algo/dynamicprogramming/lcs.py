# Find Longest Common Substring (LCS) using Dynamic Programming
# Complexity : O(kn2) where k is the length of the output.


def lcs(X, Y):
    # store solutions of subprobelms
    t = {}
    for i in range(len(X) + 1):
        t[(i, 0)] = ""
    for j in range(len(Y) + 1):
        t[(0, j)] = ""

    for i, x in enumerate(X):
        for j, y in enumerate(Y):
            if x == y:
                t[(i + 1, j + 1)] = t[(i, j)] + x
            else:
                t[(i + 1, j + 1)] = max(t[(i + 1, j)], t[i, j + 1], key=len)
    return t[(len(X), len(Y))]


if __name__ == "__main__":
    print(lcs("abcdefghzxfghhtuttersdv", "cabdefghrstpcdvdxvzxzxcxvxc"))
