package Tests;

import Base.BaseTest;
import Base.RetryAnalyzer;
import Pages.ButtonsPage;
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
  Test scenarios for button functionality.
  Covers left click, right click,
  and double click actions.
 */

public class ButtonTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage();
        sidebar = new Sidebar();
        buttonsPage = new ButtonsPage();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userCanClickOnButtonByLeftMouseButton(){
        homePage.clickOnElementCard(homePage.elementCard);
        sidebar.clickOnSidebarCard("Buttons");
        buttonsPage.clickOnButtonByLeftMouseButton();
        String leftClickMessage = driver.findElement(By.id("dynamicClickMessage")).getText();
        Assert.assertEquals(leftClickMessage, "You have done a dynamic click");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void useCanClickOnButtonByRightMouseButton(){
        homePage.clickOnElementCard(homePage.elementCard);
        sidebar.clickOnSidebarCard("Buttons");
        buttonsPage.clickOnButtonByRightMouseButton();
        String rightClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertEquals(rightClickMessage, "You have done a right click");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userCanClickOnButtonByDoubleClick(){
        homePage.clickOnElementCard(homePage.elementCard);
        sidebar.clickOnSidebarCard("Buttons");
        buttonsPage.clickOnButtonByDoubleClick();
        String rightClickMessage = driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals(rightClickMessage, "You have done a double click");
    }
}
