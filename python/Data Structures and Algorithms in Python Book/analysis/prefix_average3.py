# Overall complexity: O(n)
def prefix_average3(S):
    n = len(S) # O(1)
    A = [0] *  n # O(n)
    total = 0
    for j in range(n): #O(n)
        total += S[j] # O(1)
        A[j] = total / ( j +1 ) # O(1)
    return A