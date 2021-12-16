package com.github.zlwqa.tests;

public enum TopNavigatePanelForBusiness {

    DELIVERY("Доставка"),
    ADVANTAGES("Преимущества"),
    HOWTOORDER("Как заказать"),
    CITIES("Города"),
    ANSWERSONQUESTIONS("Ответы на вопросы"),
    CERTIFICATES("Сертификаты");

    private final String topNavigatePanel;

    TopNavigatePanelForBusiness(String topNavigatePanel) {
        this.topNavigatePanel = topNavigatePanel;
    }

    public String getTopNavigatePanel() {
        return topNavigatePanel;
    }

    @Override
    public String toString() {
        return topNavigatePanel;
    }
}