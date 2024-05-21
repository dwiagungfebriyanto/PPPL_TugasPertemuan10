import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest {

    @Test
    public void testLogin() {
        WebDriver driver = new EdgeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        username.sendKeys("student");
        password.sendKeys("Password123");
        submitButton.click();

        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);

        WebElement text = driver.findElement(By.xpath("//*[contains(text(), 'Congratulations')]"));
        WebElement logoutButton = driver.findElement(By.xpath("//*[contains(text(), 'Log out')]"));
        text.isDisplayed();
        logoutButton.isDisplayed();

        driver.quit();

    }
}
