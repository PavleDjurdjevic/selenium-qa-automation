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

public class InteractionsPage extends BaseTest {
    By firstOption = By.xpath("/html/body/div/div/div/div/div[2]/div[1]/div/div[1]/ul/li[1]");

    public void clickOnFirstOption(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement firstOptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(firstOption));
        scrollToElement(firstOptionField);
        Actions actions = new Actions(driver);
        actions.click(firstOptionField).perform();
    }
}
