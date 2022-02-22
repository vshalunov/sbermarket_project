package com.github.zlwqa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class TestData {

    public static Faker faker = new Faker(new Locale("ru"));

    public static String
            fullName = faker.name().fullName(),
            emailRU = faker.internet().emailAddress(),
            numberPhone = "9" + faker.phoneNumber().subscriberNumber(9),
            city = faker.address().city(),
            question = "Могу ли я у вас купить " + faker.food().ingredient() + "?";

    public static String emailValidationMessage = "Email адрес имеет неправильный формат";
    public static String feedbackType = "Другое";

    public static Stream<Arguments> footerColumns() {
        return Stream.of(
                Arguments.of("СберМаркет",
                        List.of("О компании", "Контакты", "Вакансии", "Документы", "Стать партнером")),
                Arguments.of("Помощь покупателю",
                        List.of("Как мы работаем", "Зоны доставки", "Доставка и оплата", "Помощь"))
        );
    }
}
