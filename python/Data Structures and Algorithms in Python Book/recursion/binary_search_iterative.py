# Eliminate tail recursion
def binary_search_iterative(data, target):
    low = 0
    high = len(data) - 1
    
    while low <= high:
        mid = (high + low) // 2
        if target == data[mid]:
            return True
        elif target < data[mid]:
            high = mid -1
        else:
            low = mid + 1

if __name__ == "__main__":
    l = sorted([1, 2, 20, 3, 45, 67, 89, 23, 56, 70])
    key = 56
    print("Key: {} is present in the list: {}".format(key, binary_search_iterative(l, key)))

