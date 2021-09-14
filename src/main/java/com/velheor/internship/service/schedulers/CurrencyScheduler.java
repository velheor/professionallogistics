package com.velheor.internship.service.schedulers;

import com.velheor.internship.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrencyScheduler {

    private final CurrencyService currencyService;
    private final ApplicationContext applicationContext;

    @Scheduled(cron = "0 0 8 * * *", zone = "Europe/Minsk")
    public void updateEveryMorning() {
        currencyService.updateCurrentCurrenciesRates();
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().equals(this.applicationContext)) {
            currencyService.updateCurrentCurrenciesRates();
        }
    }
}
