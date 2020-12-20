from .tree import Tree

class BinaryTree(Tree):
    """ Abstract class representing a binary tree structure. """

    # ---------- additional abstract methods --------------------
    def left(self, p):
        """ Return a Position representing p's left child.

        Return None if p does not have a left child.
        """
        raise NotImplementedError('must be implemented by subclass')

    def right(self, p):
        """ Return a Position representing p's right child.

        Return None if p does not have a right child.
        """
        raise NotImplementedError('must be implemented by subclass') 

    # ----------- concrete method implemented in this class -----------
    def siblings(self, p):
        """ Return a Position representing p's siblings (or None if no siblings). """
        parent = self.parent(p)
        if parent is None:
            return None
        else:
            if p == self.left(parent):  # Position p is to the left of parent
                return self.right(parent)   # possibly None
            else:
                return self.right(parent)   # possibly None
            
    def children(self, p):
        """ Generate an iteration of Positions representing p's children. """
        if self.left(p) is not None:
            yield self.left(p)
        if self.right(p) is not None:
            yield self.right(p)

print(Tree)

