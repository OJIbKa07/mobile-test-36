package screens;

import io.qameta.allure.Step;

public class LanguageScreen extends BaseScreen {

    @Step("Проверяем заголовок экрана Language")
    public LanguageScreen checkTitleLanguage() {
        checkTitle("The Free Encyclopedia");

        return this;
    }

}
