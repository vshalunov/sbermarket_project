package com.github.zlwqa.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.github.zlwqa.tests.TestData.*;

public class FeedbackModalWindow {

    @Step("Открыть 'Форму обратной связи'")
    public FeedbackModalWindow openFeedbackForm() {
        $(".footer__feedback ._1MFuU").click();
        return this;
    }

    @Step("Заполнить поле 'Ваше имя'")
    public FeedbackModalWindow fillInTheFieldYourName() {
        $("input[placeholder='Иван Петров']").setValue(fullName);
        return this;
    }

    @Step("Заполнить поле 'Адрес электронной почты'")
    public FeedbackModalWindow fillInTheFieldEmail() {
        $("input[placeholder='ivanov@petrov.ru']").setValue(emailRU);
        return this;
    }

    @Step("Заполнить поле 'Мобильный телефон'")
    public FeedbackModalWindow fillInTheFieldCellPhone() {
        $("input[placeholder='+7 999 999-99-99']").setValue(numberPhone);
        return this;
    }

    @Step("Заполнить поле 'Ваш город")
    public FeedbackModalWindow fillInTheFieldYourCity() {
        $("input[placeholder='Москва']").setValue(city);
        return this;
    }

    @Step("Выбрать тип обратной связи")
    public FeedbackModalWindow selectFeedbackType() {
        $$("[data-qa='feedback_modal_feedback_type_button_other']").find(text(feedbackType)).click();
        return this;
    }

    @Step("Заполнить поле 'Опишите ваш вопрос'")
    public FeedbackModalWindow fillInTheFieldDescribeYourQuestion() {
        $("#message").sendKeys(question);
        return this;
    }

    @Step("Отправить обратную связь")
    public FeedbackModalWindow sendFeedBack() {
        $("button[data-qa='feedback_send_button']").click();
        return this;
    }

    @Step("Проверка отображения валидационного сообщения поля 'Адрес электронной почты'")
    public FeedbackModalWindow checkingDisplayOfTheValidationInformationMessageOfEmailField() {
        $(".iOskx").shouldHave(text(emailValidationMessage));
        return this;
    }
}
