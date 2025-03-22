import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    private final By newAccountButton = By.xpath(String.format(PRECISE_TEXT_PATH, "Create new account"));

    @Test
    public void testRegistration(){
        driver.findElement(newAccountButton).click();

}
}

