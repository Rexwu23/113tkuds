import java.util.*;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().toLowerCase();

        int[] freq = new int[26]; // a~z 字母統計
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                freq[ch - 'a']++;
            }
        }

        int odd = 0;
        for (int f : freq) {
            if (f % 2 == 1) odd++;
        }

        if (odd <= 1) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }
}



// 時間複雜度：O(Σ) ≈ O(1)
//   - Σ 為字母種類數（26），常數階統計
// 空間複雜度：O(Σ) ≈ O(1)
//   - 使用長度 26 的字母頻率陣列