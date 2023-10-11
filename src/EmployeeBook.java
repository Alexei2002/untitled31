
class Employee {
    private static int counter = 1;
    private int id;
    private final String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        this.id = counter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class EmployeeBook {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
// Добавление сотрудников
        employees[0] = new Employee("Иванов Иван Иванович", 2, 50000);
        employees[1] = new Employee("Петров Петр Петрович", 3, 60000);
        employees[2] = new Employee("Сидоров Сидор Сидорович", 1, 40000);

// Получение списка всех сотрудников
        System.out.println("Список всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("ID: " + employee.getId());
                System.out.println("Ф.И.О: " + employee.getFullName());
                System.out.println("Отдел: " + employee.getDepartment());
                System.out.println("Зарплата: " + employee.getSalary());
                System.out.println();
            }
        }

// Подсчет суммы затрат на зарплаты
        double totalSalaryExpenses = calculateTotalSalaryExpenses();
        System.out.println("Сумма затрат на зарплаты: " + totalSalaryExpenses);

// Нахождение сотрудника с минимальной зарплатой
        Employee employeeWithMinSalary = findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeWithMinSalary.getFullName() + ", Зарплата: " + employeeWithMinSalary.getSalary());

// Нахождение сотрудника с максимальной зарплатой
        Employee employeeWithMaxSalary = findEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeWithMaxSalary.getFullName() + ", Зарплата: " + employeeWithMaxSalary.getSalary());

// Подсчет среднего значения зарплат
        double averageSalary = calculateAverageSalary();
        System.out.println("Среднее значение зарплат: " + averageSalary);

// Список Ф.И.О. всех сотрудников
        System.out.println("Список Ф.И.О. всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }

    private static double calculateTotalSalaryExpenses() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        double minSalary = Double.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalary) {
                employeeWithMinSalary = employee;
                minSalary = employee.getSalary();
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary) {
                employeeWithMaxSalary = employee;
                maxSalary = employee.getSalary();
            }
        }
        return employeeWithMaxSalary;
    }

    private static double calculateAverageSalary() {
        double totalSalary = calculateTotalSalaryExpenses();
        int numberOfEmployees = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                numberOfEmployees++;
            }
        }
        return totalSalary / numberOfEmployees;
    }
}