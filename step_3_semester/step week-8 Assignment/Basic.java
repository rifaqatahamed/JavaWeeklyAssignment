import java.util.*;
import java.time.LocalDate;
abstract class Plan {
    protected String name;
    protected LocalDate startDate;
    Plan(String name, String startDate) {
        this.name = name;
        this.startDate = LocalDate.parse(startDate);
    }
    abstract int getValidityDays();
    public LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}
class Basic extends Plan {
    Basic(String name, String date) {
        super(name, date);
    }
    @Override
    int getValidityDays() {
        return 30;
    }
}
class Standard extends Plan {
    Standard(String name, String date) {
        super(name, date);
    }
    @Override
    int getValidityDays() {
        return 90;
    }
}
class Premium extends Plan {
    Premium(String name, String date) {
        super(name, date);
    }
    @Override
    int getValidityDays() {
        return 365;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();
            Plan plan;
            switch (type) {
                case "BASIC":
                    plan = new Basic(name, date);
                    break;
                case "STANDARD":
                    plan = new Standard(name, date);
                    break;
                default:
                    plan = new Premium(name, date);
            }
            System.out.printf("%s: %s%n",
                name, plan.getRenewalDate());
        }
        sc.close();
    }
}
