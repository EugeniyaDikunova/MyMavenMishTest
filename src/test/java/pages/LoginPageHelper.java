package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {

    @FindBy(xpath="//span[contains(text(),'Log in')]")
    WebElement log_InButton;


    @FindBy(xpath="//span[contains(text(),'Cancel')]")
    WebElement cancelButton;

    @FindBy(xpath="//input[@formcontrolname='email']")
    WebElement email_field;

    @FindBy(xpath="//input[@formcontrolname='password']")
    WebElement password_field;

    @FindBy(xpath = "//div[@class='alert alert-danger ng-star-inserted']")
    WebElement alertText;
    @FindBy(xpath = "//mat-error[@id='mat-error-6']")
    WebElement notValidEmail;

    public LoginPageHelper (WebDriver driver){

        super(driver);
    }
    public LoginPageHelper waitUntilPageLog_InLoaded() {
       // waitUntilElementIsLoaded (driver,log_InButton,20);
        waitUntilElementIsLoaded(driver,cancelButton,20);
        //waitUntilElementIsLoaded(driver,email_field,20);
     return this;
    }

public LoginPageHelper cancelPushButton (){
        cancelButton.click();
    return this;
}

    public LoginPageHelper emailFieldPressAndSendKeys(String value){
        setValueToField(email_field,value);
        //email_field.click();    создали один метод для всех полей ввода в page base
        //email_field.clear();
        //email_field.sendKeys(value);
        return this;
    }
    public LoginPageHelper passwordFieldPressAndSendKeys(String value){
        setValueToField(password_field,value);
        //password_field.click();
        //password_field.clear();
        //password_field.sendKeys(value);
        return this;
    }
    public LoginPageHelper log_InPressButton (){
       waitUntilElementIsLoaded(driver,log_InButton,20);
        log_InButton.click();
        return this;
    }
    public String wrongAuthorization(){
        waitUntilElementIsLoaded (driver, alertText,20);
        //WebElement alertText = driver.findElement(By.xpath("//div[@class='alert alert-danger ng-star-inserted']"));
        return  alertText.getText();
    }
    public String notValidEmail(){
        waitUntilElementIsLoaded (driver, notValidEmail,20);
                return notValidEmail.getText();
    }

}
