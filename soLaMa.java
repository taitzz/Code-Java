import java.util.*;

public class soLaMa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số bộ test
        int t = sc.nextInt();
        sc.nextLine(); // Bỏ dòng trống

        while (t-- > 0) {
            String roman = sc.nextLine();
            System.out.println(romanToDecimal(roman));
        }
    }

    // Hàm chuyển đổi số La Mã sang số thập phân
    public static int romanToDecimal(String roman) {
        // Bảng ánh xạ giá trị
        Map<Character, Integer> value = new HashMap<>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);

        int n = roman.length();
        int total = 0;

        // Duyệt chuỗi từ trái sang phải
        for (int i = 0; i < n; i++) {
            // Nếu ký tự hiện tại nhỏ hơn ký tự tiếp theo
            if (i < n - 1 && value.get(roman.charAt(i)) < value.get(roman.charAt(i + 1))) {
                total -= value.get(roman.charAt(i));
            } else {
                total += value.get(roman.charAt(i));
            }
        }

        return total;
    }
}
