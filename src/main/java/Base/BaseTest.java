package Base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest extends BaseLib{


    public HomePage homePage;


    @BeforeMethod
    public void setUp(ITestContext context) {
        String browser = System.getProperty("browser");
        String osName = System.getProperty("os.name");

        if (browser== null) {browser="Chrome";}

        System.out.println(browser);
        if (browser.equals("Chrome")) {
            if (osName.equals("Mac OS X")) {
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            }
            ChromeOptions co = new ChromeOptions();
            co.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(co);
        }
        else {
            if (osName.equals("Mac OS X")) {
                System.setProperty("webdriver.chrome.driver", "driver/geckodriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "driver/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        }

        wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get(baseUrl);
        driver.manage().window().maximize();
        homePage=new HomePage(driver,wait);



    }

    @AfterMethod
    protected void afterMethod(ITestResult result, ITestContext testContext) {
        if (result.getStatus() == ITestResult.FAILURE) {
            attachScreenshot(driver);
        } else {
            //do something else for success
        }
        driver.quit();
    }






}
