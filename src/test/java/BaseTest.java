import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    public static final String BASE_URL = "https://www.facebook.com/";
    protected static final int MAX_WAIT_TIME = 10;
    protected static final String PRECISE_TEXT_PATH = "//*[text()='%s']";
    protected static final String CONTAINS_TEXT_PATH = "//*[contains(text(),'%s')]";
    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_TIME) );
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown(){
//        driver.quit();
    }


}