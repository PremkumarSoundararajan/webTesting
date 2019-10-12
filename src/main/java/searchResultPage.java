import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class searchResultPage extends PageObject {
    @FindBy (xpath = "//a[@class='product-name']")
    private WebElement listedProduct1;

    public searchResultPage(WebDriver driver) {
        super(driver);
        boolean textFound = false;
        textFound = verifyTextPresent("results have been found", driver);
        if (textFound == false)
            textFound = verifyTextPresent("result has been found", driver);
        Assert.assertEquals(textFound, true);
    }

    public ProductPage clickFirstProduct(){
        listedProduct1.click();
        return new ProductPage(driver);
    }

    public boolean searchReturnedResults(){
        if (verifyTextPresent("0 results have been found", driver))
            return false;
        else
            return true;
    }
}
