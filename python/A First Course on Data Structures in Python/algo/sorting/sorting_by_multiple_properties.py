# If the key function returns a tuple, it will sort by the first element and
# break ties with subsequent elements.
# an example of sorting strings by their length (longest to shortest)
# using the alphabetical order (ignoring case) to break ties - lexico-graphic sorting.


def my_key(x):
    return -len(x), x.upper()


strings = "here are Some sample strings to be sorted".split()
print(strings)
print("After sorting")
print(sorted(strings, key=my_key))
