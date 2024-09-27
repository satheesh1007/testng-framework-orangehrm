import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SidebarPage {

    WebDriver driver;

    // Locate all sidebar menu items
    @FindBy(xpath = "//a[@class='oxd-main-menu-item']/span")  // Adjust this XPath if required =//a[contains(@class,'oxd-main-menu-item')]
    private List<WebElement> sidebarMenuItems;

    // Constructor
    public SidebarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to retrieve sidebar menu names as a list of Strings
    public List<String> getSidebarMenuNames() {
        return sidebarMenuItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}

