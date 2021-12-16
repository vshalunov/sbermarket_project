package com.github.zlwqa.tests;

import com.github.zlwqa.helpers.Attach;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Тестирование главной страницы СберМаркет 'Для себя'")
public class SbermarketForYourselfTests extends TestBase {

    @Test
    @DisplayName("Журнал консоли страницы не должен содержать ошибок")
    @Tags({@Tag("ForYourself"), @Tag("High")})
    @Owner("Шалунов Василий (zlw-qa)")
    @Feature("Главная страница СберМаркет 'Для себя'")
    @Story("Журнал консоли")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "СберМаркет", url = "https://sbermarket.ru/")
    void consoleShouldNotHaveErrorsTest() {
        mainpages.openMainPageYourself();

        step("Журналы консоли не должны содержать текст 'SEVERE'", () -> {
            String consoleLogs = Attach.browserConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @ValueSource(strings = {"Самара, Россия",
            "Самарская область, Россия"})
    @Tags({@Tag("ForYourself"), @Tag("High")})
    @ParameterizedTest(name = "Отображение значения {0} в выпадающем списке адресов")
    @DisplayName("Отображение значения в выпадающем списке адресов")
    @Owner("Шалунов Василий (zlw-qa)")
    @Feature("Главная страница СберМаркет 'Для себя'")
    @Story("Поле для поиска адреса")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "СберМаркет", url = "https://business.sbermarket.ru/")
    void searchAddressResultsTest(String searchQuery) {
        mainpages.openMainPageYourself();

        step("Ввести в поле поиск Самар", () -> {
            $("input._1H6W1").setValue("Самар");
        });
        step("Отображение значения " + searchQuery + "в выпадающем списке", () -> {
            $("div._2oqP5").shouldHave(text(searchQuery));
        });
    }

    @MethodSource("com.github.zlwqa.tests.Footer#footerColumns")
    @DisplayName("Отображение значений в подвале сайта")
    @Tags({@Tag("ForYourself"), @Tag("High")})
    @ParameterizedTest(name = "Отображение значений {1} в подвале сайта у колонки с названием {0}")
    @Owner("Шалунов Василий (zlw-qa)")
    @Feature("Подвал")
    @Story("Подвал страницы СберМаркет 'Для себя'")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "СберМаркет", url = "https://business.sbermarket.ru/")
    void displayValuesInTheFooterTest(String nameColumnFooter, List<String> footerColumns) {
        mainpages.openMainPageYourself();

        step("Перейти в категорию " + nameColumnFooter, () -> {
            $$("div.footer__column").find(text(nameColumnFooter)).$$("li")
                    .shouldHave(texts(footerColumns));
        });
    }
}
