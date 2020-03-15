# list alias contains the reference to the sane object
color1 = ["Red", "Green", "Blue"]
color2 = color1
color2.append("Yellow")
print("color2: " , color2)
print("color1: ", color1)
color2.remove("Yellow")


color2 = list(color1)
# make shallow copy
warmtones = [color1, color2]
palette = list(warmtones)
color3 = ["Red", "Green", "Blue"]  # new list refernce
palette.append(color3)
print("warmtones: ", warmtones)
print("palette: ", palette)
# what happens if we modify color2  for palette?
# it will also affect warmtones as palette is shallow copy, bot the list contain the same reference to color2
color2.append("Orange")
print("warmtones: ", warmtones)
print("palette: ", palette)

# solution: deep copy
import copy
color1 = ["Red", "Green", "Blue"]
color2 = list(color1)
warmtones = [color1, color2]
palette = copy.deepcopy(warmtones)
color3 = ["Red", "Green", "Blue"]  # new list refernce
palette.append(color3)
# modify color2 in palette
palette[1].append("Brown") 
print("warmtones: ", warmtones)
print("palette: ", palette)

