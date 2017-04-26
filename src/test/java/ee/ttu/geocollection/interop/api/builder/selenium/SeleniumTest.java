package ee.ttu.geocollection.interop.api.builder.selenium;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://geocollections.arendus.geokogud.info/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testNg() throws Exception {
        driver.get("http://geocollections.arendus.geokogud.info/");
        driver.findElement(By.xpath("//div[@id='infoCarousel']/a/span")).click();
    }
}
