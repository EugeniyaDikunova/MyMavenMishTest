package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.LogLog4j;

public class EventsUnAuthPageHelper extends PageBase {

    @FindBy(xpath = "//span[contains(text(),'Filters')]")
    WebElement filterButton;

    @FindBy (xpath = "//h1[@class='gorisontal-center']" )
    WebElement titlePage;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    public EventsUnAuthPageHelper (WebDriver driver){

        super(driver);

    }

    public EventsUnAuthPageHelper waitUntilPageIsLoaded() {

        Log.info("EventsUnAuthPageHelper:wait until button Filter is loaded ");
        waitUntilElementIsLoaded(driver, filterButton,20 );
        return this;

    }


    public String getHeader() {
        //WebElement titlePage = driver.findElement(By.xpath("//h1[@class='gorisontal-center']"));

        return titlePage.getText();
    }
}
