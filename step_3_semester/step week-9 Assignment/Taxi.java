import java.util.Scanner;
abstract class Cab {
    static final double MIN_FARE = 100.0;
    double km;
    Cab(double km) {
        this.km = km;
    }
    abstract double getRate();
    double getFare() {
        return Math.max(MIN_FARE, km * getRate());
    }
}
interface NightService {
    double getNightFare();
}
class Mini extends Cab {
    Mini(double km) {
        super(km);
    }
    double getRate() {
        return 10.0;
    }
}
class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }
    double getRate() {
        return 14.0;
    }
    public double getNightFare() {
        return getFare() * 1.20;
    }
}
class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }
    double getRate() {
        return 18.0;
    }
   public double getNightFare() {
        return getFare() * 1.20;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab;
            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;
                case "SEDAN":
                    cab = new Sedan(km);
                    break;
                case "SUV":
                    cab = new SUV(km);
                    break;
                default:
                    continue;
            }
            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }
            double fare = cab.getFare();
            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).getNightFare();
            }
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
```