def fibonacci(k):
    a, b = 0, 1
    for i in range(k):
        a, b = b, a + b
    return a


if __name__ == "__main__":
    print([fibonacci(i) for i in range(50)])
