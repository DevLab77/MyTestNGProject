package automatedScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceTest {

    WebDriver driver = null;

    @BeforeClass
    @Parameters({"sauceurl"})
    public void setUp(String sauceurl) {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(sauceurl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Parameters({"username", "pw"})
    public void validateSauceDemoApplication(String username, String pw) {
        LoginSauceLab(username, pw);
        validateWelcomePageTitle();
        LogoutSauceLab();
    }

    public void LoginSauceLab(String user, String pw) {
        try {
            driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(user);
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pw);
            driver.findElement(By.xpath("//input[@id='login-button']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateWelcomePageTitle() {
        try {
            driver.findElement(By.xpath("//div[text()='Swag Labs']")).isDisplayed();
            Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Swag Labs']")).isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LogoutSauceLab() {
        try {
            driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//a[text()='Logout']")).click();
            Thread.sleep(5000);
            Assert.assertTrue(driver.findElement(By.xpath("//input[@id='login-button']")).isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
