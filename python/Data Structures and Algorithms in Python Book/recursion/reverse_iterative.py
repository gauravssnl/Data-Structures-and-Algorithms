def reverse_iterative(S):
    start = 0
    stop = len(S) 
    while start < stop -1:
        S[start], S[stop-1] = S[stop -1], S[start]
        start += 1
        stop -= 1

if __name__ == "__main__":
    s = list(range(1, 21))
    print("Original Sequence:", s)
    reverse_iterative(s)
    print("New Sequence:", s)
