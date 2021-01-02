# Time Complexity: O(n logn)
def mergesort(L):
    if len(L) < 2:
        return
    mid = len(L) // 2
    # Divide
    A = L[:mid]
    B = L[mid:]
    # Conuqer
    mergesort(A)
    mergesort(B)
    # Merge
    merge(A, B, L)
    # merge_variant(A, B, L)


def merge(A, B, L):
    i = 0  # index into A
    j = 0  # index into B
    while i < len(A) and j < len(B):
        if A[i] < B[j]:
            L[i + j] = A[i]
            i += 1
        else:
            L[i + j] = B[j]
            j += 1
    # Add any remaining elements once one list is empty
    L[i+j:] = A[i:] + B[j:]


def merge_variant(A, B, L):
    i, j = 0, 0
    while i < len(A) or j < len(B):
        if j == len(B) or (i < len(A) and A[i] < B[j]):
            L[i+j] = A[i]
            i += 1
        else:
            L[i+j] = B[j]
            j += 1


if __name__ == "__main__":
    nums = [2, 20, 1, 12]
    mergesort(nums)
    print(nums)

    nums = [20, 12]
    mergesort(nums)
    print(nums)
