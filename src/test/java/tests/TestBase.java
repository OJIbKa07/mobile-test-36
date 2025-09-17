package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.DriverFactory;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    private static final String PLATFORM = System.getProperty("platform", "local");

    @BeforeAll
    static void beforeAll() {
        if (PLATFORM.equals("browserstack")) {
            // значение platform проставляем, чтобы DriverFactory понимал какой драйвер брать
            System.setProperty("platform", "android");
        }

        Configuration.browser = DriverFactory.getDriver().getClass().getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        if (PLATFORM.equals("browserstack")) {
            String sessionId = Selenide.sessionId().toString();
            System.out.println("Browserstack session: " + sessionId);

            Attach.pageSource();
            closeWebDriver();

            Attach.addVideo(sessionId);
        } else {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            closeWebDriver();
        }
    }
}