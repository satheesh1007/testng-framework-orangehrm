import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OrangeHRMPage {

    WebDriver driver;

    // Constructor that will be automatically called as soon as the object of the class is created
    public OrangeHRMPage(WebDriver driver) {
        this.driver = driver;
    }
    By Username = By.xpath("//input[@placeholder='Username']");

    By Password = By.xpath("//input[@placeholder='Password']");

    By Login = By.xpath("//button[normalize-space()='Login']");

     By adminMenu = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    // Locator for search box
    By searchBox = By.xpath("//input[@class='oxd-input oxd-input--active']");

    // Locator for search button
    By searchButton = By.xpath("//button[normalize-space()='Search']");

    // Locator for search results table
    By searchResultsTable = By.id("searchResultsTable");

    // Locator for search result rows
    By searchResultRows = By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']");

    // Method to enter search data

    public void enterUsername(String UserName){
        driver.findElement(Username).sendKeys(UserName);
    }
    public void enterPassword(String Password1){
        driver.findElement(Password).sendKeys(Password1);
    }
    public void setLogin(){
        driver.findElement(Login).click();
    }

    public void setAdminMenu(){
        driver.findElement(adminMenu).click();
    }

    public void enterSearchData(String searchData) {
        driver.findElement(searchBox).sendKeys(searchData);
    }

    // Method to click search button
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    // Method to get search results
    public List<WebElement> getSearchResults() {
        return driver.findElements(searchResultRows);
    }

    // Method to get search result data
    public List<String> getSearchResultData() {
        List<WebElement> searchResults = getSearchResults();
        List<String> searchData = new ArrayList<>();
        for (WebElement result : searchResults) {
            searchData.add(result.getText());
        }
        return searchData;
    }
}
