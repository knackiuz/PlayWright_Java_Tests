package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WidgetsMenuTest extends BaseTest {
    @Test
    @DisplayName("Test for Menu: hover on menu, hover on invisible menu and click on it")
    public void hoverOnMenuAndCheckTest(){
        mainPage
                .navigate()
                .verifyMainPageIsLoaded()
                .clickWidgetsCard()
                .selectMenuMenu()
                .hoverMainItem2()
                .hoverSubSubList()
                .checkSubSubItem1IsVisible()
                .clickSubSubItem1();

        //page.pause();
    }
}
