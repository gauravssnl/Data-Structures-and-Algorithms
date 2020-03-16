import sys
print("Recursion Limit: ", sys.getrecursionlimit())
sys.setrecursionlimit(1000000)
print("New Recursion Limit: ", sys.getrecursionlimit())