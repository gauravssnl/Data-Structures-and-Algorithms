# Overall complexity: O(n)
# assignemnt of biggest have complexity of O(n) for increasing ordered elemenets , since biggest is assigned n-1 times
# for randomly ordered value, the probablilty that the item is the biggest = 1 / j
# hence the no of times we update biggest is Hn(Harmnic Number) = sum(1/ j) for j =1, 2, ... till n 
# complexity for Hn is O(log n)
def find_max(data):
    biggest = data[0] # O(1)
    for val in data:  #O(n)
        if val > biggest: # O(1)
            biggest = val
    return biggest
