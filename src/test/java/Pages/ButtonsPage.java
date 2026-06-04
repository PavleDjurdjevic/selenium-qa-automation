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

public class ButtonsPage extends BaseTest {
    By leftClickButton = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div[3]/button");

    public void clickOnButtonByLeftMouseButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(leftClickButton));

        scrollToElement(button);

        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button);*/
        Actions actions = new Actions(driver);
        actions.click(button).perform();
    }

    By rightClickButton = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/button");

    public void clickOnButtonByRightMouseButton(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(rightClickButton));

        scrollToElement(button);

        Actions actions = new Actions(driver);
        actions.contextClick(button).perform();
    }

    By doubleClickButton = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div[1]/button");

    public void clickOnButtonByDoubleClick(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(doubleClickButton));

        scrollToElement(button);

        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
    }
}
