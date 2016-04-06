
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class IsTree {

    TreeNodes root;

    void add(String item) {
        if (root == null) {
            root = new TreeNodes(item);
        } else {
            add(root, item);
        }
    }

    void add(TreeNodes node, String item) {
        if (item.compareTo(node.val) < 0) {
            if (node.left == null) {
                node.left = new TreeNodes(item);
            } else {
                add(node.left, item);
            }
        } else if (item.compareTo(node.val) > 0) {
            if (node.right == null) {
                node.right = new TreeNodes(item);
            } else {
                add(node.right, item);
            }
        }
    }

    String printPre(TreeNodes root) {

        ArrayList list = new ArrayList<>();
        String res;
        if (root == null) {
            return null;
        }
        list.add(root.val);
        //  System.out.println("("+root.val);
        printPre(root.left);
        printPre(root.right);
        return list.toString();
    }

    String SExpression(String nodes) {
        ArrayList children = new ArrayList<>();
        String[] tokens = nodes.split(" ");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < tokens.length;) {
            if (!map.containsKey(tokens[i])) {
                map.put(tokens[i].charAt(1),tokens[i].charAt(3));
                add(String.valueOf(tokens[i].charAt(1)));
                add(String.valueOf(tokens[i].charAt(3)));
            } else {
                TreeNodes root = new TreeNodes(tokens[i]);
                children.add(tokens[i]);
                if (children.size() > 1) {
                    System.out.println("E1");
                }
                add(tokens[i]);
                if (map.containsValue(tokens[i])) {
                    System.out.println("E2");
                }
            }
        }

        String res = printPre(root);
        return res;

    }

}

class TreeNodes {

    String val;
    TreeNodes left;
    TreeNodes right;

    TreeNodes(String x) {
        val = x;
    }
}
