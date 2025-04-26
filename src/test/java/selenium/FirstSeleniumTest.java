package selenium;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class FirstSeleniumTest {
    WebDriver driver;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofMillis(1000));
    }

    @After
    public void tearDown()
            throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void testW3SchoolTitle() {
        W3SchoolMainPage w3schoolMainPage = new W3SchoolMainPage(driver);

        assertEquals("W3Schools Online Web Tutorials", w3schoolMainPage.getTitle());
    }

    @Test
    public void testw3schoolSearch() {
        W3SchoolMainPage w3schoolMainPage = new W3SchoolMainPage(driver);
        W3SchoolSearchResult searchResult = w3schoolMainPage.search("Php Tutorial");

        assertEquals("PHP Tutorial", searchResult.getTitle());

    }

    @Test
    public void testw3schoolNextButton() {
        W3SchoolMainPage w3schoolMainPage = new W3SchoolMainPage(driver);
        W3SchoolNextPage nextPage = w3schoolMainPage.nextPageResult("Php Tutorial");

        assertEquals("PHP Introduction", nextPage.getTitle());
    }




}
