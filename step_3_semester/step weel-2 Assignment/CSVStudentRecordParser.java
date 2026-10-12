public class CSVStudentRecordParser {
    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Name: " + fields[0]
                    + " | Roll No: " + fields[1]
                    + " | Dept: " + fields[2]);
        }
    }
    public static void main(String[] args) {
        String csvLine = "RIFAQAT AHAMED A G,RA2511003010291,CSE CORE";
        parseStudentRecord(csvLine);
    }
}