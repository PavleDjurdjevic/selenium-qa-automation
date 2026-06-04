package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

/*
 Base test configuration class.
 Contains shared WebDriver setup, page object instances,
 and reusable utility methods used across tests.
 */

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public Sidebar sidebar;
    public BrokenLinksPage brokenLinksPage;
    public ButtonsPage buttonsPage;
    public FormPage formPage;
    public AlertsPage alertsPage;
    public InteractionsPage interactionsPage;

    /*
     Scrolls to the desired web element using JavaScript Executor.
     @param element WebElement to scroll into view
     */

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }
}
