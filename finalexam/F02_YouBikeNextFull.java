import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];

        // 將 HH:mm 轉成分鐘數存入陣列
        for (int i = 0; i < n; i++) {
            times[i] = toMinutes(sc.nextLine());
        }

        int query = toMinutes(sc.nextLine());

        // 二分搜尋找 >= query 的第一個時間
        int idx = Arrays.binarySearch(times, query);
        if (idx < 0) idx = -(idx + 1); // 沒找到，轉為插入點

        if (idx >= n) {
            System.out.println("No bike");
        } else {
            System.out.println(toTimeStr(times[idx]));
        }
    }

    // 時間字串轉分鐘
    static int toMinutes(String t) {
        String[] parts = t.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // 分鐘轉回 HH:mm 格式
    static String toTimeStr(int min) {
        int h = min / 60;
        int m = min % 60;
        return String.format("%02d:%02d", h, m);
    }
}



// 時間複雜度：O(log n)
//   - 使用 Arrays.binarySearch 進行二分搜尋
// 空間複雜度：O(n)
//   - 儲存 n 筆時間資料