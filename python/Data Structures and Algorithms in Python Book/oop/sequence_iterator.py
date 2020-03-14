class SequenceIterator:
    
    def __init__(self, sequence):
        self.__sequence = sequence
        self.__current_index = -1  #will increment to 0 on first call to next()
    
    def next(self): # __next__ was not working 
        self.__current_index += 1
        if self.__current_index < len(self.__sequence):
            return self.__sequence[self.__current_index]
        else:
            raise StopIteration()
    
    def __iter__(self):
        """By convention, an iterator must return itself as an iterator"""
        return self

    def __str__(self):
        return 'Sequnce: {}, Current Index: {}, Length: {}'.format(
            self.__sequence, 
            self.__current_index, 
            len(self.__sequence)) 
    

if __name__ == "__main__":
    n = 30
    sequence_iterator = SequenceIterator(range(n))
    print(sequence_iterator)
    print(next(sequence_iterator))
    print(next(sequence_iterator))

    for num in sequence_iterator:
        print("Number in sequnce:", num)

