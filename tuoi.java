import java.util.*;
import java.text.*;

class Person {
    private String name;
    private Date birthDate;

    public Person(String name, String birthDate) throws ParseException {
        this.name = name;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.birthDate = sdf.parse(birthDate);
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}

public class tuoi {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int n = Integer.parseInt(sc.nextLine()); // Số người
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String name = input[0];
            String birthDate = input[1];
            people.add(new Person(name, birthDate));
        }

        // Tìm người trẻ nhất và già nhất
        Person youngest = Collections.max(people, Comparator.comparing(Person::getBirthDate));
        Person oldest = Collections.min(people, Comparator.comparing(Person::getBirthDate));

        // In kết quả
        System.out.println(youngest.getName());
        System.out.println(oldest.getName());

        sc.close();
    }
}
