import java.util.Scanner;

class Fraction {
    private long numerator;
    private long denominator;

    // Constructor
    public Fraction(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // Getter cho tử số
    public long getNumerator() {
        return numerator;
    }

    // Getter cho mẫu số
    public long getDenominator() {
        return denominator;
    }

    // Phương thức rút gọn phân số
    private void simplify() {
        long gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // Tìm UCLN của hai số
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Ghi đè phương thức toString để hiển thị phân số
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

public class lopPhanSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập tử số và mẫu số
        long numerator = scanner.nextLong();
        long denominator = scanner.nextLong();

        // Tạo phân số và in kết quả
        Fraction fraction = new Fraction(numerator, denominator);
        System.out.println(fraction);

        scanner.close();
    }
}
