class AttendanceSheet {
    private final String[] students;
    private int presentCount;
    public AttendanceSheet(int maxStudents) {
        if (maxStudents < 0) {
            throw new IllegalArgumentException(
                "Maximum size cannot be negative"
            );
        }
        students = new String[maxStudents];
        presentCount = 0;
    }
    public void markPresent(String name) {
        if (name == null || isPresent(name)) {
            return;
        }
        if (presentCount < students.length) {
            students[presentCount] = name;
            presentCount++;
        } else {
            throw new IllegalStateException(
                "Attendance sheet is full"
            );
        }
    }
    public int getPresentCount() {
        return presentCount;
    }
    public boolean isPresent(String name) {
        if (name == null) {
            return false;
        }
        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}
public class Main {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount()); // 2
        System.out.println(sheet.isPresent("Ben")); // true
        System.out.println(sheet.isPresent("Chen")); // false
    }
}