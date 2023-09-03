import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
       double payment = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
       return calculateRound(payment, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return calculateRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculateRound(double value, int places) {
       double scale = Math.pow(10, places);
       return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        int depositPeriod;
        int depositType;
        int amount;
        double outSum = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        if (depositType == 1) {
            outSum = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            outSum = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + outSum);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }

}
