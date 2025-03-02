import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        List<String> taskList = new ArrayList<>();

        while (true) {
            System.out.print("\nВыберите операцию:\n" +
                    "0. Выход из программы\n" +
                    "1. Добавить дело\n" +
                    "2. Показать дела\n" +
                    "3. Удалить дело по номеру\n" +
                    "4. Удалить дело по названию\n" +
                    "Ваш выбор: ");

            int number = scanner.nextInt();
            scanner.nextLine();
            if (number == 0) {
                break;
            } else {
                switch (number) {
                    case (1):
                        addTask(taskList);
                        break;
                    case (2):
                        showTask(taskList);
                        break;
                    case (3):
                        deleteTaskByNumber(taskList);
                        break;
                    case (4):
                        deleteTaskByValue(taskList);
                        break;
                    default:
                        System.out.println("Такой операции нет");
                        break;

                }
            }

        }

        System.out.println("Вы вышли");
    }

    public static void addTask(List<String> taskList) {
        System.out.print("\nВведите название задачи: ");
        String str = scanner.nextLine();
        taskList.add(str);
        System.out.println("Добавлено!");
        showTask(taskList);
    }

    public static void showTask(List<String> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("\nВаш список дел пуст!");
        } else {
            System.out.println("\nВаш список дел:");
            int taskCount = 1;
            for (String task : taskList) {
                System.out.println(taskCount + ". " + task);
                taskCount++;
            }
        }
    }

    public static void deleteTaskByNumber(List<String> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("\nВаш список дел итак пуст!");
        } else {
            System.out.print("\nВведите номер для удаления: ");
            int taskNumber = scanner.nextInt();
            if (taskNumber > taskList.size()) {
                System.out.println("\nВ вашем списке нет такого дела!");
            } else {
                taskList.remove(taskNumber - 1);
                System.out.println("Удалено!");
                showTask(taskList);
            }
        }
    }

    public static void deleteTaskByValue(List<String> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("\nВаш список дел итак пуст!");
        } else {
            System.out.print("\nВведите задачу для удаления: ");
            String taskValue = scanner.nextLine();
            if (taskList.remove(taskValue)) {
                System.out.println("Удалено!");
                showTask(taskList);
            } else {
                System.out.println("\nВ вашем списке нет такого дела!");
            }
        }
    }

}