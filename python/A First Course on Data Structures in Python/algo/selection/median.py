def median(L):
    L.sort()
    return L[len(L) // 2]

if __name__ == "__main__":
    L = [10, 17, 25, 1, 4, 15, 6]
    print(median(L))