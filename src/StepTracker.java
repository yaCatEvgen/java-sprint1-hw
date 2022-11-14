import java.util.*;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    static int[][] masDayOfMonth = new int[12][30];
    static int mastStep = 10000;

    void inputStep(int indexMon, int indexDay) {
        if ((indexMon < 0) || (indexMon > 11) || (indexDay < 0) || (indexDay > 29)) {
            System.out.println("Введён не верный индекс");
        } else {
            System.out.println("Введите количество шагов за " + indexDay);
            int countStep = scanner.nextInt();
            masDayOfMonth[indexMon][indexDay] = countStep;
        }
    }

    void getStat(int indexMon) {
        int sumStep = 0;
        int maxStep = 0;
        int schet = 1;
        int[] poschet = new int[30];
        int maxdaySeria = 0;

        for (int i = 0; i < 30; i++) {
            if (i != 29) {
                System.out.print("день " + i + "-й:  " + masDayOfMonth[indexMon][i] + " шагов, ");
            } else {
                System.out.println("день " + i + "-й:  " + masDayOfMonth[indexMon][i] + " шагов.");
            }

            sumStep += masDayOfMonth[indexMon][i];

            if (masDayOfMonth[indexMon][i] >= maxStep) {
                maxStep = masDayOfMonth[indexMon][i];
            }

        }

        for (int k = 0; k < poschet.length - 1; k++) {

            if ((masDayOfMonth[indexMon][k] > mastStep) && (masDayOfMonth[indexMon][(k + 1)] > mastStep)) {
                schet += 1;
            } else {
                schet = 1;
            }

            if (schet != 1)
                poschet[k] = schet;
            else
                schet = 0;


        }


        System.out.println("Общее количество шагов за месяц " + sumStep + " шагов");
        System.out.println("Максимальное пройденное количество шагов за день в месяц " + maxStep + " шагов");
        int midlStep = sumStep / 30;
        System.out.println("Среднее пройденное количество шагов за день в месяц " + midlStep + " шагов");
        converter(sumStep);

        for (int j = 0; j < poschet.length; j++) {
            if (poschet[j] > maxdaySeria)
                maxdaySeria = poschet[j];
        }
        System.out.println("Лучшая серия: " + maxdaySeria + " дней подряд");
    }

    private static void converter(int step) {
        double km = step * 0.75;
        int cal = step * 50 / 1000;
        System.out.println("Пройденная дистанция (в км): " + km);
        System.out.println("Количество сожжённых килокалорий: " + cal);

    }

    void cname(int newMastStep) {
        if (newMastStep < 0) {
            System.out.println("Введено неверное значение, попробуйте в следующий раз");
        } else {
            mastStep = newMastStep;
        }
    }
}