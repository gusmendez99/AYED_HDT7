import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @org.junit.Test
    public void add() {
        BinarySearchTree<Association<String, String>> myBinarySearchTree = new BinarySearchTree<>();
        Association<String, String> a = new Association("Carro", "Car");
        myBinarySearchTree.add(a);
        assertNotEquals(myBinarySearchTree.root, null);
    }

    @org.junit.Test
    public void searchNodeRecursive() {
        BinarySearchTree<Association<String, String>> myBinarySearchTree = new BinarySearchTree<>();
        Association<String, String> a = new Association("America", "America");
        myBinarySearchTree.add(a);
        BinaryTree<Association<String , String >> newNode = new BinaryTree<>(a);

        assertNotEquals(myBinarySearchTree.searchNodeRecursive(newNode, new Association<>("Food", "Comida")), newNode);
    }
}