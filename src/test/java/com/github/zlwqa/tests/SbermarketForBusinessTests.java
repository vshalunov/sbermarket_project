package com.github.zlwqa.tests;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import annotations.Microservice;
import com.github.zlwqa.helpers.AllureAttachments;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Layer("web")
@JiraIssues({@JiraIssue("HOMEWORK-288")})
@DisplayName("Тестирование главной страницы СберМаркет 'Для бизнеса'")
@Owner("vshalunov")
public class SbermarketForBusinessTests extends TestBase {

    @Microservice("Console")
    @Test
    @AllureId("6200")
    @DisplayName("Журнал консоли страницы не должен содержать ошибок")
    @Tags({@Tag("ForBusiness"), @Tag("High")})
    @Feature("Главная страница СберМаркет 'Для бизнеса'")
    @Story("Журнал консоли")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "СберМаркет", url = "https://business.sbermarket.ru/")
    void consoleShouldNotHaveErrorsTest() {
        mainpages.openMainPageForBusiness();

        step("Журналы консоли не должны содержать текст 'SEVERE'", () -> {
            String consoleLogs = AllureAttachments.browserConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Microservice("Modal window")
    @CsvSource(value = {
            "Войти | Введите номер телефона, чтобы войти или зарегистрироваться",
            "Заказать обратный звонок | Мы свяжемся с вами в течениии следующего рабочего дня и ответим на все вопросы"
    }, delimiter = '|')
    @Tags({@Tag("ForBusiness"), @Tag("Low")})
    @ParameterizedTest(name = "Отображение вспомогательного текста в модальном окне {0}")
    @AllureId("6199")
    @DisplayName("Отображение вспомогательного текста в модальном  окне")
    @Feature("Главная страница СберМаркет 'Для себя'")
    @Story("Вспомогательный текст в модальном окне")
    @Severity(SeverityLevel.MINOR)
    @Link(name = "СберМаркет", url = "https://business.sbermarket.ru/")
    void displayDescriptionOfModalWindowTest(String modalWindow, String descriptionOfModalWindow) {
        mainpages.openMainPageForBusiness();

        step("Открыть модальное окно " + modalWindow, () ->
                $$("button._30Jfu").find(text(modalWindow)).should(enabled, Duration.ofSeconds(30)).click());
        step("Отображение вспомогательного текста " + descriptionOfModalWindow + "в модальном окне", () ->
                $("div.bKabp").shouldHave(text(descriptionOfModalWindow)));
    }

    @Microservice("Top navigate panel")
    @EnumSource(TopNavigatePanelForBusiness.class)
    @DisplayName("Пункты навигационной панели")
    @Tags({@Tag("ForBusiness"), @Tag("High")})
    @ParameterizedTest(name = "Отображение пункта {0} в навигационной панели ")
    @AllureId("6198")
    @Feature("Навигационная панель")
    @Owner("anotherQA")
    @Story("Навигационная панель страницы СберМаркет 'Для бизнеса'")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "СберМаркет", url = "https://business.sbermarket.ru/")
    void displayOfNavigateItemTest(TopNavigatePanelForBusiness topNavigatePanelForBusiness) {
        mainpages.openMainPageForBusiness();

        step("Найти отображение пункта " + topNavigatePanelForBusiness + " в навигационной панели", () ->
                $("._2mePy").shouldHave(text(topNavigatePanelForBusiness.getTopNavigatePanel())));
    }
}
