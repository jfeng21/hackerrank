/*
A binary tree is a multi-node data structure where each node has, at most, two child nodes and one stored value. it may either be:
1. An empty tree, where root = null, or
2. A tree with a non-null root node that contains a value and two sub-trees, left and right, which are also binary trees.
A BST if all the non-null nodes exhibit two properties:
1. Each node's left sub-tree contains only values that are lower than its own stored value.
2. Each node's right sub-tree contains only values that are higher than its own stored value.
Pre-order

*/


import java.util.ArrayList;
import java.util.Scanner;


public class ValidBST {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter size of test(1 to 10):");

        int size = Integer.parseInt(sc.nextLine());
        if (size < 0 || size > 10) {
            System.out.println("Please enter test number between 1 and 10");
            return;
        }
        ArrayList output = new ArrayList<>();

        while (size > 0) {
            int len = Integer.parseInt(sc.nextLine());
            int[] preOrder = new int[len];

            String[] number = sc.nextLine().split("");
            ValidBST bst = new ValidBST();

            for (int j = 0; j < len; j++) {
                preOrder[j] = Integer.parseInt(number[j]);
                bst.insert(preOrder[j]);
                output.add(preOrder[j]);
                size--;
            }
            if (output.toString().equalsIgnoreCase(bst.printPre())) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }

    TreeNode root;
    ArrayList list = new ArrayList();

    ValidBST insert(int value) {
        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
            return this;
        }
        insertRec(root, node);
        return this;
    }

    private void insertRec(TreeNode root, TreeNode node) {
        if (root.val > node.val) {
            if (root.left == null) {
                root.left = node;
                return;
            } else {
                if (root.right == null) {
                    root.right = node;
                    return;
                } else {
                    insertRec(root, node);
                }
            }
        }
    }

    public String printPre() {
        printRec(root);
        return list.toString();
    }

    private void printRec(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        printRec(root.left);
        printRec(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        Result r = validate(root);
        return r.is_bst;
    }

    private Result validate(TreeNode root) {
        if (root == null) {
            return new Result(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Result left = validate(root.left);
        Result right = validate(root.right);

        if (!left.is_bst || !right.is_bst) {
            return new Result(false, 0, 0);
        }

        if (root.left != null && left.maxVal > root.val || root.right != null && right.minVal <= root.val) {
            return new Result(false, 0, 0);
        }
        return new Result(true, Math.max(root.val, right.maxVal), Math.min(root.val, left.minVal));

    }

}

class Result {

    boolean is_bst;
    int maxVal, minVal;

    Result(boolean is_bst, int maxVal, int minVal) {
        this.is_bst = is_bst;
        this.maxVal = maxVal;
        this.minVal = minVal;
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
