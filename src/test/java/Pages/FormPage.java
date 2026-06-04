package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
  Page Object class for Buttons page.
  Contains locators and actions related
  to button interactions.
 */

/*
  Page Object class for Practice Form page.
  Handles form field interactions and submission actions.
 */

public class FormPage extends BaseTest {
    By firstname = By.id("firstName");

    public void fillFirstNameField(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement firstnameField = wait.until(ExpectedConditions.visibilityOfElementLocated(firstname));
        scrollToElement(firstnameField);
        firstnameField.sendKeys("Pavle");
    }

    By lastName = By.id("lastName");

    public void fillLastNameField(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        scrollToElement(lastNameField);
        lastNameField.sendKeys("Djurdjevic");
    }

    By gender = By.id("gender-radio-1");

    public void chooseGenderOption(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement genderField = wait.until(ExpectedConditions.elementToBeClickable(gender));
        scrollToElement(genderField);
        genderField.click();
    }

    By mobileNUmber = By.id("userNumber");

    public void fillMobileNumberField(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement mobileNUmberField = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNUmber));
        scrollToElement(mobileNUmberField);
        mobileNUmberField.sendKeys("0657894353");
    }

    By submit = By.id("submit");

    public void clickOnSubmitButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submit));
        scrollToElement(submitButton);
        submitButton.click();
    }
}
