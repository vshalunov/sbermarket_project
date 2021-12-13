package com.github.zlwqa.tests;

import com.github.zlwqa.helpers.Attach;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Тестирование главной страницы СберМаркет 'Для бизнеса'")
public class MainPageForBusiness extends TestBase {

    @Test
    @Tags({@Tag("ForBusiness"), @Tag("High")})
    @Owner("Шалунов Василий (zlw-qa)")
    @Feature("Главная страница СберМаркет 'Для бизнеса'")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "СберМаркет", url = "https://business.sbermarket.ru/")
    @DisplayName("Журнал консоли страницы не должен содержать ошибок")
    void consoleShouldNotHaveErrorsTest() {
        mainpages.openMainPageForBusiness();

        step("Журналы консоли не должны содержать текст 'SEVERE'", () -> {
            String consoleLogs = Attach.browserConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
