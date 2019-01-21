package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.LogLog4j;


// для всех методов класс,которые относятся к HomePage

public class HomePageHelper extends PageBase  {

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//span[contains(text(),'Create Account')]")
    WebElement createAccountButton;

    @FindBy(xpath = "//span[contains(text(),'Go to Event list')]")
    WebElement goToEventButton;

    @FindBy(xpath = "//h1[@class='mat-display-3']")
    WebElement header;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    public HomePageHelper (WebDriver driver){

        super(driver);

    }

    public HomePageHelper waitUntilPageLoad() {
        Log.info("HomePageHelper: wait until homePage is loaded");
        Log.info("HomePageHelper: wait until loginButton is loaded");
        waitUntilElementIsLoaded(driver,loginButton,45);
        Log.info("HomePageHelper: wait until createAccountButton is loaded");
        waitUntilElementIsLoaded(driver,createAccountButton,40);
        Log.info("HomePageHelper: wait until goToEventButton is loaded");
        waitUntilElementIsLoaded(driver, goToEventButton,40);
return this;
    }

    public String getGoToEventButtonName() {
        /*WebElement goToEventsButton = driver.findElement(
                By.className("mat-stroked-button"));*/
                return goToEventButton.getText();
    }

    public HomePageHelper pressGoToEventButton() {
        /*WebElement goToEventsButton = driver.findElement(
                By.className("mat-stroked-button"));*/
        Log.info("HomePageHelper: button goToEvent was pressed");
        goToEventButton.click();
        return this;
    }

    public HomePageHelper pressLoginButton() {
        /*WebElement login = driver.findElement(By
                .xpath("//span[contains(text(),'Login')]"));*/
        Log.info("HomePageHelper: button Login was pressed");
        loginButton.click();
        return this;
    }

    public HomePageHelper pressCreateAccountButton() { // метод вызывает сам себя и можно вызвать несколько методов под названием одного класса
        Log.info("HomePageHelper: button createAccount was pressed");
        createAccountButton.click();
        return  this;
    }


    public String getHeader() {
        return header.getText();
    }
}


