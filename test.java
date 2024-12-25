import java.util.*;

public class test {
    // Hàm sinh các số lộc phát với độ dài không quá N
    public static List<String> generateLuckyNumbers(int N) {
        List<String> luckyNumbers = new ArrayList<>();
        
        // Sinh các số lộc phát từ độ dài 1 đến N
        for (int length = 1; length <= N; length++) {
            generateCombinations("", length, luckyNumbers);
        }
        
        // Sắp xếp theo thứ tự giảm dần theo giá trị số học
        Collections.sort(luckyNumbers, (a, b) -> Long.compare(Long.parseLong(b), Long.parseLong(a)));  // So sánh theo giá trị số học
        
        return luckyNumbers;
    }
    
    // Hàm đệ quy sinh tất cả các chuỗi lộc phát với độ dài length
    public static void generateCombinations(String current, int length, List<String> luckyNumbers) {
        if (current.length() == length) {
            luckyNumbers.add(current);
            return;
        }
        
        // Sinh các chuỗi bằng cách thêm 6 và 8
        generateCombinations(current + "6", length, luckyNumbers);
        generateCombinations(current + "8", length, luckyNumbers);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // Số lượng bộ test
        while (T-- > 0) {
            int N = sc.nextInt();  // Độ dài tối đa của số lộc phát
            
            // Sinh các số lộc phát
            List<String> luckyNumbers = generateLuckyNumbers(N);
            
            // In kết quả
            System.out.println(luckyNumbers.size());  // In số lượng số lộc phát
            System.out.println(String.join(" ", luckyNumbers));  // In các số lộc phát theo thứ tự giảm dần
        }
        sc.close();
    }
}
