public class EmployeeBook {

    private final Employee[] employees = new Employee[10];

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
    }

    public double calculateAverageWage() {
        int count = 0;
        int sum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            count++;
            sum += employee.getWage();
        }
        if (count == 0) {
            return 0.0;
        }
        return (double) sum / count;
    }

    public void printTaxes(String taxScheme) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            double wage = employee.getWage();
            double taxRate;
            switch (taxScheme) {
                case "PROPORTIONAL":
                    taxRate = 0.13;
                    break;
                case "PROGRESSIVE":
                    if (wage <= 150) {
                        taxRate = 0.13;
                    } else if (wage <= 350) {
                        taxRate = 0.17;
                    } else {
                        taxRate = 0.21;
                    }
                    break;
                default:
                    System.out.println(" схема расчёта налога: " + taxScheme);
                    return;
            }
            System.out.printf("Сотрудник id=%d, Ф. И. О.='%s', зарплата=%.2f, налог (%s)=%.2f%n",
                    employee.getId(), employee.getFullName(), wage, taxScheme, wage * taxRate);
        }
    }

    public void indexWagesInDepartment(int department, int percent) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() != department) {
                continue;
            }
            double newWage = employee.getWage() * (1 + percent / 100.0);
            employee.setWage((int) newWage);
        }
    }

    public void printFirstEmployeeAboveWage(int department, int wage) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee == null || employee.getDepartment() != department
                    || employee.getWage() <= wage) {
                continue;
            }
            System.out.print("Найден сотрудник № " + (i + 1) + " в списке. ");
            employee.printShortInfo();
            break;
        }
    }

    public void printEmployeesBelowWage(int wage, int employeeNumber) {
        int printed = 0;
        int index = 0;
        while (index < employees.length) {
            if (printed == employeeNumber) {
                break;
            }
            Employee employee = employees[index];
            index++;
            if (employee == null || employee.getWage() >= wage) {
                continue;
            }
            employee.printShortInfo();
            printed++;
        }
        if (printed == 0) {
            System.out.println("Сотрудников с зарплатой меньше " + wage + " не найдено.");
        }
    }

    public boolean containsByWage(Employee other) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.equals(other)) {
                return true;
            }
        }
        return false;
    }
}