package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/*
  Page Object class for Buttons page.
  Contains locators and actions related
  to button interactions.
 */

public class Sidebar extends BaseTest {
    public Sidebar(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "router-link")
    public List<WebElement> getSidebarOptions;


    public void clickOnSidebarCard(String buttonName) {
        for (int i = 0; i < getSidebarOptions.size(); i++) {
            scrollToElement(getSidebarOptions.get(i));
            if (getSidebarOptions.get(i).getText().equals(buttonName)) {
                getSidebarOptions.get(i).click();
                break;
            }
        }
    }
}
