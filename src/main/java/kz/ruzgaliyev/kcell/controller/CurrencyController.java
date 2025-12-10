package kz.ruzgaliyev.kcell.controller;

import kz.ruzgaliyev.kcell.entity.ConversionHistory;
import kz.ruzgaliyev.kcell.repository.ConversionHistoryRepository;
import kz.ruzgaliyev.kcell.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;
    private final ConversionHistoryRepository conversionHistoryRepository;

    @GetMapping("/currency/{code}")
    public double getRate(@PathVariable String code) {
        return currencyService.getRate(code);
    }

    @GetMapping("/conversions")
    public double convert(
            @RequestParam double amount,
            @RequestParam String from,
            @RequestParam String to
    ){
        return currencyService.convert(from,to,amount);
    }
    @GetMapping("/history")
    public List<ConversionHistory> getAllHistory() {
        return conversionHistoryRepository.findAll();
    }


}
