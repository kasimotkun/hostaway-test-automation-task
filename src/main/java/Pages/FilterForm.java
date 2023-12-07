package Pages;

import Base.BaseLib;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FilterForm extends BaseLib {


    public FilterForm(WebDriver driver, WebDriverWait wait){
        this.driver =  driver;
        this.wait=wait;
    }

    @Step("Check Filter Form")
    public void checkFilterForm(){
        waitForElementAppear(fromTxt);
        Allure.addAttachment("Check From is visible", String.valueOf(getElementIsDisplayedStatus(fromTxt)));
        softAssert.assertTrue(getElementIsDisplayedStatus(fromTxt),"Check From is visible");
        Allure.addAttachment("Check To is visible", String.valueOf(getElementIsDisplayedStatus(toTxt)));
        softAssert.assertTrue(getElementIsDisplayedStatus(toTxt),"Check To is visible");

        Allure.addAttachment("Check From is editable", String.valueOf(!Boolean.parseBoolean(getElementAttributeTxt(fromTxt, "disabled"))));
        softAssert.assertTrue(!Boolean.parseBoolean(getElementAttributeTxt(fromTxt,"disabled")),"Check From is editable");

        if (!Boolean.parseBoolean(getElementAttributeTxt(fromTxt, "disabled"))){

            enterTxt(fromTxt,"400");
            Allure.addAttachment("Check From text value", getElementTxt(fromTxt));
            softAssert.assertEquals(getElementTxt(fromTxt),"400","Check From text value");
        }
        Allure.addAttachment("Check To is editable",String.valueOf(!Boolean.parseBoolean(getElementAttributeTxt(toTxt, "disabled"))));
        softAssert.assertTrue(!Boolean.parseBoolean(getElementAttributeTxt(toTxt,"disabled")),"Check To is editable");

        if (!Boolean.parseBoolean(getElementAttributeTxt(toTxt, "disabled"))){

            enterTxt(toTxt,"500");
            Allure.addAttachment("Check From text value", getElementTxt(toTxt));
            softAssert.assertEquals(getElementTxt(toTxt),"500","Check From text value");
        }

        for(int i=0; i<10; i++)
            click(bedsAscBtn);
        Allure.addAttachment("Check max number (10) of Beds", getElementTxt(bedsNumberTxt));
        softAssert.assertEquals(getElementTxt(bedsNumberTxt),"10","Check max number (10) of Beds");
        Allure.addAttachment("Beds Asc Button is disabled", getElementAttributeTxt(bedsAscBtn,"disabled"));
        softAssert.assertTrue(Boolean.parseBoolean(getElementAttributeTxt(bedsAscBtn,"disabled")),"Beds Asc Button is disabled");


        click(bedsDescBtn);
        Allure.addAttachment("Check number (10) of Beds is decreased to 9", getElementTxt(bedsNumberTxt));
        softAssert.assertEquals(getElementTxt(bedsNumberTxt),"9","Check number (10) of Beds is decreased to 9");

        for(int i=0; i<10; i++)
            click(bedroomsAscBtn);
        Allure.addAttachment("Check max number (10) of Bedrooms", getElementTxt(bedroomsNumberTxt));
        softAssert.assertEquals(getElementTxt(bedroomsNumberTxt),"10","Check max number (10) of Bedrooms");
        Allure.addAttachment("Bedrooms Asc Button is disabled", getElementAttributeTxt(bedroomsAscBtn,"disabled"));
        softAssert.assertTrue(Boolean.parseBoolean(getElementAttributeTxt(bedroomsAscBtn,"disabled")),"Bedrooms Asc Button is disabled");


        click(bedroomsDescBtn);
        Allure.addAttachment("Check max number (10) of Bedrooms is decreased to 9", getElementTxt(bedroomsNumberTxt),"Check max number (10) of Bedrooms is decreased to 9");
        softAssert.assertEquals(getElementTxt(bedroomsNumberTxt),"9");

        for(int i=0; i<10; i++)
            click(bathroomsAscBtn);
        Allure.addAttachment("Check max number (10) of Bathrooms", getElementTxt(bathroomsNumberTxt));
        softAssert.assertEquals(getElementTxt(bathroomsNumberTxt),"10","Check max number (10) of Bathrooms");
        Allure.addAttachment("Bathrooms Asc Button is disabled", getElementAttributeTxt(bathroomsAscBtn,"disabled"));
        softAssert.assertTrue(Boolean.parseBoolean(getElementAttributeTxt(bathroomsAscBtn,"disabled")),"Bathrooms Asc Button is disabled");



        click(bathroomsDescBtn);
        Allure.addAttachment("Check max number (10) of Bathrooms is decreased to 9", getElementTxt(bathroomsNumberTxt));
        softAssert.assertEquals(getElementTxt(bathroomsNumberTxt),"9","Check max number (10) of Bathrooms is decreased to 9");

        click(chkBeachFront);
        Allure.addAttachment("Check Beach Front is checked",String.valueOf(getElementIsCheckedStatus(chkBeachFront)));
        softAssert.assertTrue(getElementIsCheckedStatus(chkBeachFront),"Check Beach Front is checked");

        click(chkFreeWifi);
        Allure.addAttachment("Check Free Wifi is checked",String.valueOf(getElementIsCheckedStatus(chkFreeWifi)));
        softAssert.assertTrue(getElementIsCheckedStatus(chkFreeWifi),"Check Free Wifi is checked");

        click(chkAirCond);
        Allure.addAttachment("Check Air conditioning is checked",String.valueOf(getElementIsCheckedStatus(chkAirCond)));
        softAssert.assertTrue(getElementIsCheckedStatus(chkAirCond),"Check Air conditioning is checked");

        click(chkPetsAllowed);
        Allure.addAttachment("Check Pets Allowed is checked",String.valueOf(getElementIsCheckedStatus(chkPetsAllowed)));
        softAssert.assertTrue(getElementIsCheckedStatus(chkPetsAllowed),"Check Pets Allowed is checked");

        click(chkStreetPark);
        Allure.addAttachment("Check Street Parking is checked",String.valueOf(getElementIsCheckedStatus(chkStreetPark)));
        softAssert.assertTrue(getElementIsCheckedStatus(chkStreetPark),"Check Street Parking is checked");

        click(chkSwimPool);
        Allure.addAttachment("Check Swimming Pool is checked",String.valueOf(getElementIsCheckedStatus(chkSwimPool)));
        softAssert.assertTrue(getElementIsCheckedStatus(chkSwimPool),"Check Swimming Pool is checked");

        click(chkKitchen);
        Allure.addAttachment("Check Kitchen is checked",String.valueOf(getElementIsCheckedStatus(chkKitchen)));
        softAssert.assertTrue(getElementIsCheckedStatus(chkKitchen),"Check Kitchen is checked");

        click(chkWashMachine);
        Allure.addAttachment("Check Washing Machine is checked",String.valueOf(getElementIsCheckedStatus(chkWashMachine)));
        softAssert.assertTrue(getElementIsCheckedStatus(chkWashMachine),"Check Washing Machine is checked");

        click(chkHotTub);
        Allure.addAttachment("Check Hot Tub is checked",String.valueOf(getElementIsCheckedStatus(chkHotTub)));
        softAssert.assertTrue(getElementIsCheckedStatus(chkHotTub),"Check Hot Tub is checked");

        click(chkSuitForChild);
        Allure.addAttachment("Check Suitable For Children is checked",String.valueOf(getElementIsCheckedStatus(chkSuitForChild)));
        softAssert.assertTrue(getElementIsCheckedStatus(chkSuitForChild),"Check Suitable For Children is checked");

        Allure.addAttachment("Click Clear All Button","");
        click(clearAllBtn);

        Allure.addAttachment("Check From text value is empty", getElementTxt(fromTxt));
        softAssert.assertEquals(getElementTxt(fromTxt),"","Check From text value is empty");

        Allure.addAttachment("Check To text value is empty", getElementTxt(toTxt));
        softAssert.assertEquals(getElementTxt(toTxt),"","Check To text value is empty");

        Allure.addAttachment("Check number of Beds is 0", getElementTxt(bedsNumberTxt));
        softAssert.assertEquals(getElementTxt(bedsNumberTxt),"0","Check number of Beds is 0");
        Allure.addAttachment("Beds Desc Button is disabled", getElementAttributeTxt(bedsDescBtn,"disabled"));
        softAssert.assertTrue(Boolean.parseBoolean(getElementAttributeTxt(bedsDescBtn,"disabled")),"Beds Desc Button is disabled");


        Allure.addAttachment("Check number of Bedrooms is 0", getElementTxt(bedroomsNumberTxt));
        softAssert.assertEquals(getElementTxt(bedroomsNumberTxt),"0","Check number of Bedrooms is 0");
        Allure.addAttachment("Bedrooms Desc Button is disabled", getElementAttributeTxt(bedroomsDescBtn,"disabled"));
        softAssert.assertTrue(Boolean.parseBoolean(getElementAttributeTxt(bedroomsDescBtn,"disabled")),"Bedrooms Desc Button is disabled");


        Allure.addAttachment("Check number of Bathrooms is 0", getElementTxt(bathroomsNumberTxt));
        softAssert.assertEquals(getElementTxt(bathroomsNumberTxt),"0","Check number of Bathrooms is 0");
        Allure.addAttachment("Bathrooms Desc Button is disabled", getElementAttributeTxt(bathroomsDescBtn,"disabled"));
        softAssert.assertTrue(Boolean.parseBoolean(getElementAttributeTxt(bathroomsDescBtn,"disabled")),"Bathrooms Desc Button is disabled");

        Allure.addAttachment("Check Beach Front is NOT checked (expected False Value)",String.valueOf(getElementIsCheckedStatus(chkBeachFront)));
        softAssert.assertFalse(getElementIsCheckedStatus(chkBeachFront),"Check Beach Front is NOT checked (expected False Value)");

        Allure.addAttachment("Check Free Wifi is NOT checked (expected False Value)",String.valueOf(getElementIsCheckedStatus(chkFreeWifi)));
        softAssert.assertFalse(getElementIsCheckedStatus(chkFreeWifi),"Check Free Wifi is NOT checked (expected False Value)");

        Allure.addAttachment("Check Air conditioning is NOT checked (expected False Value)",String.valueOf(getElementIsCheckedStatus(chkAirCond)));
        softAssert.assertFalse(getElementIsCheckedStatus(chkAirCond),"Check Air conditioning is NOT checked (expected False Value)");

        Allure.addAttachment("Check Pets Allowed is NOT checked (expected False Value)",String.valueOf(getElementIsCheckedStatus(chkPetsAllowed)));
        softAssert.assertFalse(getElementIsCheckedStatus(chkPetsAllowed),"Check Pets Allowed is NOT checked (expected False Value)");

        Allure.addAttachment("Check Street Parking is NOT checked (expected False Value)",String.valueOf(getElementIsCheckedStatus(chkStreetPark)));
        softAssert.assertFalse(getElementIsCheckedStatus(chkStreetPark),"Check Street Parking is NOT checked (expected False Value)");

        Allure.addAttachment("Check Swimming Pool is NOT checked (expected False Value)",String.valueOf(getElementIsCheckedStatus(chkStreetPark)));
        softAssert.assertFalse(getElementIsCheckedStatus(chkStreetPark),"Check Swimming Pool is NOT checked (expected False Value)");

        Allure.addAttachment("Check Kitchen is NOT checked (expected False Value)",String.valueOf(getElementIsCheckedStatus(chkKitchen)));
        softAssert.assertFalse(getElementIsCheckedStatus(chkKitchen),"Check Kitchen is NOT checked (expected False Value)");

        Allure.addAttachment("Check Washing Machine is NOT checked (expected False Value)",String.valueOf(getElementIsCheckedStatus(chkWashMachine)));
        softAssert.assertFalse(getElementIsCheckedStatus(chkWashMachine),"Check Washing Machine is NOT checked (expected False Value)");

        Allure.addAttachment("Check Hot Tub is NOT checked (expected False Value)",String.valueOf(getElementIsCheckedStatus(chkHotTub)));
        softAssert.assertFalse(getElementIsCheckedStatus(chkHotTub),"Check Hot Tub is NOT checked (expected False Value)");

        Allure.addAttachment("Check Suitable For Children is NOT checked (expected False Value)",String.valueOf(getElementIsCheckedStatus(chkSuitForChild)));
        softAssert.assertFalse(getElementIsCheckedStatus(chkSuitForChild),"Check Suitable For Children is NOT checked (expected False Value)");

        Allure.addAttachment("Check Apply button is clickable", String.valueOf(getElementIsClickableStatus(applyBtn)));
        softAssert.assertTrue(getElementIsClickableStatus(applyBtn),"Apply button is NOT clickable");

        softAssert.assertAll();

    }


    By fromTxt = By.cssSelector("input[placeholder='From'");
    By toTxt = By.cssSelector("input[placeholder='To'");
    By bedsDescBtn = By.xpath("//div[text()='Beds']/following-sibling::div/div/button[1]");
    By bedsAscBtn = By.xpath("//div[text()='Beds']/following-sibling::div/div/button[2]");
    By bedsNumberTxt= By.xpath("//div[text()='Beds']/following-sibling::div/div/span");
    By bedroomsDescBtn = By.xpath("//div[text()='Bedrooms']/following-sibling::div/div/button[1]");
    By bedroomsAscBtn = By.xpath("//div[text()='Bedrooms']/following-sibling::div/div/button[2]");
    By bedroomsNumberTxt= By.xpath("//div[text()='Bedrooms']/following-sibling::div/div/span");
    By bathroomsDescBtn = By.xpath("//div[text()='Bathrooms']/following-sibling::div/div/button[1]");
    By bathroomsAscBtn = By.xpath("//div[text()='Bathrooms']/following-sibling::div/div/button[2]");
    By bathroomsNumberTxt= By.xpath("//div[text()='Bathrooms']/following-sibling::div/div/span");
    By chkBeachFront= By.xpath("//span[text()='Beach front']/parent::label");
    By chkFreeWifi= By.xpath("//span[text()='Free WiFi']/parent::label");
    By chkAirCond= By.xpath("//span[text()='Air conditioning']/parent::label");

    By chkPetsAllowed= By.xpath("//span[text()='Pets allowed']/parent::label");
    By chkStreetPark= By.xpath("//span[text()='Street parking']/parent::label");
    By chkSwimPool= By.xpath("//span[text()='Swimming pool']/parent::label");
    By chkKitchen= By.xpath("//span[text()='Kitchen']/parent::label");
    By chkWashMachine= By.xpath("//span[text()='Washing Machine']/parent::label");
    By chkHotTub= By.xpath("//span[text()='Hot tub']/parent::label");
    By chkSuitForChild= By.xpath("//span[text()='Suitable for children']/parent::label");

    By clearAllBtn = By.xpath("//b[text()='Clear all']");
    By applyBtn = By.xpath("//span[text()='Apply']/parent::button");
}
