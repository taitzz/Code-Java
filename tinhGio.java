import java.util.*;

class Gamer implements Comparable<Gamer> {
    private String id;
    private String name;
    private int playTime; // Thời gian chơi game tính bằng phút

    public Gamer(String id, String name, String startTime, String endTime) {
        this.id = id;
        this.name = name;
        this.playTime = calculatePlayTime(startTime, endTime);
    }

    private int calculatePlayTime(String startTime, String endTime) {
        String[] start = startTime.split(":"), end = endTime.split(":");
        int startHour = Integer.parseInt(start[0]), startMinute = Integer.parseInt(start[1]);
        int endHour = Integer.parseInt(end[0]), endMinute = Integer.parseInt(end[1]);

        return (endHour * 60 + endMinute) - (startHour * 60 + startMinute);
    }

    @Override
    public int compareTo(Gamer other) {
        return Integer.compare(other.playTime, this.playTime); // Sắp xếp giảm dần theo thời gian chơi
    }

    @Override
    public String toString() {
        int hours = playTime / 60;
        int minutes = playTime % 60;
        return id + " " + name + " " + hours + " gio " + minutes + " phut";
    }
}

public class tinhGio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine()); // Số lượng game thủ
        List<Gamer> gamers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            String startTime = sc.nextLine();
            String endTime = sc.nextLine();

            Gamer gamer = new Gamer(id, name, startTime, endTime);
            gamers.add(gamer);
        }

        // Sắp xếp danh sách theo thời gian chơi giảm dần
        Collections.sort(gamers);

        // In kết quả
        for (Gamer gamer : gamers) {
            System.out.println(gamer);
        }

        sc.close();
    }
}
