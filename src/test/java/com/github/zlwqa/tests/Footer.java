package com.github.zlwqa.tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class Footer {

    public static Stream<Arguments> footerColumns() {
        return Stream.of(
                Arguments.of("СберМаркет",
                        List.of("О компании", "Контакты", "Вакансии", "Документы", "Стать партнером")),
                Arguments.of("Помощь покупателю",
                        List.of("Как мы работаем", "Зоны доставки", "Доставка и оплата", "Помощь"))
        );
    }
}
