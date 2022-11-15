import java.util.*;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    static int[][] monthData = new int[12][30];
    static int stepsTarget = 10000;

    void inputStep(int indexMon, int indexDay) {
        if (indexMon < 0 || indexMon > 11 || indexDay < 0 || indexDay > 29) {
            System.out.println("Введён не верный индекс");
        } else {
            System.out.println("Введите количество шагов за " + indexDay);
            int countStep = scanner.nextInt();
            monthData[indexMon][indexDay] = countStep;
        }
    }

    void getStat(int monthIndex) {
        int sumStep = 0;
        int maxStep = 0;
        int count = 1;
        int[] arrayCount = new int[30];
        int maxDaysSeries = 0;

        for (int i = 0; i < 30; i++) {
            if (i != 29) {
                System.out.print("день " + i + "-й:  " + monthData[monthIndex][i] + " шагов, ");
            } else {
                System.out.println("день " + i + "-й:  " + monthData[monthIndex][i] + " шагов.");
            }

            sumStep += monthData[monthIndex][i];

            if (monthData[monthIndex][i] >= maxStep) {
                maxStep = monthData[monthIndex][i];
            }
        }

        for (int k = 0; k < arrayCount.length - 1; k++) {
            if ((monthData[monthIndex][k] > stepsTarget) && (monthData[monthIndex][(k + 1)] > stepsTarget)) {
                count += 1;
            } else {
                count = 1;
            }

            if (count != 1)
                arrayCount[k] = count;
            else
                count = 0;
        }

        System.out.println("Общее количество шагов за месяц " + sumStep + " шагов");
        System.out.println("Максимальное пройденное количество шагов за день в месяц " + maxStep + " шагов");
        double averageStepsPerDay = sumStep / 30;
        System.out.println("Среднее пройденное количество шагов за день в месяц " + averageStepsPerDay + " шагов");
        converter(sumStep);

        for (int j = 0; j < arrayCount.length; j++) {
            if (arrayCount[j] > maxDaysSeries)
                maxDaysSeries = arrayCount[j];
        }
        System.out.println("Лучшая серия: " + maxDaysSeries + " дней подряд");
    }

    private static void converter(int steps) {
        double km = steps * 0.75;
        int kilocalories = steps * 50 / 1000;
        System.out.println("Пройденная дистанция (в км): " + km);
        System.out.println("Количество сожжённых килокалорий: " + kilocalories);
    }

    void setNewStepsTarget(int newTarget) {
        if (newTarget < 0) {
            System.out.println("Введено неверное значение:  " + newTarget + ". Цель не может быть отрицательной");
        } else {
            stepsTarget = newTarget;
        }
    }
}