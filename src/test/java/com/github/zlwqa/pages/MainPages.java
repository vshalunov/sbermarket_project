package com.github.zlwqa.pages;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPages {


    public MainPages openMainPageYourself() {
        step("Открыть главную страницу Сбермаркета 'Для себя'", () -> {
            open("https://sbermarket.ru/");
        });
        return this;
    }

    public MainPages openMainPageForBusiness() {
        step("Открыть главную страницу Сбермаркета 'Для бизнеса'", () -> {
            open("https://business.sbermarket.ru/");
        });
        return this;
    }
}
