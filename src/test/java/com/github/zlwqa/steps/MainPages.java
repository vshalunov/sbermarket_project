package com.github.zlwqa.steps;

import com.github.zlwqa.config.AppConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.open;

public class MainPages {

    private static final AppConfig APP_CONFIG = ConfigFactory.create(AppConfig.class, System.getProperties());
    public static final String MAIN_PAGE_FOR_YOUR_SELF_URL = APP_CONFIG.mainPageYourselfURL();
    public static final String MAIN_PAGE_FOR_BUSINESS_URL = APP_CONFIG.mainPageForBusinessURL();

    @Step("Открыть главную страницу Сбермаркета 'Для себя'")
    public MainPages openMainPageYourself() {
        open(MAIN_PAGE_FOR_YOUR_SELF_URL);
        return this;
    }

    @Step("Открыть главную страницу Сбермаркета 'Для бизнеса'")
    public MainPages openMainPageForBusiness() {
        open(MAIN_PAGE_FOR_BUSINESS_URL);
        return this;
    }
}
