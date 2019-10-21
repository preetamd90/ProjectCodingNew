package trees.commons;

public class Node {
    public int data;
    public Node left, right;

    public Node(final int data)
    {
        this.data = data;
        left = right = null;
    }

    public Node(final int data, final Node left, final Node right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
