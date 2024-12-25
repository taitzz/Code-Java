import java.util.Scanner;

public class mangDoiXung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số bộ test
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            // Nhập số phần tử của dãy
            int n = scanner.nextInt();
            int[] array = new int[n];

            // Nhập các phần tử của dãy
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            // Kiểm tra tính đối xứng
            boolean isPalindrome = true;
            for (int i = 0; i < n / 2; i++) {
                if (array[i] != array[n - i - 1]) {
                    isPalindrome = false;
                    break;
                }
            }

            // In kết quả
            System.out.println(isPalindrome ? "YES" : "NO");
        }

        scanner.close();
    }
}
