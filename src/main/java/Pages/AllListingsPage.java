package Pages;

import Base.BaseLib;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

public class AllListingsPage extends BaseLib {


    public AllListingsPage(WebDriver driver, WebDriverWait wait){
        this.driver =  driver;
        this.wait=wait;
    }


    @Step("Check All Listings has the same amount of listings as the 'All' label")
    public void checkAllListingsCount(){

        waitForElementAppear(numberOfAllLblItemsTxt);
        int allLblCount = Integer.parseInt(getElementTxt(numberOfAllLblItemsTxt).replaceAll("[^0-9]", ""));
        waitImplicitly(5000);
        scrollDownRecursively();
        Allure.addAttachment("Check All Listings("+getElementsSize(numberOfItemsInTheListingsLnk)+") has the same amount of listings as the 'All("+allLblCount+")' label","");
        Assert.assertEquals(getElementsSize(numberOfItemsInTheListingsLnk),allLblCount);


    }
    public void scrollDownRecursively() {


        int currentItemsCount = getElementsSize(numberOfItemsInTheListingsLnk);
        int newItemsCount=0;
        while (currentItemsCount!=newItemsCount){
           scrollDownByVisibleElement(bottonElement);
           waitImplicitly(5000);
           currentItemsCount=newItemsCount;
           newItemsCount =getElementsSize(numberOfItemsInTheListingsLnk);
           if(currentItemsCount==newItemsCount)
             break;
        }
    }

    By bottonElement = By.xpath("//a[contains(@href,'https://x.com/meta')]");
    By numberOfAllLblItemsTxt = By.xpath("//span[text()='All']/span");
    By numberOfItemsInTheListingsLnk = By.xpath("//a[contains(@href,'/listings/')]");

}
