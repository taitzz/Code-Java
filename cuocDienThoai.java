import java.util.*;

class Province {
    String code;
    String name;
    int rate;

    public Province(String code, String name, int rate) {
        this.code = code;
        this.name = name;
        this.rate = rate;
    }
}

class Call {
    String phoneNumber;
    String startTime;
    String endTime;

    public Call(String phoneNumber, String startTime, String endTime) {
        this.phoneNumber = phoneNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int calculateMinutes() {
        String[] start = startTime.split(":"), end = endTime.split(":");
        int startMinutes = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int endMinutes = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        return endMinutes - startMinutes;
    }
}

public class cuocDienThoai {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input provinces
        int numProvinces = Integer.parseInt(scanner.nextLine());
        Map<String, Province> provinceMap = new HashMap<>();

        for (int i = 0; i < numProvinces; i++) {
            String code = scanner.nextLine();
            String name = scanner.nextLine();
            int rate = Integer.parseInt(scanner.nextLine());
            provinceMap.put(code, new Province(code, name, rate));
        }

        // Input calls
        int numCalls = Integer.parseInt(scanner.nextLine());
        List<Call> calls = new ArrayList<>();

        for (int i = 0; i < numCalls; i++) {
            String[] callInfo = scanner.nextLine().split(" ");
            calls.add(new Call(callInfo[0], callInfo[1], callInfo[2]));
        }

        // Process each call
        for (Call call : calls) {
            String phoneNumber = call.phoneNumber;
            int minutes = call.calculateMinutes();
            int cost;

            if (phoneNumber.startsWith("0")) {
                String areaCode = phoneNumber.substring(1, 3);
                Province province = provinceMap.get(areaCode);
                if (province != null) {
                    cost = minutes * province.rate;
                    System.out.printf("%s %s %d %d\n", phoneNumber, province.name, minutes, cost);
                }
            } else {
                // Internal call
                int effectiveMinutes = (int) Math.ceil(minutes / 3.0);
                cost = effectiveMinutes * 800;
                System.out.printf("%s Noi mang %d %d\n", phoneNumber, effectiveMinutes, cost);
            }
        }

        scanner.close();
    }
}
