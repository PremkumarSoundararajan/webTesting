import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AuthenticationPage extends PageObject {
    @FindBy(className = "navigation_page" )
    public WebElement inAuthenticationPage;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        Assert.assertTrue(inAuthenticationPage.isDisplayed());
    }
}
