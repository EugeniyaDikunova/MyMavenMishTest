package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.LogLog4j;

public class EventsAuthPageHelper extends PageBase {

    @FindBy(xpath = "//mat-icon[@class='but mat-icon material-icons']")
    WebElement menuButton;

    @FindBy(xpath = "//span[contains(text(),'Filters')]")
    WebElement filterButton;

    @FindBy (xpath = "//mat-icon[@class='but mat-icon material-icons']" )
    WebElement iconMenu;

    @FindBy (xpath = "//h1[@class='gorisontal-center']" )
    WebElement titlePage;


    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    public EventsAuthPageHelper (WebDriver driver){

        super(driver);

    }

    public EventsAuthPageHelper waitUntilPageMenuIconLoaded(){
        Log.info("EventsAuthPageHelper: wait until menuButton is loaded");
        waitUntilElementIsLoaded (driver, menuButton,40);
        Log.info("EventsAuthPageHelper: wait until filterButton is loaded");
        waitUntilElementIsLoaded(driver, filterButton,40);
        return this;
    }

    public String getTooltipIconMenu() {
        //WebElement iconMenu = driver.findElement(By.xpath("//mat-icon[@class='but mat-icon material-icons']"));
        return iconMenu.getAttribute("mattooltip");
    }

    public String getHeader() {
        //WebElement titlePage = driver.findElement(By.xpath("//h1[@class='gorisontal-center']"));
        return titlePage.getText();
    }

    public EventsAuthPageHelper menuButtonClick() {
        Log.info("EventsAuthPageHelper: menuButton was clicked");
        menuButton.click();
        return this;
    }
}
