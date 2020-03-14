def factors(n):
    k = 1
    while k * k < n:    # while k < sqrt(n)
        if n % k == 0:
            print("Yield k: ", k)
            yield k
            print("Yield n// k where n is {}, k is {} and  n//k is {}".format(n, k, n//k))
            yield n // k
        k += 1
    
    if k * k == n:      # special case if n is a perfect square
        print("k value is {} and k * k == n".format(k))
        yield k


if __name__ == "__main__":
    num = 100
    for factor in factors(num):
        print("Factor of {} is {}".format(num, factor))