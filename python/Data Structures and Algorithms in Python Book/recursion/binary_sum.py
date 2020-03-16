# Time Complexity: O(n) as there are 2n-1 function calls
# Space Complexity: O(log n) 
# As we are dividing the recursive call range into half => depth of recursion = 1 + logn(base 2)
def binary_sum(S, start, stop):
    if start >= stop:               # zero element in the slice
        return 0
    elif start == stop -1:          # one element in the slice
        return S[start]
    else:
        mid = (start + stop) // 2
        return binary_sum(S, start, mid) + binary_sum(S, mid, stop) # first half includes sum till mid -1

if __name__ == "__main__":
    s = list(range(1, 11))
    print(binary_sum(s, 0, len(s)))