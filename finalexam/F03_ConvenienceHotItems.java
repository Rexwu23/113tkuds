import java.util.*;

public class F03_ConvenienceHotItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[] names = new String[n];
        int[] qtys = new int[n];

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            names[i] = parts[0];
            qtys[i] = Integer.parseInt(parts[1]);
        }

        // 插入排序（由大到小）
        for (int i = 1; i < n; i++) {
            String keyName = names[i];
            int keyQty = qtys[i];
            int j = i - 1;
            while (j >= 0 && qtys[j] < keyQty) {
                names[j + 1] = names[j];
                qtys[j + 1] = qtys[j];
                j--;
            }
            names[j + 1] = keyName;
            qtys[j + 1] = keyQty;
        }

        // 輸出前 10 名
        int outputCount = Math.min(n, 10);
        for (int i = 0; i < outputCount; i++) {
            System.out.println(names[i] + " " + qtys[i]);
        }
    }
}


// 時間複雜度：O(n^2)
//   - 使用插入排序對 n 筆資料進行排序
// 空間複雜度：O(n)
//   - 儲存 n 筆商品名稱與數量