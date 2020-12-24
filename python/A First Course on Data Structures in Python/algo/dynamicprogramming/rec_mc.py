def rec_mc(coinvalue_list, change):
    min_num_coins = change  # initailly set minimum no. of coins to change
    if change in coinvalue_list:
        return 1
    else:
        for i in [c for c in coinvalue_list if c <= change]:
            # pass the remaining change in recursive call
            num_coins = 1 + rec_mc(coinvalue_list, change - i)
            if num_coins < min_num_coins:
                min_num_coins = num_coins
    return min_num_coins


if __name__ == "__main__":
    print(rec_mc([1, 21, 25], 63))
    print(rec_mc([1, 5, 21, 25], 63))
    # print(rec_mc([1, 5, 10, 25], 63))  # Don't even try to run this
