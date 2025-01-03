import java.util.*;
import java.util.stream.Collectors;

public class giaoDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng phần tử của a và b
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Đọc dãy a và b
        Set<Integer> A = new HashSet<>();
        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }

        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < m; i++) {
            B.add(sc.nextInt());
        }

        // Tìm tập giao và sắp xếp
        A.retainAll(B);  // Tập giao của A và B
        List<Integer> result = A.stream().sorted().collect(Collectors.toList());

        // In kết quả
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
