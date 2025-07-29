import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int n = Integer.parseInt(sc.next());
            if (n < 1 || n > 131) {
                System.out.println("Invalid");
                return;
            }

            String[] stops = new String[n];
            for (int i = 0; i < n; i++) {
                stops[i] = sc.next();
            }

            String start = sc.next();
            String end = sc.next();

            int idx1 = -1, idx2 = -1;
            for (int i = 0; i < n; i++) {
                if (stops[i].equals(start)) idx1 = i;
                if (stops[i].equals(end)) idx2 = i;
            }

            if (idx1 == -1 || idx2 == -1) {
                System.out.println("Invalid");
            } else {
                int result = Math.abs(idx1 - idx2) + 1;
                System.out.println(result);
            }

        } catch (Exception e) {
            System.out.println("Invalid");
        }
    }
}



// 時間複雜度：O(n)
//   - 單次掃描 n 個站點找起站與終站索引值。
// 空間複雜度：O(n)
//   - 儲存 n 個站代碼於 stops 陣列。
