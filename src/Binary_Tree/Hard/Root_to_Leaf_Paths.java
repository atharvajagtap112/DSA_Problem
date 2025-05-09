package Binary_Tree.Hard;

import java.util.ArrayList;

public class Root_to_Leaf_Paths {
    class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        getPaths(root, ans, temp);

        return ans;
    }

    private static void getPaths(Node node, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp) {
        if (node == null) {
            return; // Base case: null node, no path to add
        }

        temp.add(node.data); // Add the current node to the path

        // Check if the node is a leaf node
        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(temp)); // Add a copy of the current path to the result
        } else {
            // Recursively explore left and right subtrees
            getPaths(node.left, ans, temp);
            getPaths(node.right, ans, temp);
        }

        temp.remove(temp.size() - 1); // Backtrack to explore other paths
    }
}
