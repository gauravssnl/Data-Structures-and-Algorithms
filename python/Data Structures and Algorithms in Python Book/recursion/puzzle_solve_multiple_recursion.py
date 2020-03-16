""" Summation puzzle
Example:
pot + pan = bib
dog + cat = pig
boy+ girl = baby
"""
def puzzle_solve(k, S, U, solutionSeq):      # we have also passed puzzles solution samples to verify the configuarion
    """ Input: an integer k : length of the subset made by combination of letters, 
    S: Sequence of unique letters  , U: Universal Set of unique letters Example: {a, b, c} """
    for element in U:
        # add element to the end of S 
        # S.append(element)  # S is list
        S += element # S is string
        # remove element from U
        U.remove(element)
        if k == 1:
            # test whether string S is a configuartion that solves the puzzle
            # sequnce_string = "".join(S) # list
            sequnce_string = S
            if sequnce_string in solutionSeq: # S solves the puzzle
                print("Solution Found: ", S)
                return "Solution Found: ", S
            else: # No solution found
                print("No solution found. Configuration = {}".format(sequnce_string))
        else:
            puzzle_solve(k-1, S, U, solutionSeq) # recursive call to obtain configuration of desired length
        #the puzzle was not solved with  element 'element ' which was added to S
        # so we remove it from S and add it back to U
        # S.remove(element) # S is list
        S = S[:-1]
        U.append(element) 


if __name__ == "__main__":
    solutionSeq = ['bca']
    k = 3
    # S = [] # list
    S = ""
    U = ['a', 'b', 'c']
    puzzle_solve(3, S, U, solutionSeq) 

    solutionSeq = ['pot']
    k = 3
    # S = [] # list
    S = ""
    U = ['p', 'r', 'o', 't' ]
    print(U)
    puzzle_solve(3, S, U, solutionSeq) 
    

        



