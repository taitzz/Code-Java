import java.util.*;

public class daoTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Đọc số lượng bộ test
        int T = sc.nextInt();
        sc.nextLine();  // Đọc ký tự newline sau số lượng test
        
        // Xử lý từng bộ test
        for (int i = 0; i < T; i++) {
            // Đọc xâu ký tự S
            String S = sc.nextLine();
            
            // Tách xâu thành các từ
            String[] words = S.split(" ");
            
            // Đảo ngược thứ tự các từ
            StringBuilder result = new StringBuilder();
            for (int j = words.length - 1; j >= 0; j--) {
                result.append(words[j]).append(" ");
            }
            
            // In kết quả sau khi đảo ngược, loại bỏ khoảng trắng thừa ở cuối
            System.out.println(result.toString().trim());
        }
    }
}
