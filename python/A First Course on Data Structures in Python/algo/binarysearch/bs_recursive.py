def bs(L, item, left=0, right=None):
    if right is None:
        right = len(L)
    if right - left == 0:
        return False
    if right - left == 1:  # only 1 element to sort
        return L[left] == item
    median = (left + right) // 2
    if item < L[median]:
        return bs(L, item, left, median)
    else:
        return bs(L, item, median, right)


if __name__ == "__main__":
    nums = [1, 3, 4, 5, 8, 10, 12, 22, 35]
    print(bs(nums, 12))
    print(bs(nums, 20))
