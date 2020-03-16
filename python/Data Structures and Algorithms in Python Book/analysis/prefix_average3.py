# Overall complexity: O(n)
def prefix_average3(S):
    n = len(S) # O(1)
    A = [0] *  n # O(n)
    total = 0
    for j in range(n): #O(n)
        total += S[j] # O(1)
        A[j] = total / ( j +1 ) # O(1)
    return A

if __name__ == "__main__":
    seq = [1, 2, 3, 4, 5, 6]
    print("The prefix average for the sequnce: ", prefix_average3(seq))
        