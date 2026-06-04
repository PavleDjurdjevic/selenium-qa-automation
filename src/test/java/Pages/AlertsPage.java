package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
 Page Object class for Buttons page.
 Contains locators and actions related
 to button interactions.
 */

public class AlertsPage extends BaseTest {
    By smallModal = By.id("showSmallModal");

    public void clickOnSmallModalButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement smallModalButton = wait.until(ExpectedConditions.elementToBeClickable(smallModal));
        scrollToElement(smallModalButton);
        Actions actions = new Actions(driver);
        actions.click(smallModalButton).perform();
    }
}
