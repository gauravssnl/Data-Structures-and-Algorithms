def quicksort(L, left=0, right=None):
    if right is None:
        right = len(L)
    if right - left > 1:
        # Divide!
        mid = partition(L, left, right)

        # Conuqer!
        quicksort(L, left, mid)
        quicksort(L, mid + 1, right)

        # Combine!
        # Nothing to merge


def partition(L, left, right):
    pivot = right - 1  # rightmost index is taken as pivot index
    i = left
    j = right - 1
    while i < j:
        # Move i to point to an element >= L[pivot]
        while L[i] < L[pivot]:
            i += 1

        # Move j to point to an element < L[pivot]
        while i < j and L[j] >= L[pivot]:
            j -= 1

        # Swap elements at i and j if i < j
        if i < j:
            L[i], L[j] = L[j], L[i]

    # Put the pivot in place
    if L[pivot] <= L[i]:
        L[i], L[pivot] = L[pivot], L[i]
        pivot = i
    return pivot


if __name__ == "__main__":
    nums = [32, 18, 20, 6, 17, 10, 7, 1, 3, 2]
    quicksort(nums)
    print(nums)
    # The below example will not work and will lead to Recursion error
    # L = list(reversed(range(1000)))
    # quicksort(L)
    # print(L)
