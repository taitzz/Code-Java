import java.util.*;

public class bienSoDep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng bộ test
        int t = sc.nextInt();
        sc.nextLine(); // Bỏ dòng trống

        while (t-- > 0) {
            String plate = sc.nextLine().trim();
            System.out.println(isBeautiful(plate));
        }

        sc.close();
    }

    // Hàm kiểm tra biển số đẹp
    public static String isBeautiful(String plate) {
        // Tách 5 chữ số cuối
        String[] parts = plate.split("-");
        String lastFive = parts[1].replace(".", "");

        // Kiểm tra điều kiện 1: Tăng chặt
        if (isStrictlyIncreasing(lastFive)) {
            return "YES";
        }

        // Kiểm tra điều kiện 2: Đồng nhất
        if (isAllSame(lastFive)) {
            return "YES";
        }

        // Kiểm tra điều kiện 3: Ba và hai giống nhau
        if (isThreeAndTwoSame(lastFive)) {
            return "YES";
        }

        // Kiểm tra điều kiện 4: Lộc phát
        if (isLucky(lastFive)) {
            return "YES";
        }

        // Nếu không thỏa mãn
        return "NO";
    }

    // Kiểm tra dãy tăng chặt
    public static boolean isStrictlyIncreasing(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) >= s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // Kiểm tra tất cả ký tự giống nhau
    public static boolean isAllSame(String s) {
        char first = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != first) {
                return false;
            }
        }
        return true;
    }

    // Kiểm tra ba chữ số đầu và hai chữ số cuối giống nhau
    public static boolean isThreeAndTwoSame(String s) {
        return s.substring(0, 3).equals(repeatChar(s.charAt(0), 3)) &&
               s.substring(3).equals(repeatChar(s.charAt(3), 2));
    }

    // Hàm lặp lại ký tự 'c' 'n' lần
    public static String repeatChar(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    // Kiểm tra chỉ gồm số 6 và 8
    public static boolean isLucky(String s) {
        for (char c : s.toCharArray()) {
            if (c != '6' && c != '8') {
                return false;
            }
        }
        return true;
    }
}
