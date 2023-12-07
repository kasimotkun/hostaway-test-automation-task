package Base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BaseLib {

    public WebDriverWait wait;
    public static WebDriver driver;
    public  SoftAssert softAssert = new SoftAssert();
    public String baseUrl="https://kamil-demo.alpinizm.uz/";

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
    public void waitForElementAppear(By element){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));

    }
    public void waitForElementDisAppear(By element){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

    }

    public void waitImplicitly(int timeoutMillis){
        try {
            Thread.sleep(timeoutMillis);
        }
        catch (InterruptedException ignored){}
    }
    public void click(By element){
        driver.findElement(element).click();
        waitImplicitly(100);
    }

    public void enterTxt(By element, String text){
        driver.findElement(element).sendKeys(text);

    }

    public boolean getElementIsDisplayedStatus(By element){
        return driver.findElement(element).isDisplayed();

    }
    public boolean getElementIsClickableStatus(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return driver.findElement(element).isDisplayed();

    }

    public boolean getElementIsCheckedStatus(By element){
        return driver.findElement(element).findElement(By.xpath("input")).isSelected();

    }

    public String getElementTxt(By element){
        return driver.findElement(element).getText();

    }

    public String getElementAttributeTxt(By element, String attributeName){
        return driver.findElement(element).getAttribute(attributeName);

    }

    public int getElementsSize(By element){
        return driver.findElements(element).size();

    }

    public void scrollDownByVisibleElement(By elementVisible) {


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(elementVisible));

    }


}
