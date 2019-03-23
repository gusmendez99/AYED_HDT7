import java.util.ArrayList;
import java.util.List;
//Code extracted from https://www.geeksforgeeks.org/binary-search-tree-data-structure/
/**
 * Class that represents the complete tree of all the possible BinaryTrees, it has operations to alter data of
 * the BinaryTrees and change the order or add a new BinaryTree
 * @param <E> the value of the key of a BinaryTree
 * @author Luis Urbina
 * @since 22/03/2019
 * @version 1.0
 */
public class BinarySearchTree<E extends Comparable<E>>{

    protected BinaryTree<E> root;

    /**
     * Constructs a new root as a BinaryTree object
     */
    public BinarySearchTree() {
        root = new BinaryTree<>();
    }

    /**
     * Add a new binaryTree to the BinarySearchTree
     * @param value generic E (Association) value that will be added as a BinaryTree
     */
    public void add(E value)
    {
        //If there's no root set the new BinaryTree as root
        BinaryTree<E> newNode = new BinaryTree<>(value);
        if (root.isEmpty()) root = newNode;
        else
            //search recursively a node until the value of the newNode is less than the nodeFound to add it as a Left Child

        {
            BinaryTree<E> nodeFound = searchNodeRecursive(root, value);
            nodeFound.setValue(value);
            if (nodeFound.getLeft()== null)
                nodeFound.setLeft(new BinaryTree<E>());
            if (nodeFound.getRight()== null)
                nodeFound.setRight(new BinaryTree<E>());
        }
    }

    /**
     * Search in the BinarySearchTree a node with specific key
     * @param key the key to search the value
     * @return tue if the BinarySearchTree contains the value, false if not
     */
    public boolean contains(E key){
        return get(key) == key;
    }

    /**
     * Get the value of an association with specified key
     * @param key the key of the association to search
     * @return the new BinaryTree node value that matches the specified key
     */
    public E get(E key) {
        if(root.isEmpty()) return null;
        BinaryTree<E> node = searchNodeRecursive(root, key);
        if(node.isEmpty()) return null;
        return node.value();
    }

    /**
     * Create a list with the values of the BinarySearchTree
     * @return the list of values in alphabetical order
     */
    public List<E> inOrder()
    {
        List<E> list = new ArrayList<>();
        inOrderRecursive(root, list);
        return list;
    }

    /**
     * Searches node recursively to see where the position in the BinarySearchTree where a new BinaryTree will be added
     * @param node the root node or the node to compare the new key to
     * @param key the key of the new BinaryTree to add
     * @return the node that will take the value according to the key
     */
    protected BinaryTree searchNodeRecursive(BinaryTree<E> node,E key)
    {
        if(node.isEmpty()) return node;
        else
        {
            int compareResult =  node.value().compareTo(key);
            if (compareResult == 0 ) return node;
            else if (compareResult > 0)
            {
                return searchNodeRecursive(node.getLeft(), key);
            }
            else
            {
                return searchNodeRecursive(node.getRight(), key);
            }
        }
    }

    /**
     * Sets the BinaryTree in order into a tree
     * @param node each node of the BinarySearchTre
     * @param list the list with the values of the BinaryTrees in order
     */
    protected void inOrderRecursive(BinaryTree<E> node, List<E> list)
    {
        if(node.getLeft() != null && !node.getLeft().isEmpty()) inOrderRecursive(node.getLeft(), list);
        list.add(node.value());
        if(node.getRight() != null && !node.getRight().isEmpty()) inOrderRecursive(node.getRight(), list);
    }
}