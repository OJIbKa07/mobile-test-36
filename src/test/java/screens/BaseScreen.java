package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class BaseScreen {

    protected final SelenideElement continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));
    protected final SelenideElement titleLanguageScreen = $(id("org.wikipedia.alpha:id/primaryTextView"));

    @Step("Перейти к следующему экрану")
    public void continueScreen() {
        continueButton.click();
    }

    @Step("Проверяем текст заголовка: {expectedTitle}")
    public BaseScreen checkTitle(String expectedTitle) {
        titleLanguageScreen.shouldHave(text(expectedTitle));

        return this;
    }
}
