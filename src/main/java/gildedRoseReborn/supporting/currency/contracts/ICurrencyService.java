package gildedRoseReborn.supporting.currency.contracts;

public interface ICurrencyService {
    double convert(double amount, String fromCurrency, String toCurrency);
}
