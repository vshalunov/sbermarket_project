package com.github.zlwqa.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

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

}
