package steps.layoutsteps;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.reports.nodes.TestReportNode;
import driver.DriverInitializer;
import driver.Settings;
import hooks.Hooks;
import lombok.Getter;
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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginPageLayoutTest {

    @Getter
    public WebDriver driver = Hooks.driver;
    public WebDriverWait wait = Hooks.wait;
    public LoginPageActions loginPageActions;

    private static final String[] MOBILE_TAGS = {"mobile"};
    private static final String[] DESKTOP_TAGS = {"desktop"};

    private LayoutReport layoutReport;

    @Test
    @DisplayName("TC1 - SauceDemo Product page layout check for mobile")
    public void testForMobile() throws IOException {
        driver = DriverInitializer.initChromeNexus();
        driver.manage().window().setPosition(new Point(1600, 100));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get(Settings.getLoginUrl());

        loginPageActions = new LoginPageActions(this.driver, this.wait);
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
    }

    @Test
    @DisplayName("TC2 - SauceDemo Product page layout check for desktop")
    public void testForDesktop() throws IOException {
        driver = DriverInitializer.initChromeDesktop();
        driver.manage().window().setPosition(new Point(1600, 100));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get(Settings.getLoginUrl());

        WebElement userField = wait.until(d -> d.findElement(By.id("user-name")));
        userField.clear();
        userField.sendKeys("standard_user");

        WebElement passField = wait.until(d -> d.findElement(By.id("password")));
        passField.clear();
        passField.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        WebElement element = wait.until(d -> d.findElement(By.cssSelector(".title")));
        assertEquals("Products", element.getText());

        // Galen layout ellenőrzés
        layoutReport = Galen.checkLayout(driver, "src/test/resources/gspecs/productsLayout.gspec", Arrays.asList(DESKTOP_TAGS));

        // Riport generálása

        final String REPORT_PATH = "target/galen-html-reports";
        List<GalenTestInfo> tests = new LinkedList<>();
        GalenTestInfo test = GalenTestInfo.fromString("SauceDemo terméklistázó ellenőrzése");
        test.getReport().layout(layoutReport, "Terméklistázó layout ellenőrzése");
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
    }
}
