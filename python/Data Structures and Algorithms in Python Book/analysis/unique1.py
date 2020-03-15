# Overall complexity : O(n ** 2)
def unique1(S):
    for j in range(len(S)):
        for k in range(j+1, len(S)): 
            if S[j] == S[k]:
                return False
    return True

# 1st iteration of outer loop causes n-1 iteraions of inner loop, 
# 2nd iteration of outer loop causes n-2  iteraions of inner loop, and so on
# complexity: (n- 1) + (n -2) + (n -3) + ..... + 2 + 1 = (n -1) ( n- 1 + 1) / 2 = n(n-1) / 2 = O(n ** 2)

 