def is_sorted(L):
    for i in range(len(L) - 1):
        if L[i] > L[i + 1]:
            return False
    return True


def dumbersort(L):
    """ Move the ith largest elemnt to the right in the ith function call. """
    for i in range(len(L) - 1):
        if L[i] > L[i + 1]:
            L[i], L[i + 1] = L[i + 1], L[i]


def dumbsort(L):
    """ Keep on sorting the list while it is not sorted. """
    while not is_sorted(L):
        dumbersort(L)


if __name__ == "__main__":
    L = [5, 4, 3, 2, 1]
    dumbersort(L)
    print(L)

    L = [5, 4, 3, 2, 1]
    dumbsort(L)
    print(L)
