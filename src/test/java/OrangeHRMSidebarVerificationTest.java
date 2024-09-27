import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class OrangeHRMSidebarVerificationTest {
    private WebDriver driver;
    private OrangeHRMDashboardPage dashboardPage;

    @BeforeMethod
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Login to the application
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        dashboardPage = new OrangeHRMDashboardPage(driver);
    }

    @Test
    public void verifySidebarNames() {
        List<WebElement> sidebarMenuItems = dashboardPage.getSidebarMenuItems();
        for (WebElement sidebarItem : sidebarMenuItems) {
            String sidebarName = sidebarItem.getText();
            System.out.println("Sidebar Name: " + sidebarName);
            // Verify the sidebar name here
            if (sidebarName.equals(sidebarMenuItems)) {
                System.out.println("Sidebar Name : " + sidebarName);


            }
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
