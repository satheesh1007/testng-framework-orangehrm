import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class VerifySideBarName {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
            // Open the OrangeHRM login page
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            // Log in to OrangeHRM
            driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

            List<WebElement> sidebarItems = driver.findElements(By.className("oxd-sidebar-menu-item"));

            for (WebElement sidebarItem : sidebarItems) {
                String sidebarName = sidebarItem.getText();
                System.out.println("Sidebar Name: " + sidebarName);
                // Verify the sidebar name here
                if (!sidebarName.equals("Expected Sidebar Name")) {
                    System.out.println("Sidebar name mismatch: " + sidebarName);
                }
            }

            driver.quit();
        }
    }

