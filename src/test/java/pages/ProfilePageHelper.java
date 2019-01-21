package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.LogLog4j;

public class ProfilePageHelper extends PageBase {

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//mat-icon[@mattooltip='Menu']")
    WebElement iconButton;
    @FindBy(xpath = "//h1[@class='classCentr']")
    WebElement headerRegistration; // My Profile field

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    public ProfilePageHelper(WebDriver driver) {
        super(driver);
    }

    public ProfilePageHelper waitUntilPageLoad(){
        Log.info("ProfilePageHelper: wait until My Profile field is loaded");
        waitUntilElementIsLoaded(driver, headerRegistration,40);
        Log.info("ProfilePageHelper: wait until cancelButton is loaded");
        waitUntilElementIsLoaded(driver, cancelButton, 40);
        Log.info("ProfilePageHelper: wait until icon Menu is loaded");
        waitUntilElementIsLoaded(driver, iconButton, 40);

        System.out.println("Cancel button: "+ cancelButton.getText());
        return this;
    }

    public ProfilePageHelper menuButtonClick(){
        Log.info("ProfilePageHelper: icon Menu was pressed");
        iconButton.click();
        return this;
    }

    public String getHeader() {

        return headerRegistration.getText();
    }

}
