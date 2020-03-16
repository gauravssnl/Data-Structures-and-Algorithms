# we compute prefix average for sequnce: S[0], S[1], .... s[j]
# we presume that there were no duplicates within a single collection
# overall complexity : O(n^2)
def prefix_average1(S):
    n = len(S)
    A = [0] * n
    for j in range(n): # O(n)
        total = 0
        for i in range(j+1): # O(n^2) for maintaining counter i
            total += S[i]    # 1 + 2 + 3 + ..... + n = n(n +1) / 2  => O(n^2) for addtion operation
        A[j] = total / (j+1) 
    return A


if __name__ == "__main__":
    seq = [1, 2, 3, 4, 5, 6]
    print("The prefix average for the sequnce: ", prefix_average1(seq))
