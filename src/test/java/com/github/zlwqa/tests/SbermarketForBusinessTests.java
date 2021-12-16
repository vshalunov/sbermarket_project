package com.github.zlwqa.tests;

import com.github.zlwqa.helpers.Attach;
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

@DisplayName("Тестирование главной страницы СберМаркет 'Для бизнеса'")
public class SbermarketForBusinessTests extends TestBase {

    @Test
    @DisplayName("Журнал консоли страницы не должен содержать ошибок")
    @Tags({@Tag("ForBusiness"), @Tag("High")})
    @Owner("Шалунов Василий (zlw-qa)")
    @Feature("Главная страница СберМаркет 'Для бизнеса'")
    @Story("Журнал консоли")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "СберМаркет", url = "https://business.sbermarket.ru/")
    void consoleShouldNotHaveErrorsTest() {
        mainpages.openMainPageForBusiness();

        step("Журналы консоли не должны содержать текст 'SEVERE'", () -> {
            String consoleLogs = Attach.browserConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @CsvSource(value = {
            "Войти | Введите номер телефона, чтобы войти или зарегистрироваться",
            "Заказать обратный звонок | Мы свяжемся с вами в течениии следующего рабочего дня и ответим на все вопросы"
    }, delimiter = '|')
    @Tags({@Tag("ForBusiness"), @Tag("Low")})
    @ParameterizedTest(name = "Отображение вспомогательного текста в модальном окне {0}")
    @DisplayName("Отображение вспомогательного текста в модальном  окне")
    @Owner("Шалунов Василий (zlw-qa)")
    @Feature("Главная страница СберМаркет 'Для себя'")
    @Story("Вспомогательный текст в модальном окне")
    @Severity(SeverityLevel.MINOR)
    @Link(name = "СберМаркет", url = "https://business.sbermarket.ru/")
    void displayDescriptionOfModalWindowTest(String modalWindow, String descriptionOfModalWindow) {
        mainpages.openMainPageForBusiness();

        step("Открыть модальное окно " + modalWindow, () -> {
            $$("button._30Jfu").find(text(modalWindow)).should(enabled, Duration.ofSeconds(30)).click();
        });
        step("Отображение вспомогательного текста " + descriptionOfModalWindow + "в модальном окне", () -> {
            $("div.bKabp").shouldHave(text(descriptionOfModalWindow));
        });
    }

    @EnumSource(TopNavigatePanelForBusiness.class)
    @DisplayName("Пункты навигационной панели")
    @Tags({@Tag("ForBusiness"), @Tag("High")})
    @ParameterizedTest(name = "Отображение пункта {0} в навигационной панели ")
    @Owner("Шалунов Василий (zlw-qa)")
    @Feature("Навигационная панель")
    @Story("Навигационная панель страницы СберМаркет 'Для бизнеса'")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "СберМаркет", url = "https://business.sbermarket.ru/")
    void displayOfNavigateItemTest(TopNavigatePanelForBusiness topNavigatePanelForBusiness) {
        mainpages.openMainPageForBusiness();

        step("Найти отображение пункта " + topNavigatePanelForBusiness + " в навигационной панели", () -> {
            $("._2mePy").shouldHave(text(topNavigatePanelForBusiness.getTopNavigatePanel()));
        });
    }


}
