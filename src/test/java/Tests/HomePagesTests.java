package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EventsUnAuthPageHelper;
import pages.HomePageHelper;

import org.apache.log4j.Logger;
import util.LogLog4j;


public class HomePagesTests extends TestBase {

    HomePageHelper homePage;
    EventsUnAuthPageHelper eventsUnAuthPage;


    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    @BeforeMethod
    public void initPage (){

        //  инициализируем страницы
        homePage = PageFactory.initElements(driver, HomePageHelper.class);

        eventsUnAuthPage = PageFactory.initElements(driver, EventsUnAuthPageHelper.class);
        Log.info("--------BeforeMethod was stareted-----");
        Log.info("Test openHomePage: wait until homePage is loaded");
        homePage.waitUntilPageLoad();

    }

    @Test(groups = {"sanity","regression"})
    public void openHomePage()  {
        Log.info("-----Test openHomePage was started");
        Log.info("Test openHomePage: get name of GoToEventButton");
        String goToButtonName =
                homePage.getGoToEventButtonName();
        Log.info("Test openHomePage - Assert: verify that name " + "'Go to Event list' is equal to real name'" + goToButtonName + "'" );
        Assert.assertEquals("Go to Event list",goToButtonName, "'Go to Event list' is not equal to real name of the button");

        //Thread.sleep(20000);

       // List<WebElement> topLinksList = driver.findElements(By.cssSelector(".mat-button-wrapper .mat-button-wrapper"));

       // WebElement goToEventsButton = driver.findElement(By.className("mat-stroked-button"));
        //System.out.println("Text of button: "
        // + goToEventsButton.getText());
        //Thread.sleep(5000);

    }

    @Test (groups = {"regression"})
    public void goToEventsTest()  {

        homePage.pressGoToEventButton ();
        eventsUnAuthPage.waitUntilPageIsLoaded();
        Log.info("Test goToEventsTest - Assert: verify that name " + "'Find event' is equal to real name'" + eventsUnAuthPage.getHeader() + "'" );
        Assert.assertEquals("Find event",eventsUnAuthPage.getHeader());
    }


}
