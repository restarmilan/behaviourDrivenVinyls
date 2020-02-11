package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    final int TIMEOUT = 10;
    WebDriver driver;
    WebDriverWait wait;
    String baseUrl = "https://www.discogs.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, TIMEOUT);
        PageFactory.initElements(factory, this);
    }
}
