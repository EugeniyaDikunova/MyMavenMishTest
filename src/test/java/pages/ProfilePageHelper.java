package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageHelper extends PageBase {

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//mat-icon[@mattooltip='Menu']")
    WebElement iconButton;
    @FindBy(xpath = "//h1[@class='classCentr']")
    WebElement headerRegistration;

    public ProfilePageHelper(WebDriver driver) {
        super(driver);
    }

    public ProfilePageHelper waitUntilPageLoad(){
        waitUntilElementIsLoaded(driver, headerRegistration,40);
        waitUntilElementIsLoaded(driver, cancelButton, 40);
        waitUntilElementIsLoaded(driver, iconButton, 40);

        System.out.println("Cancel button: "+ cancelButton.getText());
        return this;
    }

    public ProfilePageHelper menuButtonClick(){
        iconButton.click();
        return this;
    }

    public String getHeader() {

        return headerRegistration.getText();
    }

}
