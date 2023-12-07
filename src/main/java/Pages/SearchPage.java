package Pages;

import Base.BaseLib;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchPage extends BaseLib {


    public SearchPage(WebDriver driver,WebDriverWait wait){
        this.driver =  driver;
        this.wait=wait;
    }

    @Step("Check Filter Form")
    public FilterForm goToFilterForm(){

        waitForElementAppear(filterBtn);
        click(filterBtn);
        return  new FilterForm(driver,wait);

    }

    By filterBtn = By.xpath("//span[text()='Filter']/parent::button");


}
