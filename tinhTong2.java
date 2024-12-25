import java.util.Scanner;

public class tinhTong2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số bộ test
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            // Nhập giá trị N
            long N = scanner.nextLong();

            // Tính tổng S = 1 + 2 + ... + N
            long sum = N * (N + 1) / 2;

            // In kết quả
            System.out.println(sum);
        }

        scanner.close();
    }
}
