import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SidebarTest {
    WebDriver driver;
    SidebarPage sidebarPage;

    @BeforeClass
    public void setup() {
        // Set the path to the WebDriver (ChromeDriver in this case)
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
       WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the OrangeHRM application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Login steps can be added here if necessary
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Initialize the Sidebar Page Object
        sidebarPage = new SidebarPage(driver);
    }

    @Test
    public void verifySidebarMenuNamesAreCorrectlySpelled() {
        // Expected sidebar menu names with correct spelling
        List<String> expectedSidebarMenus = Arrays.asList("Admin", "PIM", "Leave", "Time", "Recruitment", "My Info", "Performance", "Directory", "Maintenance", "Claim", "Buzz");

        // Get actual sidebar menu names from the webpage
        List<String> actualSidebarMenus = sidebarPage.getSidebarMenuNames();

        // Print actual and expected menus for debugging
        System.out.println("Expected Sidebar Menus: " + expectedSidebarMenus);
        System.out.println("Actual Sidebar Menus: " + actualSidebarMenus);

        // Assert that the actual sidebar menu names match the expected
        Assert.assertEquals(actualSidebarMenus, expectedSidebarMenus, "The sidebar menu names do not match or are misspelled!");

    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

