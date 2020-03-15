# Overall complexity O(n^2)
def prefix_average2(S):
    n = len(S)
    A = [0] * n
    for j in range(n):
        A[j] = sum(A[0: j+1]) / j # O(j+1) => 1 + 2 + 3 + ... + n = n(n+1) / 2
    return A
