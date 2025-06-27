import java.util.Scanner;
public class FinancialForecasting {
    public static double forecastFutureValue(int years, double currentValue, double growthRate) {
        if (years == 0) {
            return currentValue;
        }
        return forecastFutureValue(years - 1, currentValue, growthRate) * (1 + growthRate);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Financial Forecasting Tool ---");
        System.out.print("Enter current value: ");
        double currentValue = sc.nextDouble();
        System.out.print("Enter annual growth rate: ");
        double growthRate = sc.nextDouble();
        System.out.print("Enter no. of years to forecast: ");
        int years = sc.nextInt();
        double result = forecastFutureValue(years, currentValue, growthRate);
        System.out.printf("Predicted future value after %d years: %.2f\n", years, result);
        sc.close();
    }
}
