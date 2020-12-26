def selectionsort(L):
    n = len(L)
    # n - 1 is the index of last element
    for i in range(n - 1):
        max_index = 0  # dummy index for the largest value
        for index in range(n - i):
            if L[index] > L[max_index]:
                max_index = index
        L[n - 1 - i], L[max_index] = L[max_index], L[n - 1 - i]


if __name__ == "__main__":
    L = [5, 4, 3, 2, 1]
    selectionsort(L)
    print(L)
