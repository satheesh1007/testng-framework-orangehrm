import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Forgetpasswordtest {
    @Test
    public void forgettest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        ResetPassword reset = new ResetPassword(driver);
        reset.ClickForgetPassword();
        reset.fillUsername("satheesh");
        reset.Clickresetpassword();
        driver.quit();

    }
}
