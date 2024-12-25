import java.io.*;

public class tinhTong {
    public static void main(String[] args) {
        // Đường dẫn đến file DATA.in
        String fileName = "DATA.in";
        long sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Tách các từ trong dòng sử dụng regex
                String[] parts = line.split("\\s+");
                for (String part : parts) {
                    try {
                        // Kiểm tra nếu là số kiểu int thì cộng vào tổng
                        int number = Integer.parseInt(part);
                        sum += number;
                    } catch (NumberFormatException e) {
                        // Bỏ qua nếu không phải số kiểu int
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // In ra tổng
        System.out.println(sum);
    }
}
