# Complextity : O(n^2)
def bubblesort(L):
    for iteration in range(len(L)):
        for i in range(len(L) - 1):
            if L[i] > L[i + 1]:
                L[i], L[i + 1] = L[i + 1], L[i]


# This will stop sorting in 1st ietartion if all the items are already sorted
def bubble_sort_better(L):
    keepgoing = True
    while keepgoing:
        keepgoing = False
        for i in range(len(L) - 1):
            if L[i] > L[i + 1]:
                L[i], L[i + 1] = L[i + 1], L[i]
                keepgoing = True


if __name__ == "__main__":
    L = [5, 4, 3, 2, 1]
    bubblesort(L)
    print(L)
    L = [13, 1, 2, 30, 20, 15, 17]
    bubble_sort_better(L)
    print(L)
    L = list(range(1, 21))
    bubble_sort_better(L)
    print(L)
