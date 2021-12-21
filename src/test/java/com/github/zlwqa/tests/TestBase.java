package com.github.zlwqa.tests;

import com.codeborne.selenide.Selenide;
import com.github.zlwqa.config.WebDriverUtil;
import com.github.zlwqa.helpers.AllureAttachments;
import com.github.zlwqa.pages.MainPages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    MainPages mainpages = new MainPages();


    @BeforeAll
    public static void setup() {
        WebDriverUtil.configure();
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
