# Overall complexity O(n^2)
def prefix_average2(S):
    n = len(S)
    A = [0] * n
    for j in range(n):
        A[j] = sum(A[0: j+1]) / (j+1) # O(j+1) => 1 + 2 + 3 + ... + n = n(n+1) / 2
    return A

if __name__ == "__main__":
    seq = [1, 2, 3, 4, 5, 6]
    print("The prefix average for the sequnce: ", prefix_average2(seq))
