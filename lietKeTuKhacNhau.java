import java.io.*;
import java.util.*;

public class lietKeTuKhacNhau {
    public static void main(String[] args) throws IOException {
        // Đọc nội dung từ file VANBAN.in
        BufferedReader br = new BufferedReader(new FileReader("VANBAN.in"));
        String line;
        Set<String> wordSet = new TreeSet<>(); // TreeSet để tự động sắp xếp từ điển

        // Đọc từng dòng trong file
        while ((line = br.readLine()) != null) {
            // Chuyển về chữ thường và tách từ
            String[] words = line.toLowerCase().split("\\s+");
            // Thêm từ vào tập hợp
            Collections.addAll(wordSet, words);
        }
        br.close();

        // Ghi hoặc in kết quả
        for (String word : wordSet) {
            System.out.println(word);
        }
    }
}
