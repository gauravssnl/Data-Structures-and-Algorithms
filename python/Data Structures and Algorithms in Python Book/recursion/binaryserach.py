# complexity : O(logn)
def binary_search(data, target, low, high):
    if low > high:
        return False
    mid = (high + low) // 2
    print("low: {}, high: {}, mid: {}".format(low, high, mid))
    if target == data[mid]:
        return True
    elif target < data[mid]:
        print("go before mid: ", mid)
        return binary_search(data, target, low, mid-1)
    else:
        print("go after mid: ", mid)
        return binary_search(data, target, mid+1, high)


if __name__ == "__main__":
    l = sorted([1, 2, 20, 3, 45, 67, 89, 23, 56, 70])
    key = 56
    print("Key: {} is present in the list: {}".format(key, binary_search(l, key, 0, len(l))))