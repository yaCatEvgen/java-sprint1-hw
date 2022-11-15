import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int menuNumber = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();

        while (menuNumber != 0) {
            if (menuNumber == 1) {
                System.out.println("Введите номер месяца от 0 до 11 ");
                int indexMon = scanner.nextInt();
                System.out.println("Введите номер дня от 0 до 29 ");
                int indexDay = scanner.nextInt();
                stepTracker.inputStep(indexMon, indexDay);
            } else if (menuNumber == 2) {
                System.out.println("Введите номер месяца от 0 до 11 ");
                int indexMon = scanner.nextInt();
                stepTracker.getStat(indexMon); // Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.
            } else if (menuNumber == 3) {
                System.out.println("Введите новое значение целевого количества шагов за день. Введённое значение не должно быть отрицательным.");
                int newMastStep = scanner.nextInt();
                stepTracker.setNewStepsTarget(newMastStep);
            } else if (menuNumber == 4) {
                break;
            } else {
                System.out.println("Введена неправильная команда: " + menuNumber);
            }
            printMenu();
            menuNumber = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("");
        System.out.println("1 - Ввести количество шагов за определённый день;\n2 - Напечатать статистику за определённый месяц; \n3 - Изменить цель по количеству шагов в день; \n4 - Выйти из приложения.");
    }
}
