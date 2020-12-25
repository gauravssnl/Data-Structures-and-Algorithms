def bs(L, item):
    if len(L) == 0:
        return False
    median = len(L) // 2
    if item == L[median]:
        return True
    elif item < L[median]:
        return bs(L[:median], item)
    else:
        return bs(L[median + 1:], item)


if __name__ == "__main__":
    nums = [1, 3, 4, 5, 8, 10, 12, 22, 35]
    print(bs(nums, 12))
    print(bs(nums, 20))
