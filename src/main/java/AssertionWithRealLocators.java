import org.openqa.selenium.By;
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
        // Set up WebDriver configuration
        System.setProperty("web-driver.chrome.driver", "/C://Users//diana//Desktop//chromedriver_win32//chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }
    //assertEquals
    @Test
    public void testTitle() {
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not as expected");
    }

    //assertNotEquals
    @Test
    public void testPageTitleNotEquals() {
        driver.get("https://www.google.com");
        String expectedTitle = "Googl";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(actualTitle, expectedTitle, "Page title is not expected");
    }

    //assertTrue
    @Test
    public void testSearchButtonEnabled() {
        WebElement searchButton = driver.findElement(By.name("btnK"));
        Assert.assertTrue(searchButton.isEnabled(), "Search button is not enabled");
    }

    //assertTrue
    @Test
    public void testSearchInputVisibility() {
        WebElement searchInput = driver.findElement(By.name("q"));
        Assert.assertTrue(searchInput.isDisplayed(), "Search input is not visible");
    }

    //assertFalse
    @Test
    public void testElementIsNotPresent() {
        driver.get("https://www.openai.com");
        WebElement nonExistentElement;
        try {
            nonExistentElement = driver.findElement(By.id("nonExistentElementId"));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            nonExistentElement = null;
        }
        Assert.assertFalse(nonExistentElement != null, "Element should not be present on the page");
    }

    //assertEquals
    @Test
    public void testSignInLinkText() {
        WebElement signInLink = driver.findElement(By.linkText("Sign in"));
        String expectedLinkText = "Sign in";
        String actualLinkText = signInLink.getText();
        Assert.assertEquals(actualLinkText, expectedLinkText, "Link text is not as expected");
    }

    //assertNotNull
    @Test
    public void testElementIsNotNull() {
        driver.get("https://www.google.com");
        WebElement searchInput = driver.findElement(By.name("q"));
        Assert.assertNotNull(searchInput, "Search input element is null");
    }

    //assertNull
    @Test
    public void testElementIsNull() {
        driver.get("https://www.example.com");
        WebElement nonExistentElement;
        try {
            nonExistentElement = driver.findElement(By.id("nonExistentElement"));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            nonExistentElement = null;
        }
        Assert.assertNull(nonExistentElement, "Element should be null");
    }


    //assertSame
    @Test
    public void testSameReference() {
        driver.get("https://www.google.com");
        WebElement searchInput1 = driver.findElement(By.name("q"));
        WebElement searchInput2 = searchInput1;
        Assert.assertSame(searchInput1, searchInput2, "References do not point to the same element");
    }

    //assertNotSame
    @Test
    public void testDifferentReference() {
        driver.get("https://www.google.com");
        WebElement searchInput = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));
        Assert.assertNotSame(searchInput, searchButton, "References should not point to the same element");
    }

    //assertEquals
    @Test
    public void testArrayEquals() {
        driver.get("https://www.google.com");
        WebElement[] expectedLinks = driver.findElements(By.tagName("a")).toArray(new WebElement[0]);
        WebElement[] actualLinks = driver.findElements(By.tagName("a")).toArray(new WebElement[0]);
        Assert.assertEquals(actualLinks, expectedLinks, "Arrays are not equal");
    }
}
