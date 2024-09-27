import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OrangeHRMTest {

    WebDriver driver;
    @DataProvider(name = "username")
    public Object[][] searchData () {
        return new Object[][]{
                {"Admin"},
                {"satheesh"},
                {"umer104"}
        };
    }
    @Test(dataProvider = "username")
    public void SearchTest(String username) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        OrangeHRMPage orangeHRMPage = new OrangeHRMPage(driver);
        orangeHRMPage.enterUsername("Admin");
        orangeHRMPage.enterPassword("admin123");
        orangeHRMPage.setLogin();
        orangeHRMPage.setAdminMenu();
        orangeHRMPage.enterSearchData(username);
        orangeHRMPage.clickSearchButton();
        List<String> searchResult = orangeHRMPage.getSearchResultData();

        List<String> topResult = searchResult.subList(0, Math.min(3, searchResult.size()));
        System.out.println("Search result for " + ":"+topResult);
    }




//        @Test(dataProvider = "searchData")
//        public void searchAndRetrieveData (String searchData){
//            OrangeHRMPage orangeHRMPage = new OrangeHRMPage(driver);
//            orangeHRMPage.enterSearchData(searchData);
//            orangeHRMPage.clickSearchButton();
//            List<String> searchResults = orangeHRMPage.getSearchResultData();
//            // Retrieve the first two or three search results
//            List<String> topResults = searchResults.subList(0, Math.min(3, searchResults.size()));
//            System.out.println("Search results for " + searchData + ": " + topResults);
//        }
    }
