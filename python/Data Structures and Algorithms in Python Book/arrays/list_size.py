import sys
def get_list_size(n):
    data = []
    for k in range(n):
        length = len(data)
        size= sys.getsizeof(data)
        print('Length: {0:3d}, Size in bytes: {1:4d}'.format(length, size))
        data.append(None)

if __name__ == "__main__":
    n = 30
    get_list_size(n)