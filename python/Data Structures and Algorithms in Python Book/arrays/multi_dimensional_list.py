def generate_multi_dimensional_list(row, colummn):
    return [[0] * colummn for j in range(row)]

if __name__ == "__main__":
    # generate 2 X 3 matrix
    row = 2
    col = 3
    print(generate_multi_dimensional_list(row, col))