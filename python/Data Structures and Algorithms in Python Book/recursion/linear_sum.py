# For n inputs, this function makes n+1 calls
# Complexity: O(n)
def linear_sum(S, n):
    """Computing the sum of a sequence recursively, by adding the last number to the sum of the first n−1 numbers"""
    if n == 0:
        return 0
    else:
        print("linear_sum({}, {}) + S[n-1]: {}".format(S, n-1, S[n-1]))
        return linear_sum(S, n-1) + S[n-1]

if __name__ == "__main__":
    s = list(range(1, 11))
    print(linear_sum(s, len(s)))