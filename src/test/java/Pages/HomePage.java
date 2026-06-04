package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
  Page Object class for Buttons page.
  Contains locators and actions related
  to button interactions.
 */

public class HomePage extends BaseTest {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Elements")
    public WebElement elementCard;

    /*public void clickOnElementsCard(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(elementCard));
        elementCard.click();
    }*/

    @FindBy(linkText = "Forms")
    public WebElement formsCard;

    /*public void clickOnFormsCard(){
        scrollToElement(formsCard);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(formsCard));
        Actions actions = new Actions(driver);
        actions.click(formsCard).perform();
    }*/

    @FindBy(linkText = "Alerts, Frame & Windows")
    public WebElement alertsCard;

    @FindBy(linkText = "Interactions")
    public WebElement interactionsCard;

    public void clickOnElementCard(WebElement element){
        scrollToElement(element);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }
}
