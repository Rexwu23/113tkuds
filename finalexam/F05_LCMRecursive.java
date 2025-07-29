import java.util.*;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = GCD(a, b);
        int lcm = a * b / gcd;

        System.out.println("LCM: " + lcm);
    }

    // 使用遞迴計算最大公因數
    static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}



// 時間複雜度：O(log min(a, b))
//   - 輾轉相除法遞迴次數最多為 log 級數
// 空間複雜度：O(log min(a, b))
//   - 遞迴呼叫堆疊空間