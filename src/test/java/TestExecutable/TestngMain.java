package test.java.TestExecutable;

import test.java.MainMethods.TestScenariosMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class TestngMain {
    public WebDriver driver;
    public TestScenariosMap testScenariosMap = new TestScenariosMap();

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"Scenario01"}, {"Scenario02"}};
    }

    @BeforeClass
    public static void setupClass() {
        System.out.println("Running BeforeClass method");
    }

    @BeforeTest
    public void setupTest() {
        System.out.println("Running Before method");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
    }

    @AfterTest
    public void teardown() {
        System.out.println("Running teardown method");
        if (driver != null) {
            driver.quit();
        }
    }

    @Test (dataProvider = "data-provider")
    public void test(String val) throws InterruptedException {
        System.out.println("Passed Parameter Is : " + val);
        testScenariosMap.executeTests(val, driver);
        Thread.sleep(4000);

    }
}

