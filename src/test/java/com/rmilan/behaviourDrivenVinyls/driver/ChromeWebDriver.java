package com.rmilan.behaviourDrivenVinyls.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
