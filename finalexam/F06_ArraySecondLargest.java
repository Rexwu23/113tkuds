import java.util.*;

public class F06_ArraySecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x > max) {
                second = max;
                max = x;
            } else if (x > second && x < max) {
                second = x;
            }
        }

        System.out.println("SecondMax: " + second);
    }
}



// 時間複雜度：O(n)
//   - 單次遍歷陣列找 max 與 second
// 空間複雜度：O(1)
//   - 只使用 max 與 second 常數變數