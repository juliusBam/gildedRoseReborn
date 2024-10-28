package gildedRoseReborn.services;

import java.util.Random;

public class ExchangeRateAPIConnector {
    public double fetchExchangeRate(String currencyCode) {
        // Simulating API call with random rates; replace with real API call in production
        switch (currencyCode) {
            case "USD": return 1.0;
            case "EUR": return 0.85;
            case "JPY": return 110.0;
            case "GBP": return 0.75;
            case "CAD": return 1.25;
            default:
                System.out.println("Currency not supported. Returning mock rate.");
                return new Random().nextDouble() * 1.5; // Random rate for unsupported currencies
        }
    }
}

