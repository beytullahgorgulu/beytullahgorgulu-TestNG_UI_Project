package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TedEx;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Report;
import utilities.ReusableMethods;

public class Test01 extends Report {

    TedEx tedEx=new TedEx();
    String expectedResult;
    String actualResult;

    @Test
    public void TedEx() {

        extentTest= extentReports.createTest("Functional Test","TedEx Test");

        extentTest.info("Open the TedEx site via (https://ed.ted.com/).");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        extentTest.info("If a cookie notification appears, decline the cookies.");
        ReusableMethods.wait(2);
        tedEx.rejectCookies.click();

        extentTest.info("Click the \"Students Start Here\" button to navigate to the student start page.");
        ReusableMethods.wait(2);
        tedEx.studentsStartHere.click();

        extentTest.info("Click the sorting menu.");
        ReusableMethods.wait(2);
        tedEx.sorting.click();

        extentTest.info("Sort the videos by selecting the \"shortest video\" option from the sorting menu.");
        ReusableMethods.wait(2);
        tedEx.sortByShortestVideo.click();

        extentTest.info("Click and open the first video in the list after sorting by shortest video.");
        ReusableMethods.wait(3);
        tedEx.firstShortestVideo.click();

        //extentTest.info("Scroll down the page on the opened video page, if necessary.");
        //ReusableMethods.wait(2);
        //Actions action=new Actions(Driver.getDriver());
        //action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.wait(4);

        extentTest.pass("Check and verify if the page contains the text \"Berkelium.\n");
        expectedResult="Berkelium";
        actualResult=tedEx.textOnPage.getText();
        ReusableMethods.wait(4);
        Assert.assertTrue(actualResult.contains(expectedResult),"The requested page could not be found");

        Driver.closeDriver();
    }

}
