package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CookieHandlerPage extends Page {

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement acceptCookiesButton;
    @FindBy(xpath = "//div[@class='onetrust-pc-dark-filter fade-in']")
    WebElement cookieHandler;

    public CookieHandlerPage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
        acceptCookiesButton.click();
        wait.until(ExpectedConditions.invisibilityOf(cookieHandler));
    }
}
