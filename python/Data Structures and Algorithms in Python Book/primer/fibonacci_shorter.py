def fibonacci():
    a, b = 0, 1
    yield a 
    a, b = b, a+b


if __name__ == '__main__':
    n = 20
    fibonacci_gen = fibonacci()
    for num  in fibonacci_gen:
        print(num)