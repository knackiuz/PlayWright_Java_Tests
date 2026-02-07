package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WidgetsAutoCompleteTest extends BaseTest {
    @Test
    @DisplayName("Test for Auto Complete: enter part of color name, wait for dropdown, " +
            "then select required color and check that right colors are selected")
    public void typeAndSelectMultipleColorTest(){
        String firstColorName = "Red";
        String secondColorName = "Green";

        List<String> selectedColors = mainPage
                .navigate()
                .verifyMainPageIsLoaded()
                .clickWidgetsCard()
                .selectAutoCompleteMenu()
                .typeAndSelectColor(firstColorName)
                .typeAndSelectColor(secondColorName)
                .getSelectedColors();

        assertTrue(selectedColors.contains(firstColorName), firstColorName + " is missing!");
        assertTrue(selectedColors.contains(secondColorName), secondColorName + " is missing!");

        //page.pause();
    }
}

