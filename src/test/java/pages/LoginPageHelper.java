package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.LogLog4j;

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
    @FindBy(xpath= "//mat-error[@id='mat-error-10']")
    WebElement notValidEmail;
    @FindBy(xpath= "//mat-error[@id='mat-error-12']")
    WebElement notValidPassword;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    public LoginPageHelper (WebDriver driver){

        super(driver);
    }
    public LoginPageHelper waitUntilPageLog_InLoaded() {
       // waitUntilElementIsLoaded (driver,log_InButton,20);
        Log.info("LoginPageHelper: wait until cancelButton is loaded");
        waitUntilElementIsLoaded(driver,cancelButton,20);
        //waitUntilElementIsLoaded(driver,email_field,20);
     return this;
    }

public LoginPageHelper cancelPushButton (){
    Log.info("LoginPageHelper:  cancelButton was pressed");
        cancelButton.click();
    return this;
}

    public LoginPageHelper emailFieldPressAndSendKeys(String value){
        Log.info("LoginPageHelper: email was entered in the email field");
        setValueToField(email_field,value);
        //email_field.click();    создали один метод для всех полей ввода в page base
        //email_field.clear();
        //email_field.sendKeys(value);
        return this;
    }
    public LoginPageHelper passwordFieldPressAndSendKeys(String value){
        Log.info("LoginPageHelper: password  was entered in the password field");
        setValueToField(password_field,value);
        //password_field.click();
        //password_field.clear();
        //password_field.sendKeys(value);
        return this;
    }
    public LoginPageHelper log_InPressButton (){
        Log.info("LoginPageHelper: wait until login button is loaded");
       waitUntilElementIsLoaded(driver,log_InButton,20);
        Log.info("LoginPageHelper:  login button was pressed");
        log_InButton.click();
        return this;
    }
    public String wrongAuthorization(){
        Log.info("LoginPageHelper: wait until alert text wrong Authorization is loaded");
        waitUntilElementIsLoaded (driver, alertText,20);
        //WebElement alertText = driver.findElement(By.xpath("//div[@class='alert alert-danger ng-star-inserted']"));
        return  alertText.getText();
    }
    public String notValidEmail(){
        Log.info("LoginPageHelper: wait until alert text not a Valid Email  is loaded");
        waitUntilElementIsLoaded (driver, notValidEmail,40);
        return notValidEmail.getText();
    }
    public String notValidPassword(){
        Log.info("LoginPageHelper: wait until alert text Enter 6 characters is loaded");
        waitUntilElementIsLoaded (driver, notValidPassword,40);
        return notValidPassword.getText();
    }

    public LoginPageHelper waitUntilWindowIsClosed(){ //метод ожидания закрытия окна ввода email & password
        Log.info("LoginPageHelper: wait until window with fields email & password is closed");
        waitUntilElementIsAbsent(driver, cancelButton,30);
        return this;
    }
}
