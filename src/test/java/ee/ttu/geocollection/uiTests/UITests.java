package ee.ttu.geocollection.uiTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.nio.file.Paths;
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
		String phantomJsPath = System.getenv().get("PHANTOMJS-PATH");
		System.err.println("Phantomjs path variable: " + phantomJsPath);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomJsPath);
		System.err.println("Current directory: " + Paths.get(".").toAbsolutePath().normalize().toString());
		driver = new PhantomJSDriver(caps);
		driver.manage().window().setSize(new Dimension(1920, 1080));
		baseUrl = "http://geocollections.arendus.geokogud.info";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testAboutCollectionsContentLoaded() throws Exception {
		driver.get(baseUrl + "/");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("langEn")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("langEn")).click();
		driver.findElement(By.linkText("USEFUL INFO")).click();
		driver.findElement(By.linkText("About collections")).click();
		try {
			assertTrue(driver.findElement(By.id("geocollections")).getText()
					.matches("^[\\s\\S]*About geological[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@Ignore
	@Test
	public void testAboutDatabaseContentLoaded() throws Exception {
		driver.get(baseUrl + "/");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("langEn")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("langEn")).click();
		driver.findElement(By.linkText("USEFUL INFO")).click();
		driver.findElement(By.linkText("Database")).click();
		try {
			assertTrue(driver.findElement(By.id("database")).getText()
					.matches("(?i:[\\s\\S]*database for geocollections[\\s\\S]*)"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@Ignore
	@Test
	public void testChangeLanguage() throws Exception {
		driver.get(baseUrl + "/");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("langEt")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("langEt")).click();
		try {
			assertTrue(driver.findElement(By.className("navbar-brand")).getText().matches("(?i:.*eesti.*)"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.id("langEn")).click();
		try {
			assertTrue(driver.findElement(By.className("navbar-brand")).getText().matches("(?i:.*estonia.*)"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@Ignore
	@Test
	public void testChooseSearchType() throws Exception {
		driver.get(baseUrl + "/");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("langEn")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("langEn")).click();
		driver.findElement(By.linkText("SEARCH")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.cssSelector(".nav-tabs")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		ArrayList<WebElement> tabElements = (ArrayList<WebElement>) driver
				.findElements(By.cssSelector(".nav-tabs li a"));

		ArrayList<String> tabNames = new ArrayList<String>();

		for (WebElement webElement : tabElements) {
			tabNames.add(webElement.getText());
		}

		for (String curTabName : tabNames) {
			driver.findElement(By.linkText(curTabName)).click();

			for (int second = 0;; second++) {
				if (second >= 60)
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

	@Ignore
	@Test
	public void testFooterLoadedOnExtendedSearchPage() throws Exception {
		driver.get(baseUrl + "/");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("langEn")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("langEn")).click();
		driver.findElement(By.linkText("SEARCH")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.cssSelector("footer")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

	}

	@Ignore
	@Test
	public void testFooterLoadedOnMainPage() throws Exception {
		driver.get(baseUrl + "/sample");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.cssSelector("footer")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	@Ignore
	@Test
	public void testGeneralInfoLoaded() throws Exception {
		driver.get(baseUrl + "/");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("langEn")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("langEn")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("about")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		try {
			assertTrue(
					driver.findElement(By.id("about")).getText().matches("^[\\s\\S]*Collections in geology[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertTrue(driver.findElement(By.id("about")).getText()
					.matches("^[\\s\\S]*Geocollections in Estonia[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertTrue(driver.findElement(By.id("about")).getText().matches("^[\\s\\S]*Common database[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@Ignore
	@Test
	public void testGitContentLoaded() throws Exception {
		driver.get(baseUrl + "/");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.linkText("ENG")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("langEn")).click();
		driver.findElement(By.linkText("USEFUL INFO")).click();
		driver.findElement(By.linkText("GIT")).click();
		try {
			assertTrue(driver.findElement(By.id("git")).getText()
					.matches("^[\\s\\S]*GIT: Geological collections[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@Ignore
	@Test
	public void testModalWindowIsOpenOnSearchPage() throws Exception {
		driver.get(baseUrl + "/sample");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("langEn")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("langEn")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.cssSelector("tr.ng-scope:nth-child(1) > td:nth-child(3) > a:nth-child(1)")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
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

	@Ignore
	@Test
	public void testShowMap() throws Exception {
		driver.get(baseUrl + "/");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("langEn")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("langEn")).click();
		driver.findElement(By.linkText("MAP")).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("map")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}

	@Ignore
	@Test
	public void testUsingCollectionsContentLoaded() throws Exception {
		driver.get(baseUrl + "/");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (isElementPresent(By.id("langEn")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("langEn")).click();
		driver.findElement(By.linkText("USEFUL INFO")).click();
		driver.findElement(By.linkText("Using collections")).click();
		try {
			assertTrue(driver.findElement(By.id("usingCollections")).getText().matches("^[\\s\\S]*Using[\\s\\S]*$"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
