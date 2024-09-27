import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPassword {
    WebDriver ldriver;

    public static final By Forgetpassword = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");

    public static final By Username = By.xpath("//input[@placeholder='Username']");

    public static final By Reset = By.xpath("//button[normalize-space()='Reset Password']");

    public ResetPassword(WebDriver rdriver){
        ldriver = rdriver;
    }
    public void ClickForgetPassword(){
     ldriver.findElement(Forgetpassword) .click();
    }
    public void fillUsername(String username){
        ldriver.findElement(Username).clear();
        ldriver.findElement(Username).sendKeys(username);
    }
    public void Clickresetpassword(){
        ldriver.findElement(Reset).click();
    }

}
