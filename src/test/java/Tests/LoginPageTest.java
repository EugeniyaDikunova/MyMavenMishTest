
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

public class LoginPageTest extends TestBase

{
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    EventsAuthPageHelper eventsAuthPage;
    MenuPageHelper menuPage;

    @BeforeMethod
    public void initPage (){
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        eventsAuthPage = PageFactory.initElements(driver, EventsAuthPageHelper.class);
        menuPage = PageFactory.initElements(driver, MenuPageHelper.class);
    }


    @Test (dataProviderClass = DataProviders.class,dataProvider ="loginPositive" )
    public void LoginPositive (String email,String password) {

           homePage.waitUntilPageLoad()
                    .pressLoginButton();
           loginPage.emailFieldPressAndSendKeys(email)
           .passwordFieldPressAndSendKeys(password)
           .waitUntilPageLog_InLoaded()
           .log_InPressButton();
           eventsAuthPage.waitUntilPageMenuIconLoaded();

        Assert.assertEquals("Menu",eventsAuthPage.getTooltipIconMenu());
        Assert.assertEquals("Find event",eventsAuthPage.getHeader());
        //driver.quit();
     eventsAuthPage.menuButtonClick();
     menuPage.waitUntilPageLoad()
             .pressLogOutButton();
     homePage.waitUntilPageLoad();
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

    @Test  (dataProviderClass = DataProviders.class,dataProvider ="loginNegative" )
    public void LoginNegative (String email,String password) {

        homePage.waitUntilPageLoad()
                .pressLoginButton();
        loginPage.emailFieldPressAndSendKeys(email)
                .passwordFieldPressAndSendKeys(password)
                .waitUntilPageLog_InLoaded()
                .log_InPressButton();
        loginPage.wrongAuthorization();
        Assert.assertEquals("Wrong authorization, login or password", loginPage.wrongAuthorization());
        loginPage.waitUntilPageLog_InLoaded()
                .cancelPushButton();
       // loginPage.notValidEmail();
        //Assert.assertEquals("Not a valid email",loginPage.notValidEmail());
      driver.quit();






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



    }




