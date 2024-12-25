import java.util.Scanner;

public class tongGiaiThua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập giá trị n
        int n = scanner.nextInt();

        long totalSum = 0;
        long factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i; // Tính giai thừa 1.2.3...i
            totalSum += factorial; // Cộng vào tổng
        }

        // In kết quả
        System.out.println(totalSum);

        scanner.close();
    }
}
