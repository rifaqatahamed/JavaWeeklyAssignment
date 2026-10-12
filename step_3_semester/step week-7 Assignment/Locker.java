class Locker {
    private String code;
    private final int lockerNumber;
    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }
    public boolean changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            return true;
        }
        return false;
    }
    public int getLockerNumber() {
        return lockerNumber;
    }
}
public class Main {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println(l.changeCode("1234", "5678"));
        // true
        System.out.println(l.changeCode("0000", "9999"));
        // false
        System.out.println(l.getLockerNumber()); // 101
    }
}