package com.github.zlwqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.zlwqa.config.CredentialsConfig;
import com.github.zlwqa.helpers.AllureAttachments;
import com.github.zlwqa.pages.MainPages;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {

    MainPages mainpages = new MainPages();
    private static final CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
    private static final String login = credentials.login();
    private static final String password = credentials.password();
    private static final String selenoidURL = System.getProperty("remoteURL");
    private static final String remoteURL = format("https://%s:%s@%s", login, password, selenoidURL);

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        Configuration.remote = remoteURL;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", false);
        capabilities.setCapability("enableVideo", false);
        Configuration.browserCapabilities = capabilities;
        Configuration.timeout = 10000;
    }

    @AfterEach
    public void tearDown() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
        Selenide.closeWebDriver();
    }


}
