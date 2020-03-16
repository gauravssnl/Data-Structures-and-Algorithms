# Using Sorting
# Overall complexity: O(n log n ) as sorted() has that complexity

def unique2(S):
    temp = sorted(S) 
    for j in range(1, len(S)): # O(n)
        if S[j-1] == S[j]: # O(1)
            return False
    return True 