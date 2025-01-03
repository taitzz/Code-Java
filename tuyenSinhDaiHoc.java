import java.util.Scanner;

class ThiSinh {
    private String maThiSinh;
    private String hoTen;
    private double diemToan;
    private double diemLy;
    private double diemHoa;

    public ThiSinh(String maThiSinh, String hoTen, double diemToan, double diemLy, double diemHoa) {
        this.maThiSinh = maThiSinh;
        this.hoTen = hoTen;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public String getMaThiSinh() {
        return maThiSinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public double tinhDiemUuTien() {
        String khuVuc = maThiSinh.substring(0, 3);
        switch (khuVuc) {
            case "KV1": return 0.5;
            case "KV2": return 1.0;
            case "KV3": return 2.5;
            default: return 0.0;
        }
    }

    public double tinhTongDiemKhongUuTien() {
        return diemToan * 2 + diemLy + diemHoa;
    }

    public double tinhTongDiemCoUuTien() {
        return tinhTongDiemKhongUuTien() + tinhDiemUuTien();
    }

    public String xacDinhTrangThai(double diemChuan) {
        return tinhTongDiemCoUuTien() >= diemChuan ? "TRUNG TUYEN" : "TRUOT";
    }
}

public class tuyenSinhDaiHoc {

    public static String dinhDangDiem(double diem) {
        if (diem == (int) diem) {
            return String.format("%d", (int) diem); // Hiển thị số nguyên
        } else {
            return String.format("%.1f", diem); // Hiển thị 1 chữ số thập phân
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String maThiSinh = scanner.nextLine();
        String hoTen = scanner.nextLine();
        double diemToan = Double.parseDouble(scanner.nextLine());
        double diemLy = Double.parseDouble(scanner.nextLine());
        double diemHoa = Double.parseDouble(scanner.nextLine());

        ThiSinh thiSinh = new ThiSinh(maThiSinh, hoTen, diemToan, diemLy, diemHoa);

        double diemChuan = 24.0;

        System.out.printf("%s %s %s %s %s%n",
                thiSinh.getMaThiSinh(),
                thiSinh.getHoTen(),
                dinhDangDiem(thiSinh.tinhDiemUuTien()),
                dinhDangDiem(thiSinh.tinhTongDiemKhongUuTien()),
                thiSinh.xacDinhTrangThai(diemChuan));

        scanner.close();
    }
}