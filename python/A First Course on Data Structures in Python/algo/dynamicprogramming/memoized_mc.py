# Memoized version of recursive algo to find minimum coins for change
def memoized_mc(coinvalue_list, change, knowm_results={}):
    min_num_coins = change
    if change in coinvalue_list:
        return 1
    elif change in knowm_results:
        return knowm_results[change]
    else:
        for i in [c for c in coinvalue_list if c <= change]:
            num_of_coins = 1 + \
                memoized_mc(coinvalue_list, change - i, knowm_results)
            if num_of_coins < min_num_coins:
                min_num_coins = num_of_coins
                knowm_results[change] = min_num_coins
    return min_num_coins


if __name__ == "__main__":
    print(memoized_mc([1, 5, 10, 25], 63))