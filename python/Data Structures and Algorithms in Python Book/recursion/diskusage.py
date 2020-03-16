import os

# Complexity : O (n) - stronger bound
# weaker bound - O ( n ** 2)
def disk_usage(path):
    total = os.path.getsize(path)
    print("Path: {} is  {}".format(path, 'directory' if os.path.isdir(path) else 'file'))
    if os.path.isdir(path):
        for filename in os.listdir(path):
            childpath = os.path.join(path, filename)
            total += disk_usage(childpath)
    print('{0:7} {1:100}'.format(total, path))
    return total

if __name__ == "__main__":
    path = "D:\coding\Data-Structures-and-Algorithms"
    total_disk_usage = disk_usage(path)
    print("Total disk usage: ", total_disk_usage)