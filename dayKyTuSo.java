import java.util.*;

public class dayKyTuSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng bộ test
        int T = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng trống

        while (T-- > 0) {
            String S = sc.nextLine();
            List<Character> letters = new ArrayList<>();
            int digitSum = 0;

            // Phân loại ký tự và số
            for (char ch : S.toCharArray()) {
                if (Character.isDigit(ch)) {
                    digitSum += ch - '0';
                } else {
                    letters.add(ch);
                }
            }

            // Sắp xếp chữ cái
            Collections.sort(letters);

            // Ghép kết quả
            StringBuilder result = new StringBuilder();
            for (char ch : letters) {
                result.append(ch);
            }
            result.append(digitSum);
            // In kết quả
            System.out.println(result.toString());
        }
    }
}
