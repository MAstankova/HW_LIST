import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            System.out.print("\nВыберите операцию:\n" +
                    "0. Выход из программы\n" +
                    "1. Добавить дело\n" +
                    "2. Показать дела\n" +
                    "3. Удалить дело по номеру\n" +
                    "4. Удалить дело по названию\n" +
                    "Ваш выбор: ");

            int number = sc.nextInt();
            if (number == 0) {
                break;
            } else {
                switch (number) {
                    case (1):
                        addTask(list);
                        break;
                    case (2):
                        showTask(list);
                        break;
                    case (3):
                        deleteTaskByNumber(list);
                        break;
                    case (4):
                        deleteTaskByValue(list);
                        break;
                    default:
                        System.out.println("Такой операции нет");
                        break;

                }
            }

        }

        System.out.println("Вы вышли");
    }

    public static void addTask(ArrayList<String> list) {
        System.out.print("\nВведите название задачи: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        list.add(str);
        System.out.println("Добавлено!");
        showTask(list);
    }

    public static void showTask(ArrayList<String> list) {
        if (list.size() == 0) {
            System.out.println("\nВаш список дел пуст!");
        } else {
            System.out.println("\nВаш список дел:");
            int count = 1;
            for (String task : list) {
                System.out.println(count + ". " + task);
                count++;
            }
        }
    }

    public static void deleteTaskByNumber(ArrayList<String> list) {
        if (list.size() == 0) {
            System.out.println("\nВаш список дел итак пуст!");
        } else {
            System.out.print("\nВведите номер для удаления: ");
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            if (number > list.size()) {
                System.out.println("\nВ вашем списке нет такого дела!");
            } else {
                list.remove(number - 1);
                System.out.println("Удалено!");
                showTask(list);
            }
        }
    }

    public static void deleteTaskByValue(ArrayList<String> list) {
        if (list.size() == 0) {
            System.out.println("\nВаш список дел итак пуст!");
        } else {
            System.out.print("\nВведите задачу для удаления: ");
            Scanner sc = new Scanner(System.in);
            String value = sc.nextLine();
            if (list.remove(value)) {
                System.out.println("Удалено!");
                showTask(list);
            } else {
                System.out.println("\nВ вашем списке нет такого дела!");
            }
        }
    }

}