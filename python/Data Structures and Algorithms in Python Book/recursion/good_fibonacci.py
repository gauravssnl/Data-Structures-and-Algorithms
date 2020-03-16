def good_fibonacci(n):
    """Return pair of Fibonacci numbers, F(n) and F(n-1)"""
    if n <= 1:
        return (n, 0)
    else:
        a, b = good_fibonacci(n-1) 
        return a +b, a
# Complexity: O(n)

if __name__ == "__main__":
    n = 10
    print("{}th fibonacci number: {}".format(n, good_fibonacci(n) [0]))