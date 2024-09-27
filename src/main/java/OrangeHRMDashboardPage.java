import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrangeHRMDashboardPage {
    private WebDriver driver;
    private By sidebarMenuItems = By.className("//a[@class='oxd-main-menu-item']");

    public OrangeHRMDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getSidebarMenuItems() {
        return driver.findElements(sidebarMenuItems);
    }

//    public boolean isSidebarMenuItemDisplayed(String sidebarName) {
//        By sidebarMenuItemLocator = By.xpath("//span[contains(text(), '" + sidebarName + "')]");
//        WebElement sidebarMenuItem = driver.findElement(sidebarMenuItemLocator);
//        return sidebarMenuItem.isDisplayed();
    }


