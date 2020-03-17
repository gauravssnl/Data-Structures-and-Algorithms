def insertion_sort(A):
    for k in range(1, len(A)):          # k = 0, 1,, .. till n-1 th index , will use this index for item at index 0
        curr = A[k]
        j = k
        while j > 0 and A[j-1] > curr:
            A[j] = A[j-1]
            j -= 1
        A[j] = curr
   

if __name__ == "__main__":
    arr = [10, 2, 1, 5, 6, 3, 12, 9]
    insertion_sort(arr)
    print(arr) 

