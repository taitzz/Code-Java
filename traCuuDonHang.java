import java.util.*;

class Order {
    private String name;
    private String code;
    private int price;
    private int quantity;

    public Order(String name, String code, int price, int quantity){
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public String getCode(){
        return code;
    }

    public String getOrderNumber(){
        return code.substring(1, 4); //Lấy 3 chữ số trong mã đơn hàng
    }

    public int getDiscount(){
        int orderType = Integer.parseInt(code.substring(4));
        double discountRate = (orderType == 1) ? 0.5 : 0.3;
        return (int) (discountRate * price * quantity);
    }

    public int getTotalAmount(){
        return price * quantity - getDiscount();
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %d", 
                name, 
                code, 
                getOrderNumber(), 
                getDiscount(), 
                getTotalAmount());
    }
}

public class traCuuDonHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Order> orders = new ArrayList<>();
        
        // Nhập thông tin từng đơn hàng
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String code = sc.nextLine();
            int unitPrice = Integer.parseInt(sc.nextLine());
            int quantity = Integer.parseInt(sc.nextLine());
            orders.add(new Order(name, code, unitPrice, quantity));
        }
        
        // In danh sách mặt hàng đã tính toán
        for (Order order : orders) {
            System.out.println(order);
        }
        
        sc.close();
    }
}
