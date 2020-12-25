def is_sort_slow(L):
    for i in range(len(L) - 1):
        for j in range(i + 1, len(L)):
            if L[i] > L[j]:
                return False
    return True


if __name__ == "__main__":
    print(is_sort_slow([1, 3, 5, 6, 9, 15]))
    print(is_sort_slow([1, 3, 10, 9]))
