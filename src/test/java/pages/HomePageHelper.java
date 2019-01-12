package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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



    public HomePageHelper (WebDriver driver){

        super(driver);

    }

    public HomePageHelper waitUntilPageLoad() {
        waitUntilElementIsLoaded(driver,loginButton,45);
        waitUntilElementIsLoaded(driver,createAccountButton,40);
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
        goToEventButton.click();
        return this;
    }

    public HomePageHelper pressLoginButton() {
        /*WebElement login = driver.findElement(By
                .xpath("//span[contains(text(),'Login')]"));*/
        loginButton.click();
        return this;
    }

    public HomePageHelper pressCreateAccountButton() { // метод вызывает сам себя и можно вызвать несколько методов под названием одного класса
        createAccountButton.click();
        return  this;
    }


    public String getHeader() {
        return header.getText();
    }
}


