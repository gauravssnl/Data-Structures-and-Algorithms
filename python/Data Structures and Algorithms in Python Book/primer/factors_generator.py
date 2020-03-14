def factors(n):
    for k in range(1, n+1):
        if n % k == 0:
            yield k


if __name__ == '__main__':
    num = 100
    result_genartor = factors(num)
    for factor in result_genartor:
        print("Factor of {} is {}".format(num, factor))