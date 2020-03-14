def fibonacci():
    a, b = 0, 1
    while True:
        yield a 
        a, b = b, a+b


if __name__ == '__main__':
    n = 20
    fibonacci_gen = fibonacci()
    for i   in range(20):
        print(next(fibonacci_gen))