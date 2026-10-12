import java.util.Scanner;
abstract class Parcel {
    double weight;
    double declaredValue;
    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }
    abstract double getCharge();
    double getInsurance() {
        return 0.0;
    }
    double getTotal() {
        return getCharge() + getInsurance();
    }
}
interface Insurable {
    double getInsurance();
}
class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }
    double getCharge() {
        return 40 + 10 * weight;
    }
}
class Express extends Parcel implements Insurable {
    Express(double weight, double value) {
        super(weight, value);
    }
    double getCharge() {
        return 80 + 15 * weight;
    }
    public double getInsurance() {
        return declaredValue * 0.02;
    }
}
class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double value) {
        super(weight, value);
    }
    double getCharge() {
        return 40 + 10 * weight + 50;
    }
    public double getInsurance() {
        return declaredValue * 0.02;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel parcel;
            switch (type) {
                case "STANDARD":
                    parcel = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    parcel = new Express(weight, value);
                    break;
                case "FRAGILE":
                    parcel = new Fragile(weight, value);
                    break;
                default:
                    continue;
            }
            double charge = parcel.getCharge();
            double insurance = parcel instanceof Insurable
                    ? ((Insurable) parcel).getInsurance() : 0.0;
            double total = charge + insurance;
            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
