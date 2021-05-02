package test.java.MainMethods;

import TestScenarios.Scenario01;
import TestScenarios.Scenario02;
import org.openqa.selenium.WebDriver;

public class TestScenariosMap {
    public Scenario01 scenario01 = new Scenario01();
    public Scenario02 scenario02 = new Scenario02();
    public WebDriver executeTests(String TestName, WebDriver driver) throws InterruptedException {
        if (TestName.equals("Scenario01")) {
            driver = scenario01.testScenario(driver);
        } else if (TestName.equals("Scenario02")) {
            driver = scenario02.testScenario(driver);
        }
        return driver;
    }
}
