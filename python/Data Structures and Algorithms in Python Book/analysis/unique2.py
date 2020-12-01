# Using Sorting
# Overall complexity: O(n log n ) as sorted() has that complexity

def unique2(S):
    temp = sorted(S) 
    for j in range(1, len(S)): # O(n)
        if temp[j-1] == temp[j]: # O(1)
            return False
    return True 

if __name__ == "__main__":
    a1 = [1, 2, 3, 5, 7, 9, 4]
    print("The elements of {} are {}".format(a1, 'unique' if unique2(a1) else 'not unique'))
    a2 = [1, 2, 3, 5, 7, 9, 1]
    print("The elements of {} are {}".format(a2, 'unique' if unique2(a2) else 'not unique'))