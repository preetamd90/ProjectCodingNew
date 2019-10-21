package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import trees.commons.Node;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node left1 = new Node(50);
        Node left2 = new Node(60);
        Node right1 = new Node(70);
        Node right2 = new Node(80);
        Node left = new Node(20, left1, right1);
        Node right = new Node(30, left2, right2);
        Node root = new Node(10, left, right);

        printLevelOrder(root);
        System.out.println();
        printLevelOrderWithZigzag(root);
        System.out.println();
        printRightSideView(root);
        System.out.println();
        printLeftSideView(root);
        System.out.println();
        System.out.println("Height of the Tree: " + findHeight(root));
    }

    public static void printLevelOrder(final Node root) {
        if (root == null) {
            return;
        }

        final Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int nodeCount = q.size();
            System.out.println();

            while (nodeCount > 0) {
                final Node node = q.poll(); // Gets the first element and removes it from queue also. peek and remove together.
                nodeCount--;

                if (node != null) {
                    System.out.print(" " + node.data); // Or do whatever we want.

                    // Child nodes.
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
            }
        }
    }

    public static void printLevelOrderWithZigzag(final Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>(); // Using LinkedList. But java also has a Queue class for this.
        q.add(root);

        Stack<Node> s = new Stack<>();
        boolean flag = true;

        while(!q.isEmpty()) {
            int nodeCount = q.size();
            System.out.println();

            while (nodeCount > 0) {
                final Node node = q.poll(); // peek and remove at same time.
                nodeCount--;

                if (node != null) {
                    if (flag) {
                        System.out.print(" " + node.data);
                    } else {
                        s.push(node); // Add elements in that level is being added to stack.
                    }

                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
            }
            while (!s.isEmpty()) {
                System.out.print(" " + s.pop().data);
            }
            s.removeAllElements();
            flag = !flag;
        }
    }

    public static void printRightSideView(final Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int nodeCount = q.size();
            System.out.println();

            while(nodeCount > 0) {
                // Do stuff.
                Node node = q.poll();

                if (nodeCount == 1) {
                    System.out.print(" " + node.data);
                }

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                nodeCount--;
            }
        }
    }

    public static void printLeftSideView(final Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int nodeCount = q.size();
            int maxNodeCount = q.size();
            System.out.println();

            while(nodeCount > 0) {
                // Do stuff.
                Node node = q.poll();

                if (nodeCount == maxNodeCount) {
                    System.out.print(" " + node.data);
                }

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                nodeCount--;
            }
        }
    }

    public static int findHeight(final Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int height = 0;

        while(!q.isEmpty()) {
            int nodeCount = q.size();
            height++;

            while (nodeCount > 0) {
                nodeCount--;
                final Node node = q.peek();
                q.remove();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return height;
    }
}
