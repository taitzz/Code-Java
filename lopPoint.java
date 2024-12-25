import java.util.Scanner;

class Point {
    private double x;
    private double y;

    // Constructor mặc định
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor với tọa độ
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Constructor sao chép
    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    // Getter cho x
    public double getX() {
        return x;
    }

    // Getter cho y
    public double getY() {
        return y;
    }

    // Phương thức tính khoảng cách từ điểm này tới điểm khác
    public double distance(Point secondPoint) {
        return Math.sqrt(Math.pow(this.x - secondPoint.x, 2) + Math.pow(this.y - secondPoint.y, 2));
    }

    // Phương thức tĩnh tính khoảng cách giữa hai điểm
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    // Ghi đè phương thức toString
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class lopPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số bộ test
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            // Nhập tọa độ hai điểm
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();

            // Tạo hai đối tượng Point
            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);

            // Tính khoảng cách và in kết quả
            System.out.printf("%.4f\n", Point.distance(p1, p2));
        }

        scanner.close();
    }
}
