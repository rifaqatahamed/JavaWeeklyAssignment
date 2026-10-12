import java.util.Scanner;
abstract class Student {
    static final double TRANSPORT_FEE = 12000.0;
    String name;
    Student(String name) {
        this.name = name;
    }
    abstract double getFee();
    double getTotalFee() {
        return getFee();
    }
}
interface BusUser {
    double getTransportFee();
}
class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }
    double getFee() {
        return 40000;
    }
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
    double getTotalFee() {
        return getFee() + getTransportFee();
    }
}
class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }
    double getFee() {
        return 40000 + 60000;
    }
}
class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }
    double getFee() {
        return 20000;
    }
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
    double getTotalFee() {
        return getFee() + getTransportFee();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student student;
            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
                default:
                    continue;
            }
            double fee = student.getTotalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }
        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
```