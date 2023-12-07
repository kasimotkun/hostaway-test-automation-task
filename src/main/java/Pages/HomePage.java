package Pages;

import Base.BaseLib;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BaseLib {


    public HomePage(WebDriver driver, WebDriverWait wait){
        this.driver =  driver;
        this.wait=wait;
    }

    @Step("Search Flats and Houses")
    public SearchPage search(){

        waitForElementAppear(searchBtn);
        click(searchBtn);
        return new SearchPage(driver,wait);
    }

    @Step("Go to All Listings Page")
    public AllListingsPage goToAllListingsPage(){
        driver.get(baseUrl+"all-listings");
        return new AllListingsPage(driver,wait);
    }

    By searchBtn = By.xpath("//span[text()='Search']/parent::button");


}
