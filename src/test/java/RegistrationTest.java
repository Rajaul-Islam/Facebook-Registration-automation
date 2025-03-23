import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTest extends BaseTest{

    private final By newAccountButton = By.xpath(String.format(PRECISE_TEXT_PATH, "Create new account"));


    private final By dayDropdown = By.xpath(String.format(ID_PATH, "day"));
    private final By monthDropdown = By.xpath(String.format(ID_PATH, "month"));
    private final By yearDropdown = By.xpath(String.format(ID_PATH, "year"));
    private final By genderMale = By.xpath(String.format(PRECISE_TEXT_PATH, "Male"));
    private final By genderFemale = By.xpath(String.format(PRECISE_TEXT_PATH, "Female"));
    private final By genderCustom = By.xpath(String.format(PRECISE_TEXT_PATH, "Custom"));
    private final By singUpButton = By.xpath(String.format(PRECISE_TEXT_PATH, "Sign Up"));
    private final By confirmationText = By.xpath(String.format(CONTAINS_TEXT_PATH, "Enter the code from your email"));


    @Test
    public void testRegistration(){
        driver.findElement(newAccountButton).click();

        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("Doe");
        driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("John");
        driver.findElement(dayDropdown).click();
        WebElement dayOption= driver.findElement(By.xpath(String.format(PRECISE_TEXT_PATH, "15")));
        dayOption.click();
        Select monthSelect = new Select(driver.findElement(monthDropdown));
        monthSelect.selectByVisibleText("Jan");
        driver.findElement(yearDropdown).click();
        WebElement yearOption = driver.findElement(By.xpath(String.format(PRECISE_TEXT_PATH, "1990")));
        driver.findElement(genderFemale).click();
        driver.findElement(By.xpath("//*[@name='reg_email__']")).sendKeys("rajaulislam.palla@gmail.com");
        driver.findElement(By.xpath("//*[@id='password_step_input']")).sendKeys("Rajaul@01683");
        yearOption.click();
        driver.findElement(singUpButton).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_TIME));
        WebElement confirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationText));


        // Verify the presence of the confirmation text
        Assert.assertTrue(confirmationElement.isDisplayed(), "The confirmation text is not displayed.");
    }
}

