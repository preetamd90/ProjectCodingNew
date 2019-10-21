package trees.commons;

import java.util.LinkedList;
import java.util.Queue;

import trees.commons.Node;

public class TreeUtils {

    // Driver program to test above functions
    public static void main(String[] args)
    {
        // Let us create binary tree shown in above diagram
	/*			 1
				/	 \
				2	 3
				/ \	 \
			4	 5	 6
		*/

        LevelOrder levelOrder = new LevelOrder();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        levelOrder.printLevelOrder(root);

    }

    /* An Iterative Java program to print levels line by line */
    public static class LevelOrder
    {
        // Iterative method to do level order traversal line by line
        void printLevelOrder(Node root)
        {
            // Base Case
            if(root == null)
                return;

            // Create an empty queue for level order tarversal
            Queue<Node> q =new LinkedList<Node>();

            // Enqueue Root and initialize height
            q.add(root);

            while(q.size() > 0)
            {
                // nodeCount (queue size) indicates number of nodes
                // at current level.
                int nodeCount = q.size();

                // Dequeue all nodes of current level and Enqueue all
                // nodes of next level
                while(nodeCount > 0)
                {
                    Node node = q.poll();
                    // Node node = q.peek(); [peek does not remove, while poll looks and removes]
                    System.out.print(node.data + " ");
                    // q.remove();
                    if(node.left != null)
                        q.add(node.left);
                    if(node.right != null)
                        q.add(node.right);
                    nodeCount--;
                }
                System.out.println();
            }
        }

    }

}



