
package Tests;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EventsAuthPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;
import pages.MenuPageHelper;
import util.DataProviders;

import org.apache.log4j.Logger;
import util.LogLog4j;


public class LoginPageTest extends TestBase

{
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    EventsAuthPageHelper eventsAuthPage;
    MenuPageHelper menuPage;


    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

 @BeforeMethod (alwaysRun = true)
    public void initPage (){

        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        eventsAuthPage = PageFactory.initElements(driver, EventsAuthPageHelper.class);
        menuPage = PageFactory.initElements(driver, MenuPageHelper.class);
        Log.info("--------BeforeMethod was started--------------");
        Log.info("--BeforeMethod: homePage is opened");
        homePage.waitUntilPageLoad()
                .pressLoginButton();
    }


    @Test (groups = {"sanity","regression"},dataProviderClass = DataProviders.class,dataProvider ="loginPositive" )
    public void LoginPositive (String email,String password) {

        Log.info("-------- Test LoginPositive was started--------");
        Log.info("Parametr:email = " + email);
        Log.info("Parametr:password = " + password);
        Log.info("Test login Positive: homePage was opened");
           loginPage.waitUntilPageLog_InLoaded()
                   .emailFieldPressAndSendKeys(email)
                   .passwordFieldPressAndSendKeys(password)
                   .log_InPressButton();
           eventsAuthPage.waitUntilPageMenuIconLoaded();
        Log.info("Test LoginPositive - Assert: verify that name"  + "'Menu' is equal to real name'" + eventsAuthPage.getTooltipIconMenu() + "'" );
        Assert.assertEquals("Menu",eventsAuthPage.getTooltipIconMenu());
        Log.info("Test LoginPositive- Assert: verify that name " + "'Find event' is equal to real name'" + eventsAuthPage.getHeader() + "'" );
        Assert.assertEquals("Find event",eventsAuthPage.getHeader());

     eventsAuthPage.menuButtonClick();
     menuPage.waitUntilPageLoad()
             .pressLogOutButton();
     homePage.waitUntilPageLoad();
     Log.info("Test LoginPositive- Assert: verify that name " + "'Shabbat in the family circle' is equal to real name'" + homePage.getHeader() + "'");
        Assert.assertEquals(homePage.getHeader(),"Shabbat in the family circle");



        //waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Login')]"),45);
        // WebElement login = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
        // login.click();
        //waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Cancel')]"),20);
          // WebElement email_field = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
           // WebElement password_field = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
           // email_field.click();
            //email_field.sendKeys("jmenka@gmail.com");
           // password_field.click();
           // password_field.sendKeys("221263");
           // waitUntilElementIsLoaded (driver, By.xpath("//span[contains(text(),'Log in')]"),20);
        // WebElement login_button=driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
        //login_button.click();
        //waitUntilElementIsLoaded (driver, By.xpath("//mat-icon[@class='but mat-icon material-icons']"),20);
        //WebElement iconMenu = driver.findElement(By.xpath("//mat-icon[@class='but mat-icon material-icons']"));
        //Assert.assertTrue(iconMenu.getAttribute("mattooltip").equals("Menu"));

        }

    @Test  ( groups = {"regression","negative"},dataProviderClass = DataProviders.class,dataProvider ="loginNegative" )
    public void LoginNegative (String email,String password) {
        Log.info("-------- Test LoginNegative was started--------");
        Log.info("Parametr:email = " + email);
        Log.info("Parametr:password = " + password);
        Log.info("loginNegative: loginPage was opened");
        loginPage.waitUntilPageLog_InLoaded()
                .emailFieldPressAndSendKeys(email)
                .passwordFieldPressAndSendKeys(password)
                .log_InPressButton();
        Log.info("Test LoginNegative- Assert: verify that name " + "'Wrong authorization, login or password' is equal to real name'" + loginPage.wrongAuthorization() + "'");
        Assert.assertEquals("Wrong authorization, login or password", loginPage.wrongAuthorization());
        Log.info("loginNegative: loginPage was opened");
        loginPage.cancelPushButton()
                .waitUntilWindowIsClosed();
    }


    @Test ( groups = {"regression","negative"},dataProviderClass = DataProviders.class,dataProvider = "notValidEmail")
    public void notValidEmail (String email,String password){
        Log.info("-------- Test notValidEmail was started--------");
        Log.info("Parametr:email = " + email);
        Log.info("Parametr:password = " + password);
        //Log.info("Test login notValidEmail :homepage was opened");   перенесли в Before Method
        //homePage.waitUntilPageLoad()
               // .pressLoginButton();
        loginPage.waitUntilPageLog_InLoaded()
                .emailFieldPressAndSendKeys(email)
                .passwordFieldPressAndSendKeys(password);
              Log.info("Test notValidEmail - Assert: verify that name"  + "'Not a valid email' is equal to real name'" + loginPage.notValidEmail() + "'" );
        Assert.assertEquals("Not a valid email",loginPage.notValidEmail());
        loginPage.cancelPushButton()
                .waitUntilWindowIsClosed();

    }

       // waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Login')]"),45);
    //WebElement login = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
    //login.click();

    //waitUntilElementIsLoaded(driver,By.xpath("//span[contains(text(),'Cancel')]"),20);

    /*WebElement email_field = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
    WebElement password_field = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
    email_field.click();
    email_field.sendKeys("jmenkaa@gmail.com");
    password_field.click();
    password_field.sendKeys("221263");*/

    //waitUntilElementIsLoaded (driver, By.xpath("//span[contains(text(),'Log in')]"),20);

    //WebElement login_button=driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
    //login_button.click();

       // waitUntilElementIsLoaded (driver, By.xpath("//div[@class='alert alert-danger ng-star-inserted']"),20);
        //WebElement alertText = driver.findElement(By.xpath("//div[@class='alert alert-danger ng-star-inserted']"));
        //Assert.assertTrue(alertText.getText().equals("Wrong authorization, login or password"));

    @Test (groups = {"regression","negative"},dataProviderClass = DataProviders.class,dataProvider = "notValidPassword")
    public void notValidPassword (String email,String password){
        Log.info("-------- Test notValidPassword was started--------");
        Log.info("Parametr:email = " + email);
        Log.info("Parametr:password = " + password);
        //Log.info("Test login notValidPassword :homepage was opened");
       // homePage.waitUntilPageLoad()
          //      .pressLoginButton();
        loginPage.waitUntilPageLog_InLoaded()
                .passwordFieldPressAndSendKeys(password)
                .emailFieldPressAndSendKeys(email);
        Log.info("Test notValidPassword - Assert: verify that name"  + "'Enter 6 characters' is equal to real name'" + loginPage.notValidPassword() + "'" );
        Assert.assertEquals("Enter 6 characters",loginPage.notValidPassword(),"Alert password wasn't correct");
        loginPage.cancelPushButton()
                .waitUntilWindowIsClosed();
    }




    @Test ( groups = {"regression","negative"})
    public void loginNegativeEmptyEmailPassword(){
        loginPage.waitUntilPageLog_InLoaded()
                .emailFieldPressAndSendKeys("")
                .passwordFieldPressAndSendKeys("")
                .emailFieldPressAndSendKeys("");
        Assert.assertEquals(2,loginPage.getQuantityAlertsForEmptyFields());
    }

    @Test ( groups = {"regression","negative"})
    public void loginNegativeOnlyEmailIsEmpty(){
        loginPage.waitUntilPageLog_InLoaded()
                .emailFieldPressAndSendKeys("")
                .passwordFieldPressAndSendKeys("567890fgd")
                .emailFieldPressAndSendKeys("");
        Assert.assertEquals(1,loginPage.getQuantityAlertsForEmptyFields());
    }

    @Test ( groups = {"regression","negative"})
    public void loginNegativeOnlyPasswordIsEmpty(){
        loginPage.waitUntilPageLog_InLoaded()
                .passwordFieldPressAndSendKeys("")
                .emailFieldPressAndSendKeys("jmenka@gmail.com")
                .passwordFieldPressAndSendKeys("");
        Assert.assertEquals(1,loginPage.getQuantityAlertsForEmptyFields());
    }



}




