class Employee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;
    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println(
            "Employees on record: " + employeeCount
        );
    }
}
public class CompanyEmployeeDemo {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Ravi", 45000);
        Employee employee2 = new Employee("Anitha", 55000);
        Employee employee3 = new Employee("Karthik", 50000);
        Employee.printCompanyInfo();
    }
}