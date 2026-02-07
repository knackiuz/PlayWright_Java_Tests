package pages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FramesPage {
    private final Page page;

    protected final FrameLocator frame1Frame;
    protected final FrameLocator frame2Frame;
    protected final Locator headingFrame1;
    protected final Locator headingFrame2;

    public FramesPage(Page page){
        this.page = page;
        this.frame1Frame = page.frameLocator("#frame1");
        this.frame2Frame = page.frameLocator("#frame2");
        this.headingFrame1 = frame1Frame.locator("#sampleHeading");
        this.headingFrame2 = frame2Frame.locator("#sampleHeading");
    }

    public FramesPage verifyHeadingFrame1(String headingText){
        assertThat(headingFrame1).hasText(headingText);
        return this;
    }

    public FramesPage verifyHeadingFrame2(String headingText){
        assertThat(headingFrame2).hasText(headingText);
        return this;
    }
}
