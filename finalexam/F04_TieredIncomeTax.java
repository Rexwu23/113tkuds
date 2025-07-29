import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] incomes = new int[n];
        int[] taxes = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            incomes[i] = Integer.parseInt(sc.nextLine());
            taxes[i] = calculateTax(incomes[i]);
            total += taxes[i];
            System.out.println("Tax: $" + taxes[i]);
        }

        int avg = total / n;
        System.out.println("Average: $" + avg);
    }

    static int calculateTax(int income) {
        int tax = 0;
        int[] bounds = {0, 540000, 1210000, 2420000, 4530000};
        int[] rates = {5, 12, 20, 30, 40};

        for (int i = bounds.length - 1; i >= 0; i--) {
            if (income > bounds[i]) {
                tax += (income - bounds[i]) * rates[i] / 100;
                income = bounds[i];
            }
        }

        return tax;
    }
}



// 時間複雜度：O(n)
//   - 每筆收入跑一次固定級距計算
// 空間複雜度：O(n)
//   - 儲存每筆稅額
