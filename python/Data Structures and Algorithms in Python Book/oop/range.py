class Range:
    
    def __init__(self,start, stop=None, step=1):
        """Semantics is similar to range class"""
        if step == 0:
            raise ValueError("Step can't be 0")
        if stop == None: # special case of range(n)
            start, stop = 0, start # should be treated as range(0, n)
    
        # calculate the effective length once
        self.__length = max(0, (stop - start + step - 1) //  step)

        self.__start = start
        self.__step = step

    def __len__(self):
        return self.__length
        
    def __getitem__(self, index):
        """For negative index"""
        if index < 0:
            index += len(self)
        if not 0 <= index < self.__length:
            raise IndexError()
        return self.__start + index * self.__step
        
    def __str__(self):
        return "Range<start = {}, step = {}, length = {}>".format(self.__start, self.__step, self.__length)

if __name__ == "__main__":
    rng = Range(2, 20, 2)
    print(str(rng))
    print(rng[2])

        



    
