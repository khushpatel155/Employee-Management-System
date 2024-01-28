import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void updateEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}

class EmployeeManagementSystem {
    private ArrayList<Employee> employeeList;
    private int nextEmployeeId;

    public EmployeeManagementSystem() {
        this.employeeList = new ArrayList<>();
        this.nextEmployeeId = 1;
    }
    
    public void addEmployee(String name, double salary) {
        Employee newEmployee = new Employee(nextEmployeeId, name, salary);
        employeeList.add(newEmployee);
        nextEmployeeId++;
        System.out.println("Employee added successfully.");
    }

    public void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }
    }

    public void searchEmployeeById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                System.out.println("Employee found:");
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void updateEmployeeById(int id, String name, double salary) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employee.updateEmployee(name, salary);
                System.out.println("Employee information updated successfully.");
                return;
            }
        }   
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void deleteEmployee(int id) {
        boolean removed = employeeList.removeIf(employee -> employee.getId() == id);
        if (removed) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found. ID is invalid.");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Information");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.next();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    ems.addEmployee(name, salary);
                    break;

                case 2:
                    ems.displayAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter employee ID to search: ");
                    int searchId = scanner.nextInt();
                    ems.searchEmployeeById(searchId);
                    break;
                case 4:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new employee name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new employee salary: ");
                    double newSalary = scanner.nextDouble();
                    ems.updateEmployeeById(updateId, newName, newSalary);
                    break;
                
                case 5:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    ems.deleteEmployee(deleteId);
                    break;
                
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}