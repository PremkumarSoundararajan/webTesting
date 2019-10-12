import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends PageObject {

    private Logger logger = Logger.getLogger(HomePage.class);

    @FindBy (id="search_query_top")
    private WebElement searchBox;

    @FindBy (className = "login")
    private WebElement signInButton;

    @FindBy (id = "block_top_menu")
    private WebElement menuBar;

    @FindBy(name="submit_search")
    private WebElement submitButton;

    public HomePage(WebDriver driver) {
        super(driver);
        Assert.assertTrue(searchBox.isDisplayed());
        Assert.assertTrue(signInButton.isDisplayed());
        Assert.assertTrue(menuBar.isDisplayed());
    }

    public searchResultPage enterSearch(String searchString){
        logger.info("search string : " +searchString);
        searchBox.sendKeys(searchString);
        submitButton.click();
        return new searchResultPage(driver);
    }
}
