import java.util.*;

public class dauTuChungKhoan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc số bộ test
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            // Đọc số ngày
            int n = scanner.nextInt();
            int[] prices = new int[n];

            // Đọc giá chứng khoán
            for (int i = 0; i < n; i++) {
                prices[i] = scanner.nextInt();
            }

            // Tính nhịp chứng khoán
            int[] spans = calculateSpans(prices, n);

            // In kết quả
            for (int span : spans) {
                System.out.print(span + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    public static int[] calculateSpans(int[] prices, int n) {
        int[] spans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop các chỉ số mà giá nhỏ hơn hoặc bằng giá ngày i
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // Nếu stack rỗng, tất cả các ngày trước đều nhỏ hơn hoặc bằng giá ngày i
            if (stack.isEmpty()) {
                spans[i] = i + 1;
            } else {
                spans[i] = i - stack.peek();
            }

            // Đẩy chỉ số ngày hiện tại vào stack
            stack.push(i);
        }

        return spans;
    }
}
