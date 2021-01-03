def quicksorted(L):
    # base case
    if len(L) < 2:
        return L[:]

    # Divide
    pivot = L[-1]
    # print("pivot:", pivot)
    LT = [e for e in L if e < pivot]
    GT = [e for e in L if e > pivot]
    ET = [e for e in L if e == pivot]

    # Conquer
    A = quicksorted(LT)
    B = quicksorted(GT)

    # Combine
    return A + ET + B


if __name__ == "__main__":
    nums = [12, 1, 5, 3, 10, 11, 7, 6, 2, 15]
    print(quicksorted(nums))
