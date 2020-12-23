# A Greedy Algorithm example
def greedy_mc(coinvalue_list, change):
    # or use below code
    # coinvalue_list.sort()
    # coinvalue_list.reverse()
    coinvalue_list = sorted(coinvalue_list, reverse=True)
    num_coins = 0
    for coinvalue in coinvalue_list:
        num_coins += change // coinvalue
        change = change % coinvalue
    return num_coins

if __name__ == "__main__":
    print(greedy_mc([1, 5, 10, 25], 63))
    print(greedy_mc([1, 21, 25], 63)) # the optimal answer should be 3  as 21 * 3 = 63; output = 15
    print(greedy_mc([1, 5, 21, 25], 63)) # the optimal answer should be 3  as 21 * 3 = 63; output = 7



