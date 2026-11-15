public class Main {

    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        String[] names = {
                "Козлов Алексей", "Мизим Сергей", "Буранов Алексей", "Зубков Дмитрий",
                "Бугдарян Арташ", "Родина Зинаида", "Валхонская Надежда", "Николаева Елена",
                "Николаев Дмитрий", "Ножкин Максим", "Новиков Дмитрий"
        };
        int[] departments = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1};
        int[] wages = {100, 200, 300, 400, 450, 50, 150, 250, 350, 149, 120};

        for (int i = 0; i < names.length; i++) {
            Employee employee = new Employee(names[i], departments[i], wages[i]);
            boolean added = book.addEmployee(employee);
            System.out.println("Добавление сотрудника '" + names[i] + "': " + added);
        }

        System.out.println("\n=== Список всех сотрудников ===");
        book.printAllEmployees();

        System.out.println("\n=== Средняя зарплата ===");
        System.out.printf("Средняя зарплата: %.2f%n", book.calculateAverageWage());

        System.out.println("\n=== Налоги PROPORTIONAL ===");
        book.printTaxes("PROPORTIONAL");

        System.out.println("\n=== Налоги PROGRESSIVE ===");
        book.printTaxes("PROGRESSIVE");

        System.out.println("\n=== Индексация зарплат отдела 1 на 10% ===");
        book.indexWagesInDepartment(1, 10);
        book.printAllEmployees();

        System.out.println("\n=== Первый сотрудник отдела 3 с зарплатой > 240 ===");
        book.printFirstEmployeeAboveWage(3, 240);

        System.out.println("\n=== Первые 2 сотрудника с зарплатой < 200 ===");
        book.printEmployeesBelowWage(200, 2);

        System.out.println("\n=== Поиск по id ===");
        Employee found = book.getEmployeeById(5);
        System.out.println("Сотрудник с id=5: " + found);
        System.out.println("Сотрудник с id=11 (edge-кейс): " + book.getEmployeeById(11));

        System.out.println("\n=== Проверка containsByWage (сравнение по зарплате) ===");
        Employee sameWage = new Employee("Тестовый Сотрудник", 3, 149);
        System.out.println("Есть сотрудник с зарплатой 149? " + book.containsByWage(sameWage));
        Employee absentWage = new Employee("Тестовый Сотрудник", 3, 777);
        System.out.println("Есть сотрудник с зарплатой 777? " + book.containsByWage(absentWage));
    }
}