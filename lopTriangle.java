import java.util.Scanner;

class Point {
    double x, y;

    // Constructor để khởi tạo tọa độ của điểm
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Phương thức tính khoảng cách giữa hai điểm
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    // Phương thức tĩnh để lấy điểm từ input
    public static Point nextPoint(Scanner sc) {
        return new Point(sc.nextDouble(), sc.nextDouble());
    }
}

class Triangle {
    Point p1, p2, p3;

    // Constructor để khởi tạo 3 điểm tạo thành tam giác
    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    // Phương thức kiểm tra xem 3 điểm có tạo thành một tam giác hợp lệ không
    public boolean valid() {
        double a = p1.distanceTo(p2);
        double b = p2.distanceTo(p3);
        double c = p3.distanceTo(p1);
        
        // Kiểm tra điều kiện tam giác (tổng 2 cạnh phải lớn hơn cạnh còn lại)
        return a + b > c && a + c > b && b + c > a;
    }

    // Phương thức tính chu vi của tam giác và làm tròn đến 3 chữ số sau dấu thập phân
    public String getPerimeter() {
        double a = p1.distanceTo(p2);
        double b = p2.distanceTo(p3);
        double c = p3.distanceTo(p1);
        return String.format("%.3f", a + b + c);
    }

}

public class lopTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Đọc số bộ test
        
        while (t-- > 0) {
            // Đọc tọa độ của 3 điểm và tạo đối tượng Triangle
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            
            // Kiểm tra tính hợp lệ của tam giác
            if (!a.valid()) {
                System.out.println("INVALID");
            } else {
                // In ra chu vi tam giác đã được làm tròn
                System.out.println(a.getPerimeter());
            }
        }
    }
}
