import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertionWithRealLocators {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        //Set Up WebDriver configuration
        System.setProperty("web-driver.chrome.driver", "/C://Users//diana//Desktop/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }

    @Test
    public void testTitle(){
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not as expected");
    }

    @Test
    public void testPageTitleNotEquals() {
        driver.get("https://www.google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(actualTitle, expectedTitle, "page");
    }

    @Test
    public void testSearchButtonEnabled(){
        WebElement searchButton = driver.findElement(By.name("btnK"));
        Assert.assertTrue(searchButton.isEnabled(), "Search button is not enabled");
    }

    @Test
    public void testSearchInputVisibility() {
        WebElement searchInput = driver.findElement(By.name("q"));
        Assert.assertTrue(searchInput.isDisplayed(), "Search input is not visible");

    }

    @Test
    public void testElementIsNotPresent(){
        driver.get("https://www.openai.com");
        WebElement nonExistentElement;
        try {
            nonExistentElement = driver.findElement
                    By.id("nonExistentElementId");
        } catch (NoSuchElementException e) {
            nonExistentElement = null;
        }
        Assert.assertNull(nonExistentElement, "Element should not be present on the page");
    }
}
