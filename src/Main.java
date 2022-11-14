import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int numMenuUserIn = scanner.nextInt();

        StepTracker steptr = new StepTracker();

        while (numMenuUserIn != 0) {
            // обработка разных случаев
            if (numMenuUserIn == 1) {
                System.out.println("Введите номер месяца от 0 до 11 ");
                int indexMon = scanner.nextInt();
                System.out.println("Введите номер дня от 0 до 29 ");
                int indexDay = scanner.nextInt();

                steptr.inputStep(indexMon, indexDay);
            } else if (numMenuUserIn == 2) {
                System.out.println("Введите номер месяца от 0 до 11 ");
                int indexMon = scanner.nextInt();

                steptr.getStat(indexMon); // Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.
            } else if (numMenuUserIn == 3) {
                System.out.println("Введите новое значение целевого количества шагов за день. Введённое значение не должно быть отрицательным.");
                int newMastStep = scanner.nextInt();
                steptr.cname(newMastStep);
            } else if (numMenuUserIn == 4) {
                break;
            } else {
                System.out.println("Такой команды нет!!! Не растраивайтесь попробуте снова!");
            }

            printMenu();
            numMenuUserIn = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }


    private static void printMenu() {
        System.out.println("");
        System.out.println("""
                1 - Ввести количество шагов за определённый день;
                2 - Напечатать статистику за определённый месяц;
                3 - Изменить цель по количеству шагов в день;
                4 - Выйти из приложения.""");
    }


}
