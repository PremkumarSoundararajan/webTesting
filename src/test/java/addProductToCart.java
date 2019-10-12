import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;

public class addProductToCart extends BaseTest {
    @BeforeClass
    public void loadSite(){
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void addProductToCart(){
       // driver.get("http://automationpractice.com/index.php");
        HomePage homePage = new HomePage(driver);
        searchResultPage searchResultPage = homePage.enterSearch("T-shirts");
        ProductPage productPage = null;
        if (searchResultPage.searchReturnedResults())
            productPage = searchResultPage.clickFirstProduct();
        productPage.incrementQuantityByOne();
        productPage.selectSize("M");
        productPage.addToCart();
        CheckOutPage checkOutPage = null;
        if (productPage.verifyProductInCart())
            checkOutPage = productPage.checkout();
        AuthenticationPage authenticationPage = checkOutPage.checkoutAgain();

    }
}
