package Tests;

import Base.BaseTest;
import Base.RetryAnalyzer;
import Pages.HomePage;
import Pages.InteractionsPage;
import Pages.Sidebar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectableTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        homePage = new HomePage();
        sidebar = new Sidebar();
        interactionsPage = new InteractionsPage();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userCanSelectOneOption(){
        homePage.clickOnElementCard(homePage.interactionsCard);
        sidebar.clickOnSidebarCard("Selectable");
        WebElement firstOptionBeforeClick = driver.findElement(By.cssSelector("li[class='mt-2 list-group-item list-group-item-action']"));
        String classBefore = firstOptionBeforeClick.getAttribute("class");
        Assert.assertFalse(classBefore.contains("active"));

        interactionsPage.clickOnFirstOption();

        WebElement firstOptionAfterClick = driver.findElement(By.cssSelector("li[class='mt-2 list-group-item active list-group-item-action']"));
        String classAfter = firstOptionAfterClick.getAttribute("class");
        Assert.assertTrue(classAfter.contains("active"));
    }
}
