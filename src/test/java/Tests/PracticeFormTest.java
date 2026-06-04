package Tests;

import Base.BaseTest;
import Base.RetryAnalyzer;
import Pages.FormPage;
import Pages.HomePage;
import Pages.Sidebar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

 /*
  Test scenarios for Practice Form validation.
  Covers positive and negative submission cases.
 */

public class PracticeFormTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage();
        sidebar = new Sidebar();
        formPage = new FormPage();
    }

     /*
      Fills required Practice Form fields.
     */
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userCanSubmitWithRequiredFields(){
        homePage.clickOnElementCard(homePage.formsCard);
        sidebar.clickOnSidebarCard("Practice Form");
        formPage.fillFirstNameField();
        formPage.fillLastNameField();
        formPage.chooseGenderOption();
        formPage.fillMobileNumberField();
        formPage.clickOnSubmitButton();

        WebElement submitButton = driver.findElement(By.id("closeLargeModal"));
        Assert.assertTrue(submitButton.isDisplayed());

        String submitMessage = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        Assert.assertEquals(submitMessage, "Thanks for submitting the form");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userCannotSubmitWithoutFirstName(){
        homePage.clickOnElementCard(homePage.formsCard);
        sidebar.clickOnSidebarCard("Practice Form");
        formPage.fillLastNameField();
        formPage.chooseGenderOption();
        formPage.fillMobileNumberField();
        formPage.clickOnSubmitButton();

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        Assert.assertTrue(firstNameField.isDisplayed());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userCannotSubmitWithoutLastName(){
        homePage.clickOnElementCard(homePage.formsCard);
        sidebar.clickOnSidebarCard("Practice Form");
        formPage.fillFirstNameField();
        formPage.chooseGenderOption();
        formPage.fillMobileNumberField();
        formPage.clickOnSubmitButton();

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        Assert.assertTrue(lastNameField.isDisplayed());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userCannotSubmitWithoutMobileNumber(){
        homePage.clickOnElementCard(homePage.formsCard);
        sidebar.clickOnSidebarCard("Practice Form");
        formPage.fillFirstNameField();
        formPage.fillLastNameField();
        formPage.chooseGenderOption();
        formPage.clickOnSubmitButton();

        WebElement submitButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButton.isDisplayed());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userCannotSubmitWithoutGenderOption(){
        homePage.clickOnElementCard(homePage.formsCard);
        sidebar.clickOnSidebarCard("Practice Form");
        formPage.fillFirstNameField();
        formPage.fillLastNameField();
        formPage.fillMobileNumberField();
        formPage.clickOnSubmitButton();

        WebElement submitButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButton.isDisplayed());
    }
}
