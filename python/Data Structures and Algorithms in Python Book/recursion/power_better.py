# complexity : O(log n ) as in Binary search
# the number of times that we can divide n in half before getting to one or less is O(logn).

def power(x, n):
    if n == 0:
        return 1
    else:
        partial = power(x, n // 2)
        result = partial * partial      # eqaul to x^n for even 
        if n % 2 == 1:                  #odd
            # multiply prefix by x to get x^n
            result *= x
        return result

if __name__ == "__main__":
    print(power(2, 6))
    