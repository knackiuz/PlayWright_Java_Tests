package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("interactions")
public class InteractionsResizableTest extends BaseTest {
    @Test
    @DisplayName("Test for Interactions: resize box and check size after the action")
    public void resizableTest(){
        int wight = 150;
        int height = 50;
        int borderSize = 10;
        mainPage
                .navigate()
                .verifyMainPageIsLoaded()
                .clickInteractionCard()
                .selectResizableMenu()
                .resizeBox(wight, height)
                .verifyResizableBoxSize(200 + wight - borderSize, 200 + height - borderSize);

        //page.pause();
    }
}
