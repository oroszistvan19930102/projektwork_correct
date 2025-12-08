package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.DriverInitializer;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before(order = 0)
    public void globalSetUp() {
        System.out.println("Global setup fut...");
        driver = DriverInitializer.initChrome();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        System.out.println("Global setup lefutott.");
    }

    @After(order = 0)
    public void globalTearDown() {
        System.out.println("Global teardown fut...");
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Global teardown lefutott.");
    }
}
