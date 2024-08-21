package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TedEx;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Test01 {

    TedEx tedEx=new TedEx();
    String expectedResult;
    String actualResult;

    @Test
    public void TedEx(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        ReusableMethods.wait(2);
        tedEx.rejectCookies.click();
        ReusableMethods.wait(2);
        tedEx.studentsStartHere.click();
        ReusableMethods.wait(2);
        tedEx.sorting.click();
        ReusableMethods.wait(2);
        tedEx.sortByShortestVideo.click();
        ReusableMethods.wait(3);
        tedEx.firstShortestVideo.click();
        ReusableMethods.wait(2);
        Actions action=new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(4);
        expectedResult="Berkelium";
        actualResult=tedEx.textOnPage.getText();
        ReusableMethods.wait(4);
        Assert.assertTrue(actualResult.contains(expectedResult),"The requested page could not be found");
    }

}
