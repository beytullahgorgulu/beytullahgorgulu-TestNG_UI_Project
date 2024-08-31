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

import java.time.Duration;

public class Test01 extends Report {

    TedEx tedEx = new TedEx();
    String expectedResult;
    String actualResult;

    @Test
    public void TedEx() {

        extentTest = extentReports.createTest("Functional Test", "TedEx Test");

        extentTest.info("Open the TedEx site via (https://ed.ted.com/).");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        extentTest.info("If a cookie notification appears, decline the cookies.");
        ReusableMethods.waitForElementToBeVisible(tedEx.rejectCookies);
        tedEx.rejectCookies.click();

        extentTest.info("Click the \"Students Start Here\" button to navigate to the student start page.");
        ReusableMethods.waitForElementToBeVisible(tedEx.studentsStartHere);
        tedEx.studentsStartHere.click();

        extentTest.info("Click the sorting menu.");
        ReusableMethods.waitForElementToBeVisible(tedEx.sorting);
        tedEx.sorting.click();

        extentTest.info("Sort the videos by selecting the \"shortest video\" option from the sorting menu.");
        ReusableMethods.waitForElementToBeVisible(tedEx.sortByShortestVideo);
        tedEx.sortByShortestVideo.click();

        extentTest.info("Click and open the first video in the list after sorting by shortest video.");
        ReusableMethods.waitForElementToBeVisible(tedEx.firstShortestVideo);
        tedEx.firstShortestVideo.click();

        if (!tedEx.textOnPage.isDisplayed()) {
            extentTest.info("Scroll down the page on the opened video page, if necessary.");
            Actions action = new Actions(Driver.getDriver());
            action.sendKeys(Keys.PAGE_DOWN).perform();
        }

        extentTest.pass("Check and verify if the page contains the text \"Berkelium.\n");
        expectedResult = "Berkelium";
        actualResult = tedEx.textOnPage.getText();
        ReusableMethods.waitForElementToBeVisible(tedEx.textOnPage);
        Assert.assertTrue(actualResult.contains(expectedResult), "The requested page could not be found");

        Driver.closeDriver();
    }

}
