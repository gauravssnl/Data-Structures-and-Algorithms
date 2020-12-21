import time

def timetrails(func, n=10, trials=10):
    total_time = 0
    for i in range(trials):
        start = time.time()
        func(n)
        end = time.time()
        total_time += end - start
    print("Ran {} trails of function {} with input size {} in average time  {:10.7f}s".format(trials, func.__name__, n, total_time / trials))
