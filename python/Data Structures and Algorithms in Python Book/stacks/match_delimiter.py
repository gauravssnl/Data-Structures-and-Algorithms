from arraystack import ArrayStack

def is_matched(expr):
    """Return True if  all delimiters properly match (or closed); False otherwise"""
    left_delimiters = "({["
    right_delimiter = ")}]"
    S = ArrayStack()
    for c in expr:
        if c in left_delimiters:
            S.push(c)
        elif c in right_delimiter:
            if S.is_empty():
                return False
            if right_delimiter.index(c) != left_delimiters.index(S.pop()):
                return False
    return S.is_empty()

if __name__ == "__main__":
    expr = "[(5+x)-(y+z)]"
    print(is_matched(expr))

    expr = "[(5+x)-y+z)]"
    print(is_matched(expr))