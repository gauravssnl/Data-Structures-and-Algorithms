def fibonacci(k):
    if k in [0, 1]:
        return k
    else:
        return fibonacci(k - 1) + fibonacci(k - 2)

if __name__ == "__main__":
    print([fibonacci(i) for i in range(30)])
