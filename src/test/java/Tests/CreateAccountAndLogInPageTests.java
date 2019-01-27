package Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import util.DataProviders;
import util.LogLog4j;

public class CreateAccountAndLogInPageTests extends TestBase {

    HomePageHelper homePage;
    CreateAccountAndLoginHelper createAccount;
    EventsAuthPageHelper eventsAuthPage;
    LoginPageHelper loginPage;
    ProfilePageHelper profilePage;
    MenuPageHelper menuPage;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @BeforeMethod
    public void initPage() {
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        createAccount = PageFactory.initElements(driver, CreateAccountAndLoginHelper.class);
        eventsAuthPage = PageFactory.initElements(driver, EventsAuthPageHelper.class);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        profilePage = PageFactory.initElements(driver, ProfilePageHelper.class);
        menuPage = PageFactory
                .initElements(driver, MenuPageHelper.class);
        homePage.waitUntilPageLoad();
    }



    @Test  (dataProviderClass = DataProviders.class,dataProvider ="randomUsers" )
    public void createNewAccount (String email,String password) {

        Log.info("-------- Test createNewAccount was started--------");
        Log.info("Parametr:email = " + email);
        Log.info("Parametr:password = " + password);
        Log.info("Parametr:repeat password = " + password);
        Log.info("Test createNewAccount:homepage was opened");

        homePage.waitUntilPageLoad()
                .pressCreateAccountButton();
        createAccount.waitUntilPageLoad()
                .emailFieldPressAndSendKeys(email)
                .passportFieldPressAndSendKeys(password)
                .repPassportFieldPressAndSendKeys(password)
                .registrationButtonWaitAndClick();
        profilePage.waitUntilPageLoad()
                .menuButtonClick();

        menuPage.waitUntilPageLoad()
                .pressLogOutButton();
        homePage.waitUntilPageLoad();
        Log.info("Test createNewAccount- Assert: verify that name " + "'Shabbat in the family circle' is equal to real name'" + homePage.getHeader() + "'");
        Assert.assertEquals(homePage.getHeader(), "Shabbat in the family circle");
        //System.out.println("email: " + email + "  password: " + password);

    }

         //String email = latinDigitString(8) + "@gmail.com";
        //waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Create Account')]"),45);
        //WebElement createAccount = driver.findElement(By.xpath("//span[contains(text(),'Create Account')]"));
        //createAccount.click();
       // WebElement mailField = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
        //mailField.click();
        //mailField.sendKeys(email1);
        //WebElement passwordField = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
        //passwordField.click();
        //passwordField.sendKeys("555555");
        //WebElement repPasswordField = driver.findElement(By.xpath("//input[@formcontrolname='passwordRep']"));
        //repPasswordField.click();
        //repPasswordField.sendKeys("555555");
        //waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Registration')]"),20);
        //WebElement registrationButton = driver.findElement(By.xpath("//span[contains(text(),'Registration')]"));
        //registrationButton.click();
        //waitUntilElementIsLoaded (driver, By.xpath("//mat-icon[@class='but mat-icon material-icons']"),20);
        //WebElement iconMenu = driver.findElement(By.xpath("//mat-icon[@class='but mat-icon material-icons']"));
        //Assert.assertTrue(iconMenu.getAttribute("mattooltip").equals("Menu"));
        // iconMenu.click();
        //WebElement logOutMenu = driver.findElement(By.xpath("//span[@class='marginLeft']"));
        //logOutMenu.click();
        //waitUntilElementIsLoaded (driver, By.xpath("//span[contains(text(),'Go to Event list')]"),20);
        //WebElement goToEventsButton = driver.findElement(By.xpath("//span[contains(text(),'Go to Event list')]"));
        //Assert.assertTrue(goToEventsButton.getText().equals("Go to Event list"));


    @Test (dataProviderClass = DataProviders.class,dataProvider ="randomUsers" )

    public void createNewAccountAndLogin (String email,String password){

        Log.info("-------- Test createNewAccountAndLogin was started--------");
        Log.info("Parametr:email = " + email);
        Log.info("Parametr:password = " + password);
        Log.info("Parametr:repeat password = " + password);
        Log.info("Test createNewAccount:homepage was opened");
        homePage.waitUntilPageLoad()
                .pressCreateAccountButton();
        createAccount.waitUntilPageLoad()
                .emailFieldPressAndSendKeys(email)
                .passportFieldPressAndSendKeys(password)
                .repPassportFieldPressAndSendKeys(password)
                .registrationButtonWaitAndClick();
        profilePage.waitUntilPageLoad()
                .menuButtonClick();
        Log.info("Test createNewAccountAndLogin- Assert: verify that name " + "'Registration' is equal to real name'" + profilePage.getHeader() + "'");
        Assert.assertEquals(profilePage.getHeader(),"Registration");

        menuPage.waitUntilPageLoad()
                .pressLogOutButton();
        homePage.waitUntilPageLoad();
        Log.info("Test createNewAccountAndLogin- Assert: verify that name " + "'Shabbat in the family circle' is equal to real name'" + homePage.getHeader() + "'");
        Assert.assertEquals(homePage.getHeader(),"Shabbat in the family circle");// cравниваем заголовки на странице

        Log.info("Parametr:email = " + email);
        Log.info("Parametr:password = " + password);
        Log.info("Test createNewAccount:homepage was opened");
        homePage.waitUntilPageLoad()
               .pressLoginButton();
        loginPage.waitUntilPageLog_InLoaded()
        .emailFieldPressAndSendKeys(email)
        .passwordFieldPressAndSendKeys(password)
        .waitUntilPageLog_InLoaded()
        .log_InPressButton();
        profilePage.waitUntilPageLoad();
        Log.info("Test createNewAccountAndLogin- Assert: verify that name " + "'Registration' is equal to real name'" + profilePage.getHeader() + "'");
        Assert.assertEquals(profilePage.getHeader(),"Registration");
        //System.out.println("email: " + email + "  password: " + password);


        //String email2 = latinDigitString(8) + "@gmail.com";
        //waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Create Account')]"),45);
        //WebElement createAccount = driver.findElement(By.xpath("//span[contains(text(),'Create Account')]"));
        //createAccount.click();
        //WebElement mailField = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
        //mailField.click();
        //mailField.sendKeys(email2);
        //WebElement passwordField = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
        //passwordField.click();
        //passwordField.sendKeys("example");
        //WebElement repPasswordField = driver.findElement(By.xpath("//input[@formcontrolname='passwordRep']"));
        //repPasswordField.click();
        //repPasswordField.sendKeys("example");
        //waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Registration')]"),20);
        //WebElement registrationButton = driver.findElement(By.xpath("//span[contains(text(),'Registration')]"));
        //registrationButton.click();
        //waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Cancel')]"),20);
        //WebElement cancelButton = driver.findElement(By.xpath("//button[@type='button']//span[contains(text(),'Cancel')]/.."));
        //cancelButton.click();
        //waitUntilElementIsLoaded (driver, By.xpath("//mat-icon[@class='but mat-icon material-icons']"),20);
        //WebElement iconMenu = driver.findElement(By.xpath("//mat-icon[@class='but mat-icon material-icons']"));
        //iconMenu.click();
        //WebElement logOutMenu = driver.findElement(By.xpath("//span[@class='marginLeft']"));
        //logOutMenu.click();
        //waitUntilElementIsLoaded(driver, By.xpath("//span[@class='marginLeft']"),20);

        //----------Login created user----------

        //waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Login')]"),35);
        //WebElement login = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
        //login.click();

        //WebElement emailReg = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
       //emailReg.click();
        //emailReg.sendKeys(email2);
        //waitUntilElementIsLoaded(driver, By.xpath("//input[@formcontrolname='email']"),20);

        //WebElement passReg =  driver.findElement(By.xpath("//input[@formcontrolname='password']"));
       // passReg.click();
        //passReg.sendKeys("example");

        //WebElement log_In = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
        //log_In.click();
        //waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Log in')]"),20);

       // waitUntilElementIsLoaded (driver, By.xpath("//mat-icon[@class='but mat-icon material-icons']"),20);

        //WebElement buttonMenu = driver.findElement(By.xpath("//mat-icon[@class='but mat-icon material-icons']"));
        //Assert.assertTrue(buttonMenu.getAttribute("mattooltip").equals("Menu"));

    }



}
