import java.util.Scanner;

public class FinancialForecasting {

    // Recursive Method to Calculate Future Value
    public static double predictFutureValue(double currentValue, double growthRate, int years) {

        // Base Case
        if (years == 0) {
            return currentValue;
        }

        // Recursive Call
        return predictFutureValue(currentValue * (1 + growthRate / 100), growthRate, years - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== Financial Forecasting System ==========");

        System.out.print("Enter the current value: ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter the annual growth rate (in %): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter the number of years to forecast: ");
        int years = sc.nextInt();

        double futureValue = predictFutureValue(currentValue, growthRate, years);

        System.out.println("\n========== Forecast Result ==========");
        System.out.printf("Current Value        : %.2f%n", currentValue);
        System.out.printf("Growth Rate          : %.2f%%%n", growthRate);
        System.out.printf("Forecast Period      : %d years%n", years);
        System.out.printf("Predicted Future Value: %.2f%n", futureValue);

        sc.close();
    }
}