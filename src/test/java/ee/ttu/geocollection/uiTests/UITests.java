package ee.ttu.geocollection.uiTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UITests {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new PhantomJSDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        baseUrl = "http://geocollections.arendus.geokogud.info";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
    }

    @Test
    public void testAboutCollectionsContentLoaded() throws Exception {
        open(baseUrl);
        $("#langEn").should(exist);
        $("#langEn").click();
        $(By.linkText("USEFUL INFO")).click();
        $(By.linkText("About collections")).click();
        $("#geocollections").shouldHave(text("About geological"));
    }

    @Test
    public void testAboutDatabaseContentLoaded() throws Exception {
        open(baseUrl);
        $("#langEn").should(exist);
        $("#langEn").click();
        $(By.linkText("USEFUL INFO")).click();
        $(By.linkText("Database")).click();
        $("#database").shouldHave(text("database for geocollections"));
    }

    @Test
    public void testChangeLanguage() throws Exception {
        open(baseUrl);
        $("#langEt").should(exist);
        $("#langEt").click();
        $(".navbar-brand").shouldHave(text("eesti"));
        $("#langEn").click();
        $(".navbar-brand").shouldHave(text("estonia"));
    }

    @Test
    public void testChooseSearchType() throws Exception {
        open(baseUrl);
        $("#langEn").should(exist);
        $("#langEn").click();
        $(By.linkText("SEARCH")).click();
        $(".nav-tabs").should(exist);

        // TODO use Selenide
        ArrayList<WebElement> tabElements = (ArrayList<WebElement>) driver
                .findElements(By.cssSelector(".nav-tabs li a"));

        ArrayList<String> tabNames = new ArrayList<String>();

        for (WebElement webElement : tabElements) {
            tabNames.add(webElement.getText());
        }

        for (String curTabName : tabNames) {
            driver.findElement(By.linkText(curTabName)).click();

            for (int second = 0;; second++) {
                if (second >= 5)
                    fail("timeout");
                try {
                    if (driver.findElement(By.className("search-heading")).getText()
                            .matches("[\\s\\S]*" + curTabName + "[\\s\\S]*")) {
                        break;
                    }
                } catch (Exception e) {
                }
                Thread.sleep(1000);
            }
        }
    }

    @Test
    public void testFooterLoadedOnExtendedSearchPage() throws Exception {
        open(baseUrl);
        $("#langEn").should(exist);
        $("#langEn").click();
        $(By.linkText("SEARCH")).click();
        $("footer").should(exist);
    }

    @Test
    public void testFooterLoadedOnMainPage() throws Exception {
        open(baseUrl);
        $("footer").should(exist);
    }

    @Test
    public void testGeneralInfoLoaded() throws Exception {
        open(baseUrl);
        $("#langEn").should(exist);
        $("#langEn").click();
        $("#about").should(exist);
        $("#about").shouldHave(text("Collections in geology"));
        $("#about").shouldHave(text("Geocollections in Estonia"));
        $("#about").shouldHave(text("Common database"));
    }

    @Test
    public void testGitContentLoaded() throws Exception {
        open(baseUrl);
        $("#langEn").should(exist);
        $("#langEn").click();
        $(By.linkText("USEFUL INFO")).click();
        $(By.linkText("GIT")).click();
        $("#git").shouldHave(text("GIT: Geological collections"));
    }

    @Test
    public void testModalWindowIsOpenOnSearchPage() throws Exception {
        open(baseUrl + "/sample");
        $("#langEn").should(exist);
        $("#langEn").click();
        $(By.cssSelector("tr.ng-scope:nth-child(1) > td:nth-child(3) > a:nth-child(1)")).should(exist);
        $(By.cssSelector("tr.ng-scope:nth-child(1) > td:nth-child(3) > a:nth-child(1)")).click();

        // TODO use Selenide
        driver.findElement(By.cssSelector("tr.ng-scope:nth-child(1) > td:nth-child(3) > a:nth-child(1)")).click();
        ArrayList<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        // switch to a new tab
        driver.switchTo().window(browserTabs.get(1));
        try {
            assertTrue(driver.getCurrentUrl().matches("^[\\s\\S]*/sample/[\\d]+$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }

    @Test
    public void testShowMap() throws Exception {
        open(baseUrl);
        $("#langEn").should(exist);
        $("#langEn").click();
        $(By.linkText("MAP")).click();
        $("#map").should(exist);
    }

    @Test
    public void testUsingCollectionsContentLoaded() throws Exception {
        open(baseUrl);
        $("#langEn").should(exist);
        $("#langEn").click();
        $(By.linkText("USEFUL INFO")).click();
        $(By.linkText("Using collections")).click();
        $("#usingCollections").shouldHave(text("Using"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
