def bad_fibonacci(n):
    """Returns the nth Fibonacci number"""
    if n <= 1:
        return n
    else:
        return bad_fibonacci(n-2) + bad_fibonacci(n-1)

# No of calls to the function: cn > 2n/2, which means that bad fibonacci(n) makes a number of calls that is exponential in n.

if __name__ == "__main__":
    print(bad_fibonacci(10))