package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountAndLoginHelper  extends PageBase {


    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    WebElement cancelButton;

    @FindBy(xpath="//input[@formcontrolname='email']")
    WebElement email_field;

    @FindBy(xpath="//input[@formcontrolname='password']")
    WebElement password_field;

    @FindBy(xpath="//input[@formcontrolname='passwordRep']")
    WebElement rePassword_field;

    @FindBy(xpath = "//span[contains(text(),'Registration')]" )
    WebElement registrationButton;


    public CreateAccountAndLoginHelper(WebDriver driver) {
        super(driver);
    }

    public CreateAccountAndLoginHelper waitUntilPageLoad() {
        waitUntilElementIsLoaded(driver,cancelButton, 40);
        return this;
    }

    public String enterValueToFieldEmailRandom() {
        String email1 = latinDigitString(10)+"@gmail.com";
        setValueToField(email_field,email1);
        return email1;
    }

    public CreateAccountAndLoginHelper emailFieldPressAndSendKeys (String value){
           setValueToField(email_field,value);
           return this;
        //WebElement mailField = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
        //mailField.click();
        //mailField.sendKeys(value);
            }

            public CreateAccountAndLoginHelper passportFieldPressAndSendKeys (String value){
        setValueToField(password_field,value);
        return this;
                //WebElement passwordField = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
                //passwordField.click();
                //passwordField.sendKeys(value);
            }
    public CreateAccountAndLoginHelper repPassportFieldPressAndSendKeys (String value){
        setValueToField(rePassword_field,value);
        return this;
        //WebElement repPasswordField = driver.findElement(By.xpath("//input[@formcontrolname='passwordRep']"));
        //repPasswordField.click();
        //repPasswordField.sendKeys(value);
    }

    public CreateAccountAndLoginHelper registrationButtonWaitAndClick (){

        waitUntilElementIsLoaded(driver,registrationButton,20);
        registrationButton.click();
        return this;
    }



}
