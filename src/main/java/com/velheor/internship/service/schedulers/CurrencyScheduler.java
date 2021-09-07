package com.velheor.internship.service.schedulers;

import com.velheor.internship.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrencyScheduler {

    private final CurrencyService currencyService;

    @EventListener(ApplicationReadyEvent.class)
    public void updateCurrencies() {
        currencyService.updateCurrentCurrenciesRates();
    }

}
