package Tests;

import Base.BaseTest;
import Base.RetryAnalyzer;
import Pages.BrokenLinksPage;
import Pages.Sidebar;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

 /*
  Test scenarios for broken and valid links.
 */

public class LinkTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage();
        sidebar = new Sidebar();
        brokenLinksPage = new BrokenLinksPage();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userCanOpenHomePageByLink() throws InterruptedException {
        homePage.clickOnElementCard(homePage.elementCard);
        sidebar.clickOnSidebarCard("Broken Links - Images");

        brokenLinksPage.clickOnValidLink();
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://demoqa.com/";
        Assert.assertEquals(currentURL, expectedURL);
        WebElement elementsCard = driver.findElement(By.linkText("Elements"));
        Assert.assertEquals(elementsCard.getText(), "Elements");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userCanOpenBrokenPageByLink() throws InterruptedException {
        homePage.clickOnElementCard(homePage.elementCard);
        sidebar.clickOnSidebarCard("Broken Links - Images");

        brokenLinksPage.clickOnInvalidLink();
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://the-internet.herokuapp.com/status_codes/500";
        Assert.assertEquals(currentURL, expectedURL);
        WebElement errorTitle = driver.findElement(By.id("content"));
        Assert.assertTrue(errorTitle.getText().contains("This page returned a 500 status code."));
    }
}
