package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EventsUnAuthPageHelper;
import pages.HomePageHelper;


public class HomePagesTests extends TestBase {

    HomePageHelper homePage;
    EventsUnAuthPageHelper eventsUnAuthPage;

    @BeforeMethod
    public void initPage (){

        //  инициализируем страницы
        homePage = PageFactory.initElements(driver, HomePageHelper.class);

        eventsUnAuthPage = PageFactory.initElements(driver, EventsUnAuthPageHelper.class);

    }

    @Test
    public void openHomePage()  {


        homePage.waitUntilPageLoad();
        String goToButtonName =
                homePage.getGoToEventButtonName();

        Assert.assertEquals("Go to Event list",goToButtonName);

        //Thread.sleep(20000);

       // List<WebElement> topLinksList = driver.findElements(By.cssSelector(".mat-button-wrapper .mat-button-wrapper"));

       // WebElement goToEventsButton = driver.findElement(By.className("mat-stroked-button"));
        //System.out.println("Text of button: "
        // + goToEventsButton.getText());
        //Thread.sleep(5000);

    }

    @Test
    public void goToEventsTest()  {
        homePage.waitUntilPageLoad()
        .pressGoToEventButton ();
        eventsUnAuthPage.waitUntilPageIsLoaded();
        Assert.assertEquals("Find event",eventsUnAuthPage.getHeader());
    }


}
