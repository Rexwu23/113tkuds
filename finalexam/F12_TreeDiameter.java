import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int diameter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        TreeNode root = buildTree(tokens);
        height(root);
        System.out.println("Diameter: " + diameter);
    }

    static TreeNode buildTree(String[] tokens) {
        Queue<String> q = new LinkedList<>(Arrays.asList(tokens));
        return build(q);
    }

    static TreeNode build(Queue<String> q) {
        if (q.isEmpty()) return null;
        String val = q.poll();
        if (val.equals("-1")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = build(q);
        node.right = build(q);
        return node;
    }

    static int height(TreeNode node) {
        if (node == null) return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        diameter = Math.max(diameter, lh + rh);
        return Math.max(lh, rh) + 1;
    }
}



// 時間：O(n) 單次 DFS
// 空間：O(h) 遞迴堆疊