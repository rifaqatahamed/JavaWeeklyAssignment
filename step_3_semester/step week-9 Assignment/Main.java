import java.util.Scanner;
abstract class Appliance {
    double hours;
    static final double COST_PER_UNIT = 8.0;
    Appliance(double hours) {
        this.hours = hours;
    }
    abstract double getPower();
    double getUnits() {
        return getPower() * hours / 1000.0;
    }
    double getCost() {
        return getUnits() * COST_PER_UNIT;
    }
}
interface SaverMode {
    double getSaverUnits();
}
class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }
    double getPower() {
        return 150.0;
    }
}
class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }
    double getPower() {
        return 1500.0;
    }
    public double getSaverUnits() {
        return getUnits() * 0.75;
    }
}
class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }
    double getPower() {
        return 100.0;
    }
}
class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }
    double getPower() {
        return 500.0;
    }
    public double getSaverUnits() {
        return getUnits() * 0.75;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER");
            if (saver) {
                sc.next();
            }
            Appliance appliance;
            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
                default:
                    continue;
            }
            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }
            double units = appliance.getUnits();
            if (saver) {
                units = ((SaverMode) appliance).getSaverUnits();
            }
            double cost = units * Appliance.COST_PER_UNIT;
            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );
            totalCost += cost;
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
```