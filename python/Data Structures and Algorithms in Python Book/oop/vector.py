class Vector:
    
    def __init__(self, d):
        self._coords = [0] * d

    def __len__(self) :
        return len(self._coords)
    
    def __getitem__(self, indx):
        if indx < 0 or indx > len(self._coords):
            raise IndexError("Invalid Index")
        return self._coords[indx]
    
    def __setitem__(self, indx, val):
        if indx < 0 or indx > len(self._coords):
            raise IndexError("Invalid Index")
        else:
            self._coords[indx] = val
    
    def __add__(self, other):
        if len(self._coords) != len(other):
            raise ValueError("Dimensions should be same for the two vectors")
        result = Vector(len(self))
        for i in range(len(self)):
            result[i] = self._coords[i] + other._coords[i]
        return result
    
    def __eq__(self, other):
        return self._coords == other._coords
    
    def __ne__(self, other):
        return not self == other
    
    def __str__(self):
        return "< {} >".format(str(self._coords)[1:-1])

if __name__ == "__main__":
    vec1 = Vector(3)
    vec1[0] = 1
    vec1[1] = 2
    vec1[2] = 3
    print("Vector vec1: {}".format(vec1))

    vec2 = Vector(3)
    vec2[0] = 1
    vec2[1] = 2
    vec2[2] = 3
    print("Vector vec2: {}".format(vec2))

    print("vec1 == vec2:", vec1 == vec2)
    print("vec1 + vec2:", str(vec1 + vec2))

    vec3 = Vector(3)
    vec3[0] = 1
    vec3[1] = 2
    vec3[2] = 4
    print("Vector vec3: {}".format(vec3))

    print("vec1 != vec3:", vec1 != vec3)
