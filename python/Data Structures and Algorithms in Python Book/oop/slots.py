# usage of __slots__  to tell Python not to use a dict, and only allocate space for a fixed set of attributes. 
# attributes can't be added at runtime

class A:
    
    def __init__(self):
        self.x, self.y = 1, 2
    

class B:
    __slots__ = 'x', 'y'
    def __init__(self):
        self.x , self.y = 5, 6

if __name__ == "__main__":
    a = A()
    print("class A Info:")
    print(dir(A))
    print("instance 'a' Info:")
    print(dir(a))
    print(a.__dict__)
    # print(a.__slot__) # this will throw error if you uncomment this line

    b = B()
    print("class B Info:")
    print(dir(B))
    print("instance 'a' Info:")
    print(dir(b))
    print(b.__slots__)
    # print(b.__dict__) # this will throw error if you uncomment this line
        

