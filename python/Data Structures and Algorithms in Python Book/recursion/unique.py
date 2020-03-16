# Find unique element by using recursion
def unique(S, start, stop):
    """Return True if there are no duplicate elements in slice S[start: stop]"""
    print("start = {}, stop = {}".format(start, stop))
    if stop - start <= 1:                                                              # at most 1 item
        return True                  
    elif not unique(S, start, stop-1):                                                 # first part has duplicate
        print("checking uniqueness in (S, {}, {})".format(start, stop-1))                
        return False    
    elif not unique(S, start+1, stop):                                                 # second part has duplicate
         print("checking uniqueness in (S, {}, {})".format(start+1, stop))   
         return False     
    else:
        print("Check uniqueness of 1st and last element for start = {} and stop = {}"
        .format(start, stop))                                                          # do first and last differ
        return S[start] != S[stop]                                                     # do first and last differ                   

# Complexity: O(2 ^(n -1) ) : 2 raised to the power ( n- 1)

if __name__ == "__main__":
    s1 = [1, 2, 3, 4, 5, 6, 7]
    print("s1 has unique elements:", unique(s1, start=0, stop=len(s1)-1))

    s2 = [1, 2, 3, 4, 1, 6, 7, ]
    print("s2 has unique elemnts:", unique(s2, start=0, stop=len(s2)-1))