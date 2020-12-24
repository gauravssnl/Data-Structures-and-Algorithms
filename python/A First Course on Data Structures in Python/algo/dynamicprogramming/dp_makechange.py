def dp_make_change(coinvalue_list, change):
    # Create a list to store the answers to the sub-problems
    min_num_coins_list = [None] * (change + 1)

    # For each value from 0 to change, compute the minimumn no. of coins needed
    for cents in range(change + 1):
        # Assume at first that all 1's are used
        min_num_coins_list[cents] = cents
        for c in coinvalue_list:
            if cents >= c:
                min_num_coins_list[cents] = min(
                    min_num_coins_list[cents], min_num_coins_list[cents - c] + 1)
    # Return the element in the table corresponding on to the desired value.
    return min_num_coins_list[change]


if __name__ == "__main__":
    print(dp_make_change([1, 5, 10, 21, 25], 63))
    print(dp_make_change([1, 5, 10, 21, 25], 64))
