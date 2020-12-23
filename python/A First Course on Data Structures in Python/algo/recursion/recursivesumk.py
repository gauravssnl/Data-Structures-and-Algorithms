def recursve_sum(k):
    if k > 0:
        return recursve_sum(k - 1) + k
    return 0

if __name__ == "__main__":
    print(recursve_sum(10))