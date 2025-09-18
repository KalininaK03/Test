package task1;

import java.util.Scanner;

public class CurrencyConverter {
    private static final double USD_TO_EUR = 0.85;
    private static final double USD_TO_RUB = 75.0;
    private static final double USD_TO_GBP = 0.73;
    private static final double USD_TO_JPY = 110.0;
    private static final double USD_TO_CNY = 6.45;

    private double usdAmount;

    public CurrencyConverter(double usdAmount) {
        this.usdAmount = usdAmount;
    }

    public void convertAndDisplay() {
        System.out.println("Converted amounts:");
        System.out.println("EUR: " + (usdAmount * USD_TO_EUR));
        System.out.println("RUB: " + (usdAmount * USD_TO_RUB));
        System.out.println("GBP: " + (usdAmount * USD_TO_GBP));
        System.out.println("JPY: " + (usdAmount * USD_TO_JPY));
        System.out.println("CNY: " + (usdAmount * USD_TO_CNY));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount in USD: ");
        double usd = scanner.nextDouble();

        if (usd < 0) {
            System.out.println("Amount cannot be negative!");
            scanner.close();
            return;
        }

        CurrencyConverter converter = new CurrencyConverter(usd);
        converter.convertAndDisplay();
        scanner.close();
    }
}