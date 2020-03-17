from time import time

def compute_average_append_amortized_cost(n):
    """Perform n appends to an empty list and return average time elapsed"""
    data = []
    start = time()                  # in seconds, multiply if you want to measure in micro-seconds
    for k in range(n):
        data.append(n)
    end = time()
    return (end - start)/ n

if __name__ == "__main__":
    n = 100
    while n <= 100000:
        print(compute_average_append_amortized_cost(n))
        n *= 10