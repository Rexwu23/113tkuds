import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        int target = sc.nextInt();
        TreeNode root = buildTree(tokens);
        System.out.println("Closest: " + closestValue(root, target));
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

    static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode curr = root;
        while (curr != null) {
            if (Math.abs(curr.val - target) < Math.abs(closest - target) ||
                (Math.abs(curr.val - target) == Math.abs(closest - target) && curr.val < closest)) {
                closest = curr.val;
            }
            if (target < curr.val) curr = curr.left;
            else if (target > curr.val) curr = curr.right;
            else break;
        }
        return closest;
    }
}


// 時間：O(h) 最多走到葉節點
// 空間：O(1)
