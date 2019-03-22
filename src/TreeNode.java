import java.util.HashMap;

public class TreeNode {
    private Association data;
    private TreeNode left;
    private TreeNode right;

    TreeNode(Association data) {
        this.data=data;
    }

    public Association getData() {
        return data;
    }

    public void setData(Association data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}