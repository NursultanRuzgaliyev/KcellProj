package kz.ruzgaliyev.kcell.service;

import kz.ruzgaliyev.kcell.entity.ConversionHistory;
import kz.ruzgaliyev.kcell.entity.CurrencyEntity;
import kz.ruzgaliyev.kcell.repository.ConversionHistoryRepository;
import kz.ruzgaliyev.kcell.repository.CurrencyEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyEntityRepository currencyRepository;
    private final ConversionHistoryRepository conversionHistoryRepository;

    public double convert(String from, String to, double amount) {

        CurrencyEntity fromCurrency = currencyRepository.findByCodeIgnoreCase(from.trim());
        CurrencyEntity toCurrency   = currencyRepository.findByCodeIgnoreCase(to.trim());

        if (fromCurrency == null || toCurrency == null) {
            throw new RuntimeException("Currency not found!");
        }

        double result = amount * fromCurrency.getRateToKzt() / toCurrency.getRateToKzt();

        ConversionHistory history = new ConversionHistory();
        history.setFromCurrency(from);
        history.setToCurrency(to);
        history.setAmount(amount);
        history.setResult(result);
        history.setConversionTime(LocalDateTime.now());
        conversionHistoryRepository.save(history);

        return result;
    }

    public double getRate(String code) {
        CurrencyEntity currency = currencyRepository.findByCodeIgnoreCase(code.trim());

        if (currency == null) {
            throw new RuntimeException("Currency not found!");
        }

        return currency.getRateToKzt();
    }
}
