import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 輸入前序 + -1 表 null
        String[] tokens = sc.nextLine().split(" ");
        int L = sc.nextInt(), R = sc.nextInt();
        TreeNode root = buildTree(tokens);
        int sum = rangeSum(root, L, R);
        System.out.println("Sum: " + sum);
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

    static int rangeSum(TreeNode node, int L, int R) {
        if (node == null) return 0;
        if (node.val < L) return rangeSum(node.right, L, R);
        if (node.val > R) return rangeSum(node.left, L, R);
        return node.val + rangeSum(node.left, L, R) + rangeSum(node.right, L, R);
    }
}


// 時間：O(n) 最壞；O(log n) 最佳
// 空間：O(h)