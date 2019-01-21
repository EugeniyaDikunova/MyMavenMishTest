package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.LogLog4j;

/**
 * Created by Inka on 07-Jan-19.
 */
public class MenuPageHelper extends PageBase {
    @FindBy(xpath = "//span[@class='marginLeft']")
    WebElement logOutButton;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    public MenuPageHelper(WebDriver driver) {
        super(driver);
    }

    public MenuPageHelper waitUntilPageLoad(){
        Log.info("MenuPageHelper: wait until  logOutButton is loaded");
        waitUntilElementIsLoaded(driver, logOutButton, 40);
        return this;
    }

    public MenuPageHelper pressLogOutButton(){
        Log.info("MenuPageHelper:  logOutButton was pressed");
        logOutButton.click();
        return this;
    }
}
