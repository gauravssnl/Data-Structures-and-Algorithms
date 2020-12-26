# Less optimal comapred to the version given below
# Note : Both of these functions keeps sorted part at the end of the list


def insertion_sort_v1(L):
    n = len(L)
    for i in range(n):
        for j in range(n - 1 - i, n - 1):
            if L[j] > L[j + 1]:
                L[j], L[j + 1] = L[j + 1], L[j]


def insertion_sort(L):
    n = len(L)
    for i in range(n):
        j = n - 1 - i
        # We stop the inner loop as soon as the element is in the right place
        while j < n - 1 and L[j] > L[j + 1]:
            L[j], L[j + 1] = L[j + 1], L[j]
            j += 1  # increase j value


if __name__ == "__main__":
    L = [5, 4, 2, 3, 9, 1]
    insertion_sort_v1(L)
    print(L)

    L = [5, 4, 2, 3, 9, 1]
    insertion_sort(L)
    print(L)
