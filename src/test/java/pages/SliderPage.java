package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.log4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SliderPage {
    private final Page page;
    private final Logger logger;

    private final Locator slider;
    private final Locator sliderValue;

    public SliderPage(Page page){
        this.page = page;
        this.logger = Logger.getLogger(SliderPage.class);
        this.slider = page.locator("#sliderContainer").locator(".range-slider");
        this.sliderValue = page.locator("#sliderValue");
    }

    public SliderPage setSliderValue(int sliderTargetValue){
        logger.info("Setting slider value to: " + sliderTargetValue);

        int sliderCurrentValue = Integer.parseInt(slider.getAttribute("value"));

        while (sliderCurrentValue != sliderTargetValue){
            if(sliderCurrentValue < sliderTargetValue){
                slider.press("ArrowRight");
                sliderCurrentValue++;
            }   else {
                slider.press("ArrowLeft");
                sliderCurrentValue--;
            }
        }

        logger.info("Slider's value is set to: " + sliderTargetValue);

        return this;
    }

    public SliderPage checkSliderValue(int sliderExpectedValue){
        int sliderCurrentValue = Integer.parseInt(slider.getAttribute("value"));
        assertEquals(sliderExpectedValue, sliderCurrentValue, "Slider value mismatch! Expected value: " + sliderExpectedValue
                + ", but current value: " + sliderCurrentValue);
        return this;
    }
}
