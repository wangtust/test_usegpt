package net.mooctest;

public class Employee {

    private String employeeId;
    private String name;
    private double salary;

    public Employee(String employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void giveRaise(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Raise percentage must be positive.");
        }
        salary += salary * (percentage / 100);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}