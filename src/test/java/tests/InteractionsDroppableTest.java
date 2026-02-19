package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("interactions")
public class InteractionsDroppableTest extends BaseTest {
    @Test
    @DisplayName("Test for Interactions: performing drag and drop action, verify success drop")
    public void testDragAndDrop(){
        mainPage
                .navigate()
                .verifyMainPageIsLoaded()
                .clickInteractionCard()
                .selectDroppableMenu()
                .dragAndDropElement()
                .verifyDropSuccess();

        //page.pause();
    }

    @Test
    @DisplayName("Test for Interactions: performing drag and drop action using mouse, verify success drop")
    public void testDragAndDropUsingMouse(){
        mainPage
                .navigate()
                .verifyMainPageIsLoaded()
                .clickInteractionCard()
                .selectDroppableMenu()
                .dragAndDropElementMouse()
                .verifyDropSuccess();

        //page.pause();
    }
}
