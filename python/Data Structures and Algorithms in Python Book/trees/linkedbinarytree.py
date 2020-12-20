from .binarytree import BinaryTree


class LinkedBinaryTree(BinaryTree):
    """ Linked reperesentation of a binary tree structure. """

    class _Node:    # Ligtweight non-public class for storing a node
        __slots__ = '_element', '_parent', '_left', '_right'

        def __init__(self, element, parent=None, left=None, right=None):
            self._element = element
            self._parent = parent
            self._left = left
            self._right = right

    class Position(BinaryTree.Position):
        """ A concerete class representing  the location of a single element. """

        def __init__(self, container, node):
            """ Constructor should not be invoked by user. """
            self._container = container
            self._node = node

        def element(self):
            """ Return the element stored at this position. """
            return self._node._element

        def __eq__(self, other):
            """ Return True if other is a  Position representing the same location."""
            return type(other) is type(self) and other._nodde is self._node

    def _validate(self, p):
        """" Returns associated node if Position p is valid. """
        if not isinstance(p, self.Position):
            raise TypeError('p must be a proper Position type')
        if p._container is not self:
            raise ValueError("p does not belong to this container")
        if p._node._parent is p._node:  # convention for deprecated nodes
            raise ValueError("p is no longer valid")
        return p._node

    def make_postion(self, node):
        """ Return Position instance for given Node (or None if no node). """
        return self.Position(self, node) if node is not None else None

    # --------------------- binary tree constructor ---------------------------------
    def __init__(self):
        """ Create an initial empty binary tree. """
        self._root = None
        self._size = 0

    # ------------------------- public accessors --------------------------------------
    def __len__(self):
        """ Return the number of elements in the tree."""
        return self._size

    def root(self):
        """ Return the root Position of the tree (or None if tree is empty). """
        return self._root

    def parent(self, p):
        """ Return the Position p's parent. """
        node = self._validate(p)
        return self.make_postion(node)

    def left(self, p):
        """ Return the Position p's left child (or None if no left child). """
        node = self._validate(p)
        return self.make_postion(node._left)
    
    def right(self, p):
        """ Return the Position p's right child (or None if no right child). """
        node = self._validate(p)
        return self.make_postion(node._right)
    
    def num_children(self, p):
        """" Return the number of children of Position p."""
        node = self._validate(p)
        count = 0
        if node._left is not None: # left child exists:
            count += 1
        if node._right is not None: # right child exists:
            count += 1
        return count
    
    def add_root(self, e):
        """ Place element e at the root of an empty tree and return new Position.
        
        Raise ValueError if tree is nonEmpty. 
        """

