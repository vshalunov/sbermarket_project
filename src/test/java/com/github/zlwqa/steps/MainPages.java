package com.github.zlwqa.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPages {


    @Step("Открыть главную страницу Сбермаркета 'Для себя'")
    public MainPages openMainPageYourself() {
            open("https://sbermarket.ru/");
        return this;
    }

    @Step("Открыть главную страницу Сбермаркета 'Для бизнеса'")
    public MainPages openMainPageForBusiness() {
            open("https://business.sbermarket.ru/");
        return this;
    }
}
