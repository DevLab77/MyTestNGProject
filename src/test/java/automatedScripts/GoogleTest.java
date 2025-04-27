package automatedScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTest {

    //Validate GoogleTest

    @Test
    @Parameters({"googleurl"})
    public void validateGoogleLogo(String googleurl) {
        WebDriver driver = new ChromeDriver(); // This line will launch the Chrome Browser...
        driver.get(googleurl);
        driver.manage().window().maximize(); // To maximize the window

        //Validate Google Logo...

        if (driver.findElement(By.xpath("//div[@class='k1zIA rSk4se']")).isDisplayed()) {
            //.findElement(By.xpath("")) This tries to locate one element using an XPath selector (the empty quotes "" should contain a valid XPath)
            //.isDisplayed() Returns true if the element is visible on the page (not hidden with display:none, etc.)

            System.out.println("Google logo is present ...PASS");

        } else {
            System.out.println("Google logo is not present ...FAIL");
        }

        driver.quit(); // This will close driver instance.

        }
    }