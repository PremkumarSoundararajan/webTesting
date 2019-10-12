import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckOutPage extends PageObject {
    @FindBy(xpath = "//a[contains(@class, 'standard-checkout')]")
    private WebElement checkoutAgain;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        Assert.assertTrue(driver.getPageSource().contains("Your shopping cart contains"));
    }

    public boolean isProductInCart(String productName){
        return driver.getPageSource().contains(productName);
    }

    public AuthenticationPage checkoutAgain(){
        checkoutAgain.click();
        return new AuthenticationPage(driver);
    }
}
