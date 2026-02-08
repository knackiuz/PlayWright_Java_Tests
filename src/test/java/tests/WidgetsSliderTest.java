package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WidgetsSliderTest extends BaseTest {
    @Test
    @DisplayName("Test for Slider: set value - move the slider with arrows and check set value")
    public void moveSliderAndCheckValueTest(){

        int sliderTargetValue = 50;

        mainPage
                .navigate()
                .verifyMainPageIsLoaded()
                .clickWidgetsCard()
                .selectSliderMenu()
                .setSliderValue(sliderTargetValue)
                .checkSliderValue(sliderTargetValue);

        page.pause();
    }
}
