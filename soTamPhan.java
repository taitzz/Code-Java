import java.util.Scanner;

public class soTamPhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng bộ test
        int t = sc.nextInt();

        // Xử lý từng số
        for (int i = 0; i < t; i++) {
            String number = sc.next(); // Đọc số dưới dạng chuỗi
            if (isTernary(number)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // Hàm kiểm tra số tam phân
    private static boolean isTernary(String number) {
        for (char ch : number.toCharArray()) {
            if (ch != '0' && ch != '1' && ch != '2') {
                return false;
            }
        }
        return true;
    }
}
