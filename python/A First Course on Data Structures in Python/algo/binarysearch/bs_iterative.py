def bs(L, item):
    left, right = 0, len(L)
    while right - left > 1:
        median = (left + right) // 2
        if item < L[median]:  # search in left part
            right = median
        else:  # search in right part
            left = median
    return left < right and L[left] == item


if __name__ == "__main__":
    nums = [1, 3, 4, 5, 8, 10, 12, 22, 35]
    print(bs(nums, 12))
    print(bs(nums, 20))
