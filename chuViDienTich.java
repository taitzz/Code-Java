import java.util.Scanner;

public class chuViDienTich {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập vào hai số nguyên l, w
        int l = scanner.nextInt();
        int w = scanner.nextInt();

        // Kiểm tra dữ liệu hợp lệ
        if (l <= 0 || w <= 0) {
            System.out.println(0);
        } else {
            // Tính chu vi và diện tích
            int perimeter = 2 * (l + w);
            int area = l * w;
            System.out.println(perimeter + " " + area);
        }

        scanner.close();
    }
}
