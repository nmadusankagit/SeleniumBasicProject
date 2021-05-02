package TestScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario01 {

    public WebDriver testScenario (WebDriver driver) {
        driver.get("https://www.staysure.co.uk/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id, 'getQuoteBtn')]//a[contains(@href, '/quote/policy-details')]")));
        driver.findElement(By.xpath("//div[contains(@id, 'getQuoteBtn')]//a[contains(@href, '/quote/policy-details')]")).click();
        return driver;
    }
}
