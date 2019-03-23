import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>>{

    protected BinaryTree<E> root;
    int size;


    public BinarySearchTree()
    {
        root = new BinaryTree<>();
    }

    public boolean isEmpty()
    {
        return root.isEmpty();
    }


    public void clear()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void add(E value)
    {
        BinaryTree<E> newNode = new BinaryTree<>(value);
        if (root.isEmpty()) root = newNode;
        else
        {
            BinaryTree<E> nodeFound = searchNodeRecursive(root, value);
            nodeFound.setValue(value);
            if (nodeFound.getLeft()== null)
                nodeFound.setLeft(new BinaryTree<E>());
            if (nodeFound.getRight()== null)
                nodeFound.setRight(new BinaryTree<E>());
        }
    }


    public boolean contains(E key)
    {
        return get(key) == key;
    }


    public E get(E key)
    {
        if(root.isEmpty()) return null;
        BinaryTree<E> node = searchNodeRecursive(root, key);
        if(node.isEmpty()) return null;
        return node.value();
    }


    public E remove(E value)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public List<E> inOrder()
    {
        List<E> list = new ArrayList<>();
        inOrderRecursive(root, list);
        return list;
    }


    protected BinaryTree searchNodeRecursive(BinaryTree<E> node,E key)
    {
        if(node.isEmpty()) return node;
        else
        {
            int steC =  node.value().compareTo(key);
            if (steC == 0 )return node;
            else if (steC > 0)
            {
                return searchNodeRecursive(node.getLeft(), key);
            }
            else
            {
                return searchNodeRecursive(node.getRight(), key);
            }
        }
    }


    protected void inOrderRecursive(BinaryTree<E> node, List<E> list)
    {
        if(node.getLeft() != null && !node.getLeft().isEmpty()) inOrderRecursive(node.getLeft(), list);
        list.add(node.value());
        if(node.getRight() != null && !node.getRight().isEmpty()) inOrderRecursive(node.getRight(), list);
    }
}