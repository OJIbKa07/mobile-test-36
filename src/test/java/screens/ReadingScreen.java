package screens;

import io.qameta.allure.Step;

public class ReadingScreen extends BaseScreen {

    @Step("Проверяем заголовок экрана Reading")
    public ReadingScreen checkTitleReading() {
        checkTitle("Reading lists with sync");

        return this;
    }
}
