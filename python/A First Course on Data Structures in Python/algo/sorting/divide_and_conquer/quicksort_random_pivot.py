from random import randrange


def quicksort(L):
    return _quicksort(L, 0, len(L))


def _quicksort(L, left, right):
    if right - left > 1:
        mid = partition(L, left, right)
        _quicksort(L, left, mid)
        _quicksort(L, mid + 1, right)


def partition(L, left, right):
    pivot = randrange(left, right)  # select random index as pivot
    # Swap rightmost index value with element at pivot index
    # righttmost index will contain pivot index value
    L[pivot], L[right - 1] = L[right - 1], L[pivot]
    i, j, pivot = left, right - 2, right - 1
    while i < j:
        while L[i] < L[pivot]:
            i += 1
        while i < j and L[j] >= L[pivot]:
            j -= 1

        if i < j:
            L[i], L[j] = L[j], L[i]

    if L[pivot] <= L[i]:
        L[i], L[pivot] = L[pivot], L[i]
        pivot = i
    return pivot


if __name__ == "__main__":
    L = list(reversed(range(1000)))
    quicksort(L)
    print(L)

    nums = [32, 18, 20, 6, 17, 10, 7, 1, 3, 2]
    quicksort(nums)
    print(nums)
