public class Employee {

    private static int idCounter = 1;

    private int id;
    private String fullName;
    private int department;
    private int wage;

    public Employee(String fullName, int department, int wage) {
        this.id = idCounter;
        idCounter++;
        this.fullName = fullName;
        this.department = department;
        this.wage = wage;
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

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return wage == employee.wage;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(wage);
    }

    @Override
    public String toString() {
        return "Сотрудник {"
                + "id=" + id
                + ", Ф. И. О.='" + fullName + '\''
                + ", отдел=" + department
                + ", зарплата=" + wage
                + '}';
    }

    public void printShortInfo() {
        System.out.println("Ф. И. О.: " + fullName + ", зарплата: " + wage);
    }
}