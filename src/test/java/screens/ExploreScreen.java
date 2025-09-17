package screens;

import io.qameta.allure.Step;

public class ExploreScreen extends BaseScreen {

    @Step("Проверяем заголовок экрана Explore")
    public ExploreScreen checkTitleExplore() {
        checkTitle("New ways to explore");

        return this;
    }
}
