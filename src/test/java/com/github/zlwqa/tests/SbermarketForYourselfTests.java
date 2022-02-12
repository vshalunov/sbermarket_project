package com.github.zlwqa.tests;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import annotations.Microservice;
import com.codeborne.pdftest.PDF;
import com.github.zlwqa.helpers.AllureAttachments;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

@Layer("web")
@JiraIssues({@JiraIssue("HOMEWORK-288")})
@DisplayName("Тестирование главной страницы СберМаркет 'Для себя'")
@Owner("vshalunov")
public class SbermarketForYourselfTests extends TestBase {

    @Microservice("Console")
    @Test
    @AllureId("6202")
    @DisplayName("Журнал консоли страницы не должен содержать ошибок")
    @Tags({@Tag("ForYourself"), @Tag("High")})
    @Feature("Главная страница СберМаркет 'Для себя'")
    @Story("Журнал консоли")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "СберМаркет", url = "https://sbermarket.ru/")
    void consoleShouldNotHaveErrorsTest() {
        mainpages.openMainPageYourself();

        step("Журналы консоли не должны содержать текст 'SEVERE'", () -> {
            String consoleLogs = AllureAttachments.browserConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Microservice("Search address")
    @ValueSource(strings = {"Самара, Россия",
            "Самарская область, Россия "})
    @Tags({@Tag("ForYourself"), @Tag("High")})
    @DisplayName("Отображение значения")
    @ParameterizedTest(name = "{displayName} {0} в выпадающем списке адресов")
    @AllureId("6197")
    @Feature("Главная страница СберМаркет 'Для себя'")
    @Story("Поле для поиска адреса")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "СберМаркет", url = "https://sbermarket.ru/")
    void searchAddressResultsTest(String searchQuery) {
        mainpages.openMainPageYourself();

        step("Ввести в поле поиск Самар", () -> {
            $("input._1OTiP").setValue("Самар");
        });
        step("Отображение значения " + searchQuery + "в выпадающем списке", () -> {
            $("div.ENK70").shouldHave(text(searchQuery));
        });

        // Для отладки выпадающего списка
        //setTimeout(function() {
        //  debugger;
        //}, 3000);
    }

    @Microservice("Footer")
    @MethodSource("com.github.zlwqa.tests.Footer#footerColumns")
    @DisplayName("Отображение значений")
    @Tags({@Tag("ForYourself"), @Tag("High")})
    @ParameterizedTest(name = "{displayName} {1} в подвале сайта у колонки с названием {0}")
    @AllureId("6201")
    @Feature("Подвал")
    @Story("Подвал страницы СберМаркет 'Для себя'")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "СберМаркет", url = "https://sbermarket.ru/")
    void displayValuesInTheFooterTest(String nameColumnFooter, List<String> footerColumns) {
        mainpages.openMainPageYourself();

        step("Перейти в категорию " + nameColumnFooter, () -> {
            $$("div.footer__column").find(text(nameColumnFooter)).$$("li")
                    .shouldHave(texts(footerColumns));
        });
    }

    @Microservice("Feedback")
    @Test
    @DisplayName("Проверка отображения информационного сообщения валидации поля 'Адрес электронной почты'")
    @Tags({@Tag("ForYourself"), @Tag("High")})
    @Feature("Подвал")
    @Story("Подвал страницы СберМаркет 'Для себя'")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "СберМаркет", url = "https://sbermarket.ru/")
    void emailValidationInFeedbackTest() {
        mainpages.openMainPageYourself();

        feedbackModalWindow.openFeedbackForm()
                .fillInTheFieldCellPhone()
                .fillInTheFieldEmail()
                .fillInTheFieldYourCity()
                .fillInTheFieldYourName()
                .fillInTheFieldDescribeYourQuestion()
                .selectFeedbackType()
                .sendFeedBack()
                .checkingDisplayOfTheValidationInformationMessageOfEmailField();

    }

    @Microservice("Feedback")
    @Test
    @DisplayName("Скачивание PDF-файла 'Обработка персональных данных', проверка его свойств и содержимого")
    @Tags({@Tag("ForYourself"), @Tag("Medium")})
    @Feature("Подвал")
    @Owner("anotherQA")
    @Story("Подвал страницы СберМаркет 'Для себя'")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "СберМаркет", url = "https://sbermarket.ru/")
    void downloadPDFAndCheckPropertiesAndContentTest() throws IOException, ParseException {
        mainpages.openMainPageYourself();
        feedbackModalWindow.openFeedbackForm();

        step("Скачать PDF-файл 'Образец заполнения доверенности', проверить его свойства и содержимое", () -> {
            File pdf = $(byText("персональных данных")).download();
            PDF parsedPdf = new PDF(pdf);
            assertThat(parsedPdf.title, is(nullValue()));
            assertThat(parsedPdf.author, is(nullValue()));
            assertThat(parsedPdf.subject, is(nullValue()));
            assertThat(parsedPdf.keywords, is(nullValue()));
            assertThat(parsedPdf.signed, is(false));
            assertThat(parsedPdf.encrypted, is(false));
            assertThat(parsedPdf.producer, is("iLovePDF"));
            assertThat(parsedPdf.numberOfPages, equalTo(16));
        });
    }
}
