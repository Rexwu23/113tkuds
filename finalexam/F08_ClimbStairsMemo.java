import java.util.*;

public class F08_ClimbStairsMemo {
    static int[] memo = new int[41];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Ways: " + climb(n));
    }

    static int climb(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (memo[n] > 0) return memo[n];
        memo[n] = climb(n - 1) + climb(n - 2) + climb(n - 3);
        return memo[n];
    }
}



// 時間複雜度：O(n)
//   - 每個 n 僅計算一次，利用 memo 儲存子問題結果
// 空間複雜度：O(n)
//   - 使用長度為 41 的記憶化陣列