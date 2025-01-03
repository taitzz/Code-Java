import java.util.*;

// Lớp Invoice lưu thông tin hóa đơn
class Invoice {
    private String code;         // Mã mặt hàng
    private String name;         // Tên mặt hàng
    private int quantity;        // Số lượng mua
    private long unitPrice;      // Đơn giá
    private long discount;       // Tiền chiết khấu

    public Invoice(String code, String name, int quantity, long unitPrice, long discount) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    // Phương thức tính tổng tiền
    public long getTotalAmount() {
        return (unitPrice * quantity) - discount;
    }

    // Override phương thức toString để hiển thị thông tin hóa đơn
    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", 
            code, name, quantity, unitPrice, discount, getTotalAmount());
    }
}

public class tinhTien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc số lượng hóa đơn
        int n = Integer.parseInt(sc.nextLine());
        List<Invoice> invoices = new ArrayList<>();

        // Nhập thông tin cho từng hóa đơn
        for (int i = 0; i < n; i++) {
            String code = sc.nextLine();           // Mã mặt hàng
            String name = sc.nextLine();           // Tên mặt hàng
            int quantity = Integer.parseInt(sc.nextLine()); // Số lượng
            long unitPrice = Long.parseLong(sc.nextLine()); // Đơn giá
            long discount = Long.parseLong(sc.nextLine());  // Tiền chiết khấu

            // Thêm hóa đơn vào danh sách
            invoices.add(new Invoice(code, name, quantity, unitPrice, discount));
        }

        // Sắp xếp danh sách hóa đơn theo tổng tiền giảm dần
        invoices.sort((a, b) -> Long.compare(b.getTotalAmount(), a.getTotalAmount()));

        // In danh sách hóa đơn đã sắp xếp
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }

        sc.close(); // Đóng Scanner
    }
}
