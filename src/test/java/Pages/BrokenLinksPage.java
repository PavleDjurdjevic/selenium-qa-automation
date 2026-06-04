package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

 /*
  Page Object class for Broken Links page.
  Handles interactions with valid and broken links.
 */

public class BrokenLinksPage extends BaseTest {
    public By validLink = By.linkText("Click Here for Valid Link");

     /*
     Clicks on the valid link and redirects user to homepage.
     */
    public void clickOnValidLink(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(validLink)
        );

        scrollToElement(link);

        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", link);*/
        Actions actions = new Actions(driver);
        actions.click(link).perform();
    }

    public By invalidLink = By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/a[2]");

    public void clickOnInvalidLink(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(invalidLink)
        );

        scrollToElement(link);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", link);
        /*Actions actions = new Actions(driver);
        actions.click(link).perform();*/
    }
}
