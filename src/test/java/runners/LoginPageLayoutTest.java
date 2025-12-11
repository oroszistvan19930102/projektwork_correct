package runners;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.reports.nodes.TestReportNode;
import driver.DriverInitializer;
import driver.Settings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.actions.LoginPageActions;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LoginPageLayoutTest {
    private static final String[] MOBILE_TAGS = {"mobile"};
    private static final String[] DESKTOP_TAGS = {"desktop"};

    private LayoutReport layoutReport;

    @Test
    @DisplayName("TC1 - SauceDemo Product page layout check for mobile")
    public void testForMobile() throws IOException {
        WebDriver driver = DriverInitializer.initChromeNexus();
        driver.manage().window().setPosition(new Point(800, 100));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get(Settings.getLoginUrl());

        LoginPageActions loginPageActions = new LoginPageActions(driver, wait);
        loginPageActions.fullLoginProcess();

        WebElement title = wait.until(d -> d.findElement(By.id("page-title")));
        assertTrue(title.isDisplayed(), "A dashboard nem töltődött be");

        // Galen layout ellenőrzés
        layoutReport = Galen.checkLayout(driver, "src/test/resources/gspecs/dashboardLayout.gspec", Arrays.asList(MOBILE_TAGS));

        // Riport generálása

        final String REPORT_PATH = "target/galen-html-reports";
        List<GalenTestInfo> tests = new LinkedList<>();
        GalenTestInfo test = GalenTestInfo.fromString("Digital Bank mobil layout ellenőrzés");
        test.getReport().layout(layoutReport, "Layout check – mobile");
        tests.add(test);

        new HtmlReportBuilder().build(tests, REPORT_PATH);

        // Ha bármelyik sazbályunk nem teljesül, akkor bukjon el a tesztünk

        for (GalenTestInfo i : tests) {
            for (TestReportNode n : i.getReport().getNodes()) {
                if (n.getStatus() == TestReportNode.Status.ERROR) {
                    fail("Teszt sikertelen");
                }
            }
        }

        driver.quit();
    }

    @Test
    @DisplayName("TC2 - SauceDemo Product page layout check for desktop")
    public void testForDesktop() throws IOException {
        WebDriver driver = DriverInitializer.initChromeDesktop();
        driver.manage().window().setPosition(new Point(800, 100));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get(Settings.getLoginUrl());

        LoginPageActions loginPageActions = new LoginPageActions(driver, wait);
        loginPageActions.fullLoginProcess();

        WebElement title = wait.until(d -> d.findElement(By.id("page-title")));
        assertTrue(title.isDisplayed(), "A dashboard nem töltődött be");

        // Galen layout ellenőrzés
        layoutReport = Galen.checkLayout(driver, "src/test/resources/gspecs/dashboardLayout.gspec", Arrays.asList(DESKTOP_TAGS));

        // Riport generálása

        final String REPORT_PATH = "target/galen-html-reports";
        List<GalenTestInfo> tests = new LinkedList<>();
        GalenTestInfo test = GalenTestInfo.fromString("Digital Bank desktop layout ellenőrzés");
        test.getReport().layout(layoutReport, "Layout check – desktop");
        tests.add(test);

        new HtmlReportBuilder().build(tests, REPORT_PATH);

        // Ha bármelyik sazbályunk nem teljesül, akkor bukjon el a tesztünk

        for (GalenTestInfo i : tests) {
            for (TestReportNode n : i.getReport().getNodes()) {
                if (n.getStatus() == TestReportNode.Status.ERROR) {
                    fail("Teszt sikertelen");
                }
            }
        }

        driver.quit();
    }
}
