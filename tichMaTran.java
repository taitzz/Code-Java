import java.util.Scanner;

public class tichMaTran {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số bộ test
        int t = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            // Đọc kích thước ma trận
            int n = sc.nextInt();
            int m = sc.nextInt();

            // Khởi tạo và đọc ma trận A
            int[][] A = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    A[i][j] = sc.nextInt();
                }
            }

            // Tính tích A * Aᵀ
            int[][] result = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        result[i][j] += A[i][k] * A[j][k];
                    }
                }
            }

            // In kết quả
            System.out.println("Test " + test + ":");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
