public class StudentGradeSystem {


    public static char getGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else return 'D';
    }

    public static void printGradeReport(int[] scores) {
        int countA = 0, countB = 0, countC = 0, countD = 0;
        int max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;
        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            sum += score;

            if (score > max) {
                max = score;
                maxIndex = i;
            }
            if (score < min) {
                min = score;
                minIndex = i;
            }

            char grade = getGrade(score);
            switch (grade) {
                case 'A': countA++; break;
                case 'B': countB++; break;
                case 'C': countC++; break;
                case 'D': countD++; break;
            }
        }

        double average = (double) sum / scores.length;

        int countAboveAverage = 0;
        for (int score : scores) {
            if (score > average) countAboveAverage++;
        }
        double aboveAverageRatio = (double) countAboveAverage / scores.length * 100;

        // 輸出報告
        System.out.println("========= 學生成績報告 =========");
        System.out.println("總人數: " + scores.length);
        System.out.printf("平均分數: %.2f%n", average);
        System.out.printf("最高分: %d（學生 %d）%n", max, maxIndex + 1);
        System.out.printf("最低分: %d（學生 %d）%n", min, minIndex + 1);
        System.out.printf("高於平均分的比例: %.2f%%%n", aboveAverageRatio);
        System.out.println("等級統計：A: " + countA + "  B: " + countB + "  C: " + countC + "  D: " + countD);
        System.out.println("================================");
        System.out.println("學生編號\t分數\t等級");
        System.out.println("--------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("學生 %2d\t\t%3d\t%2c%n", i + 1, scores[i], getGrade(scores[i]));
        }

        System.out.println("================================");
    }

    public static void main(String[] args) {
    
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};

        printGradeReport(scores);
    }
}