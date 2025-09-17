package tests.local;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.DataScreen;
import screens.ExploreScreen;
import screens.LanguageScreen;
import screens.ReadingScreen;
import tests.TestBase;

import static io.qameta.allure.Allure.step;

@Tag("android_local")
public class OnboardingTests extends TestBase {

    LanguageScreen languageScreen = new LanguageScreen();
    ExploreScreen exploreScreen = new ExploreScreen();
    ReadingScreen readingScreen = new ReadingScreen();
    DataScreen dataScreen = new DataScreen();

    @Test
    void swapGettingStartedPreview() {
        step("Check Screen Language", () -> {
            languageScreen.checkTitleLanguage();
        });
        step("Check Screen Explore", () -> {
            exploreScreen.continueScreen();
            exploreScreen.checkTitleExplore();
        });

        step("Check Screen Reading", () -> {
            readingScreen.continueScreen();
            readingScreen.checkTitleReading();
        });

        step("Check Screen Data", () -> {
            dataScreen.continueScreen();
            dataScreen.checkTitleData();
        });
}
}
