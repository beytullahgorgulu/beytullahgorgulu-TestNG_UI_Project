package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TedEx {

    public TedEx() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath ="//*[@class='ot-pc-refuse-all-handler']")
    public WebElement rejectCookies;

    @FindBy(xpath ="//*[@class='tdd-btn tdd-home__btn']")
    public WebElement studentsStartHere;

    @FindBy(xpath = "//*[@id='lessons-filters']/div/div[2]")
    public WebElement sorting;

    @FindBy(xpath = "//*[@id='sortby']/div/ul/li[5]")
    public WebElement sortByShortestVideo;

    @FindBy(xpath = "//*[@id='lessons-grid']//div[1]/article[1]")
    public WebElement firstShortestVideo;

    @FindBy(xpath = "//*[@id='main-content']/article/div[1]/section/p")
    public WebElement textOnPage;
}
