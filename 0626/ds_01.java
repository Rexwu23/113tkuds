import java.util.*;
 
    public class ds_01{
    

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("a=");
            int a = scanner.nextInt();
            System.out.print("b=");
            int b = scanner.nextInt();
            int num= a + b;
            System.out.println("兩數相加為:" +num);
            scanner.close();
    }
}