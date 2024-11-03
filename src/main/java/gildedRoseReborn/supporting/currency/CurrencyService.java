package gildedRoseReborn.supporting.currency;

import gildedRoseReborn.supporting.currency.contracts.ICurrencyService;
import gildedRoseReborn.supporting.currency.externals.ExchangeRateAPIConnector;

public class CurrencyService implements ICurrencyService {
    private ExchangeRateAPIConnector apiConnector;

    public CurrencyService() {
        this.apiConnector = new ExchangeRateAPIConnector();
    }

    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        // Fetch latest rates for both currencies
        double fromRate = apiConnector.fetchExchangeRate(fromCurrency);
        double toRate = apiConnector.fetchExchangeRate(toCurrency);

        if (fromRate <= 0 || toRate <= 0) {
            System.out.println("Error: Invalid exchange rate for one of the currencies.");
            return 0; // Return 0 or handle error appropriately
        }

        // Convert amount to USD, then to target currency
        return (amount / fromRate) * toRate;
    }
}

