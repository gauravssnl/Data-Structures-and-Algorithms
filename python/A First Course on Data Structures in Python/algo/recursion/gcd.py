def gcd1(a, b):
    if a == b:
        return a
    if a > b:
        a, b = b, a
    return gcd1(a, b - a)


# Better approach
def gcd(a, b):
    if a > b:
        a, b = b, a
    if a == 0:
        return b
    return gcd(a, b % a)


if __name__ == "__main__":
    print(gcd1(20, 80))
    print(gcd1(40, 60))

    print(gcd(20, 80))
    print(gcd(40, 60))
