import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductPage extends PageObject {
    @FindBy(name = "Submit")
    private WebElement addToCartButton;

    @FindBy(className = "icon-plus")
    private WebElement incrementQuantityButton;

    @FindBy(xpath = "//*[@id='group_1']")
    private WebElement selectSizeDropdown;

    @FindBy(className = "layer_cart_overlay")
    private WebElement cartOverlayScreen;

    @FindBy(xpath =  "//*[contains(text(),'Proceed to checkout')]")
    private WebElement checkoutButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        Assert.assertTrue(addToCartButton.isDisplayed());
    }

    public void incrementQuantityByOne(){
        incrementQuantityButton.click();
    }

    public void selectSize(String ch){
        Select dropdown = new Select(selectSizeDropdown);
        dropdown.selectByVisibleText(ch);
    }

    public void addToCart(){
        addToCartButton.click();
    }

    public boolean verifyProductInCart(){
        return driver.getPageSource().contains("Product successfully added to your shopping cart");
    }

    public CheckOutPage checkout(){
        checkoutButton.click();
        return new CheckOutPage(driver);
    }
}
