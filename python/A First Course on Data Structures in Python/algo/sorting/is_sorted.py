def is_sorted(L):
    for i in range(len(L) - 1):
        if L[i] > L[i + 1]:
            return False
    return True


if __name__ == "__main__":
    print(is_sorted([1, 3, 5, 6, 9, 15]))
    print(is_sorted([1, 3, 10, 9]))
