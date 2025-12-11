package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DriverInitializer {
    public static WebDriver initChrome() {
        return initDriver(BrowserType.CHROME_SELMGR);
    }

    public static WebDriver initFirefox() {
        return initDriver(BrowserType.FIREFOX_SELMGR);
    }

    public static WebDriver initEdge() {
        return initDriver(BrowserType.EDGE_SELMGR);
    }

    public static WebDriver initChromeDesktop() {
        return initDriver(BrowserType.CHROME_DESKTOP);
    }

    public static WebDriver initChromeNexus() {
        return initDriver(BrowserType.CHROME_NEXUS);
    }

    private static WebDriver initDriver(BrowserType browserType) {
        ChromeOptions chromeOptions = new ChromeOptions();
        switch (browserType) {
            case CHROME_SELMGR -> {
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
                chromeOptions.setExperimentalOption("useAutomationExtension", false);

                return new ChromeDriver(chromeOptions);
            }
            case FIREFOX_SELMGR -> {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--private");
                options.addArguments("--disable-blink-features=AutomationControlled");
                options.addArguments("--disable-infobars");
                options.addArguments("--start-maximized");

                return new FirefoxDriver(options);
            }
            case EDGE_SELMGR -> {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--inprivate");
                options.addArguments("--disable-blink-features=AutomationControlled");
                options.addArguments("--disable-infobars");
                options.addArguments("--start-maximized");

                return new EdgeDriver(options);
            }
            case CHROME_DESKTOP -> {
                chromeOptions.addArguments("window-size=1024,800");
                return new ChromeDriver(chromeOptions);
            }
            case CHROME_NEXUS -> {
                Map<String,String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Nexus 5");

                ChromeOptions mobileOptions = new ChromeOptions();
                mobileOptions.addArguments("window-size=360,640");
                mobileOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

                return new ChromeDriver(mobileOptions);
            }
            default -> throw new IllegalArgumentException("Invalid browser type");
        }
    }
}
