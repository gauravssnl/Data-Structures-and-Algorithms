def fibonaci():
    a = 0
    b = 1
    while True:
        yield a
        future = a + b
        a = b
        b = future

if __name__ == "__main__" :
    fibonaci_gen = fibonaci()
    n = 20
    for i in range(20):
        print(next(fibonaci_gen))

