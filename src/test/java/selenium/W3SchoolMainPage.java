package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class W3SchoolMainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;


    @FindBy(id = "search2")
    private WebElement searchInput;

    @FindBy(id = "learntocode_searchbtn")
    private WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(), 'Next')]")
    private WebElement nextButton;

    public W3SchoolMainPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.w3schools.com/");
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));


        acceptCookies();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public W3SchoolSearchResult search(String searchText) {
        searchInput.sendKeys(searchText);
        searchButton.click();
        return new W3SchoolSearchResult(driver);
    }

    public W3SchoolNextPage nextPageResult(String searchText) {
        searchInput.sendKeys(searchText);
        searchButton.click();
        nextButton.click();
        return new W3SchoolNextPage(driver);
    }

    private void acceptCookies() {
        try {
            WebElement acceptButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.id("accept-choices")
                    )
            );
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("No cookies popup appeared.");
        }
    }
}
