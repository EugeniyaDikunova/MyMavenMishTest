package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.LogLog4j;

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

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    public CreateAccountAndLoginHelper(WebDriver driver) {
        super(driver);
    }

    public CreateAccountAndLoginHelper waitUntilPageLoad() {
        Log.info("CreateAccountAndLoginHelper: wait until cancelButton is loaded");
        waitUntilElementIsLoaded(driver,cancelButton, 40);
        return this;
    }

    public String enterValueToFieldEmailRandom() {
        String email1 = latinDigitString(10)+"@gmail.com";
        setValueToField(email_field,email1);
        return email1;
    }

    public CreateAccountAndLoginHelper emailFieldPressAndSendKeys (String value){
        Log.info("CreateAccountAndLoginHelper:email was created in the email field");
           setValueToField(email_field,value);
           return this;
        //WebElement mailField = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
        //mailField.click();
        //mailField.sendKeys(value);
            }

            public CreateAccountAndLoginHelper passportFieldPressAndSendKeys (String value){
                Log.info("CreateAccountAndLoginHelper:password was created in the password field");
        setValueToField(password_field,value);
        return this;
                //WebElement passwordField = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
                //passwordField.click();
                //passwordField.sendKeys(value);
            }
    public CreateAccountAndLoginHelper repPassportFieldPressAndSendKeys (String value){
        Log.info("CreateAccountAndLoginHelper:password was repeated in the repeat password field");
        setValueToField(rePassword_field,value);
        return this;
        //WebElement repPasswordField = driver.findElement(By.xpath("//input[@formcontrolname='passwordRep']"));
        //repPasswordField.click();
        //repPasswordField.sendKeys(value);
    }

    public CreateAccountAndLoginHelper registrationButtonWaitAndClick (){
        Log.info("CreateAccountAndLoginHelper: wait until registrationButton is loaded");
        waitUntilElementIsLoaded(driver,registrationButton,20);
        Log.info("CreateAccountAndLoginHelper: registration Button was pressed");
        registrationButton.click();
        return this;
    }



}
