public class ds_05 {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 1, 4, 9, 2, 5, 8, 6, 10};
        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }

        System.out.println("總和為：" + sum);
    }
}