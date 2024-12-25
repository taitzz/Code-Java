import java.io.*;
import java.util.*;

public class tongChuSo {
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATA.in"))) {
            // Đọc đối tượng ArrayList từ file nhị phân
            @SuppressWarnings("unchecked")
            ArrayList<String> list = (ArrayList<String>) in.readObject();
            System.out.println("Dữ liệu đọc từ file: ");
            
            // Xử lý chuỗi và tính tổng chữ số
            for (String s : list) {
                StringBuilder number = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (Character.isDigit(c)) {
                        number.append(c);
                    }
                }

                // Kiểm tra và loại bỏ số 0 đầu tiên nếu có
                if (number.length() > 0) {
                    String numStr = number.toString().replaceFirst("^0+", "");
                    int num = Integer.parseInt(numStr);
                    int sumOfDigits = sumDigits(num);
                    System.out.println(num + " " + sumOfDigits);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Hàm tính tổng chữ số
    private static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
