import java.util.Scanner;

class Product {
    private String code;
    private double unitPrice;
    private int quantity;

    public Product(String code, double unitPrice, int quantity) {
        this.code = code;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public double calculateSellingPrice() {
        double taxRate = getTaxRate(code.charAt(0));
        double shippingFeeRate = getShippingFeeRate(code.charAt(0));
        if (code.charAt(code.length() - 1) == 'C') {
            taxRate *= 0.95; // Giảm 5% thuế
        }

        double totalCost = unitPrice * quantity;
        double tax = totalCost * taxRate;
        double shippingFee = totalCost * shippingFeeRate;
        double finalCost = totalCost + tax + shippingFee;
        return Math.round(finalCost * 1.20 / quantity * 100.0) / 100.0;
    }

    private double getTaxRate(char firstChar) {
        switch (firstChar) {
            case 'T': return 0.29;
            case 'C': return 0.10;
            case 'D': return 0.08;
            case 'M': return 0.02;
            default: return 0.0;
        }
    }

    private double getShippingFeeRate(char firstChar) {
        switch (firstChar) {
            case 'T': return 0.04;
            case 'C': return 0.03;
            case 'D': return 0.025;
            case 'M': return 0.005;
            default: return 0.0;
        }
    }
}

public class tinhToanGiaBan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống sau số đơn hàng

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String code = parts[0];
            double unitPrice = Double.parseDouble(parts[1]);
            int quantity = Integer.parseInt(parts[2]);

            Product product = new Product(code, unitPrice, quantity);
            System.out.printf("%s %.2f%n", product.getCode(), product.calculateSellingPrice());
        }
    }
}