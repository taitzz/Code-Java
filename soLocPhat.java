import java.util.*;

public class soLocPhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            Queue<String> queue = new LinkedList<>();
            Stack<String> stack = new Stack<>();

            queue.add("6");
            queue.add("8");

            int count = 0; // Biến đếm số lượng

            while (queue.peek().length() <= n) {
                String front = queue.poll();
                stack.push(front);
                count++;
                queue.add(front + "6");
                queue.add(front + "8");
            }

            System.out.println(count);

            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }

            System.out.println();
        }
        scanner.close();
    }
}
