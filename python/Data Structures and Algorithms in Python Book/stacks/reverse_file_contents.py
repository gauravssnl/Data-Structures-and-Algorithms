from arraystack import ArrayStack

def reverse_file(filename):
    """Overwrite a given file with contents line-by-line in reversed order"""
    S = ArrayStack()
    original = open(filename)

    for line in original:
        S.push(line.rstrip('\n'))           # we will re-insert newlines while writing
    original.close()

    # now write the contents in LIFO order
    output = open(filename, 'w')
    while not S.is_empty():
        output.write(S.pop() + '\n')        # add trailing new line
    output.close()

if __name__ == "__main__":
    filename = "hello.txt"
    reverse_file(filename)