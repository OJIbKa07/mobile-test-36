package screens;

import io.qameta.allure.Step;

public class DataScreen extends BaseScreen {

    @Step("Проверяем заголовок экрана Explore")
    public DataScreen checkTitleData() {
        checkTitle("Data & Privacy");

        return this;
    }
}
