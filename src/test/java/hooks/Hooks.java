package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.DriverInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Getter
    public static WebDriver driver;
    @Getter
    public static WebDriverWait wait;

    @Before(order = 0)
    public void globalSetUp() {
        new java.io.File("target/logs").mkdirs();
        logger.info("Global setup fut...");
        driver = DriverInitializer.initChrome();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        logger.info("Global setup lefutott.");
    }

    @After(order = 0)
    public void globalTearDown() {
        logger.info("Global teardown fut...");
        if (driver != null) {
            driver.quit();
        }
        logger.info("Global teardown lefutott.");
    }
}
