package com.rmilan.behaviourDrivenVinyls.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ChromeWebDriver {

    @Bean(name = "webdriver", destroyMethod = "quit")
    @Scope("cucumber-glue")
    public WebDriver getDriver() {
        String chromeDriverPath = "/home/rmilan/codecool/test_automation/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");
        chromeOptions.addArguments("window-size=1400,2100");
        WebDriver driver = new ChromeDriver(chromeOptions);
        return driver;
    }
}
