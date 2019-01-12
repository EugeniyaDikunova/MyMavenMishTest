package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventsUnAuthPageHelper extends PageBase {

    @FindBy(xpath = "//span[contains(text(),'Filters')]")
    WebElement filterButton;


    public EventsUnAuthPageHelper (WebDriver driver){

        super(driver);

    }

    public EventsUnAuthPageHelper waitUntilPageIsLoaded() {

        waitUntilElementIsLoaded(driver, filterButton,20 );
        return this;

    }


    public String getHeader() {
        WebElement titlePage = driver.findElement(By
                .xpath("//h1[@class='gorisontal-center']"));
        return titlePage.getText();
    }
}
