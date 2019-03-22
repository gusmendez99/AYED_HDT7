public class Node {
    private Association data;
    private Node left, right;

    Node(Association data) {
        this.data = data;
        this.left = this.right = null;
    }


    public Association getData() {
        return data;
    }

    public void setData(Association data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
