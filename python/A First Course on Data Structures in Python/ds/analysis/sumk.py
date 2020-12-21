def sumk(k):
    sum = 0
    for i in range(1, k + 1):
        sum += k
    return sum


def optimal_sumk(k):
    return k * ((k + 1) // 2)
