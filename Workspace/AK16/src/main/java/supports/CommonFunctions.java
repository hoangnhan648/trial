package supports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonFunctions {

    /*
    1. launchBrowser : WebDriver
    2. getElement: WebElement
    3. visit () :
    */

    private static WebDriver driver;
    private static final int TIMEOUT = 60;
    private static WebDriverWait waiter;

    public static void launchBrowser (String browser) {
        if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            System.err.println("Browser" + browser +"is not defined" );
        }
        waiter = new WebDriverWait(driver,TIMEOUT);
    }

    public static By getBy(How how, String locator) {
        By element = null;
        switch (how) {
            case CLASS_NAME:
               element = By.className(locator);
                break;
            case CSS:
                element = By.cssSelector(locator);
                break;
            case ID:
                element = By.id(locator);
                break;
            case ID_OR_NAME:
                element = ByIdOrName.id(locator);
                break;
            case LINK_TEXT:
                element = By.linkText(locator);
                break;
            case NAME:
                element = By.name(locator);
                break;
            case PARTIAL_LINK_TEXT:
                element = By.partialLinkText(locator);
                break;
            case TAG_NAME:
                element = By.tagName(locator);
                break;
            case XPATH:
                element = By.xpath(locator);
                break;
            case UNSET:
                break;
        }
        return element;
    }

    public static void visit (String url) {
        driver.get(url);
    }

    public static void visit () {
        visit("https://google.com");
    }

    public static WebElement getElement (How how, String locator) {
        return driver.findElement(getBy(how, locator));
    }

    public static void click (How how, String locator) {
        waitForElementPresent(how, locator);
        getElement(how, locator).click();
    }

    public static void fillIn (How how, String locator, String withText) {
        waitForElementPresent(how, locator);
        getElement(how, locator).clear();
        getElement(how, locator).sendKeys(withText);
    }

    public static String getText (How how, String locator) {
        waitForElementPresent(how, locator);
        return getElement(how, locator).getText();
    }

    public static void waitForElementPresent(How how, String locator) {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(getBy(how, locator)));
    }

    public static boolean isDisplayed(How how, String locator) {
        waitForElementPresent(how, locator);
        return getElement(how, locator).isDisplayed();
    }

    public static boolean isEnabled (How how, String locator) {
        waitForElementPresent(how, locator);
        return getElement(how, locator).isEnabled();
    }

    public static void handleAlertPopup (){
        driver.switchTo().alert().accept();
    }
}
