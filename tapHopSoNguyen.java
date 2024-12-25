import java.util.*;

public class tapHopSoNguyen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Đọc số lượng phần tử của a[] và b[]
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Khai báo và đọc dãy a[] và b[]
        Set<Integer> A = new TreeSet<>();
        Set<Integer> B = new TreeSet<>();
        
        // Đọc dãy a[] và đưa các phần tử vào tập A (sử dụng TreeSet để loại bỏ phần tử trùng)
        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }
        
        // Đọc dãy b[] và đưa các phần tử vào tập B (sử dụng TreeSet để loại bỏ phần tử trùng)
        for (int i = 0; i < m; i++) {
            B.add(sc.nextInt());
        }
        
        // Tính tập giao của A và B (A ∩ B)
        Set<Integer> intersection = new TreeSet<>(A);
        intersection.retainAll(B);
        
        // Tính tập hiệu A - B
        Set<Integer> differenceAB = new TreeSet<>(A);
        differenceAB.removeAll(B);
        
        // Tính tập hiệu B - A
        Set<Integer> differenceBA = new TreeSet<>(B);
        differenceBA.removeAll(A);
        
        // In kết quả mà không có dấu ngoặc
        printSet(intersection);
        printSet(differenceAB);
        printSet(differenceBA);
    }
    
    // Hàm in tập hợp mà không có dấu ngoặc
    private static void printSet(Set<Integer> set) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : set) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
