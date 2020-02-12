package behaviourDrivenVinyls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseStepDefs {

    WebDriver driver;
    String chromeDriverPath;

    public BaseStepDefs(){
        this.chromeDriverPath = "/home/rmilan/codecool/test_automation/4si/jiracucumber/src/test/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        this.driver = new ChromeDriver();
    }




}
