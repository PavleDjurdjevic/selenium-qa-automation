package Tests;

import Base.BaseTest;
import Base.RetryAnalyzer;
import Pages.AlertsPage;
import Pages.HomePage;
import Pages.Sidebar;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ModalDialogsTest extends BaseTest {
    @BeforeMethod
    public void setUpPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage();
        sidebar = new Sidebar();
        alertsPage = new AlertsPage();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void userCanOpenSmallModal(){
        homePage.clickOnElementCard(homePage.alertsCard);
        sidebar.clickOnSidebarCard("Modal Dialogs");
        alertsPage.clickOnSmallModalButton();

        String smallModalTitle = driver.findElement(By.id("example-modal-sizes-title-sm")).getText();
        Assert.assertTrue(smallModalTitle.contains("Small"));
    }
}
