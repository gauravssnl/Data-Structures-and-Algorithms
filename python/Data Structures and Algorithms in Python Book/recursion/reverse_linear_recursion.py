# a total of 1+ math.floor(n/2) recusrive call
# Complexity: O(n)
# Tail recursion
def reverse(S, start, stop):
    """Reverse elements in S[start:stop] recursively"""
    if start < stop - 1:    # at least 2 elements
        S[start], S[stop-1] = S[stop-1], S[start]   # swap first with last and last with first
        return reverse(S, start+1, stop -1)         # recursive call on others

if __name__ == "__main__":
    s = list(range(1, 21))
    print("Original Sequence:", s)
    reverse(s, 0, len(s))
    print("New Sequence:", s)