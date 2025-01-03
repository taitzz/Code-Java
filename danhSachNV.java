import java.util.*;

class Employee {
    private String id;
    private String name;
    private String gender;
    private String dob;
    private String address;
    private String taxCode;
    private String contractDate;

    public Employee(int id, String name, String gender, String dob, String address, String taxCode, String contractDate) {
        this.id = String.format("%05d", id);
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.taxCode = taxCode;
        this.contractDate = contractDate;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + gender + " " + dob + " " + address + " " + taxCode + " " + contractDate;
    }
}

public class danhSachNV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine()); // Số nhân viên
        List<Employee> employees = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String name = sc.nextLine();
            String gender = sc.nextLine();
            String dob = sc.nextLine();
            String address = sc.nextLine();
            String taxCode = sc.nextLine();
            String contractDate = sc.nextLine();

            Employee employee = new Employee(i, name, gender, dob, address, taxCode, contractDate);
            employees.add(employee);
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        sc.close();
    }
}
