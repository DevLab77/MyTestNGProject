package automatedScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DifferentActions {

    WebDriver driver = null;
// This file is modified for Billy branch

    @BeforeClass
    @Parameters("doiturl")
    //Open the application
    public void openApp(String doiturl) {
        driver = new ChromeDriver(); //initialize driver with ChromeDriver
        driver.manage().window().maximize(); // to maximize browser window.
        driver.get(doiturl);
    }

    @Test //Actual test call
    @Parameters({"cardropdown"})
    public void do_differentSeleniumAutomation(String cardropdown) {
        validate_Radio_Button();
        validate_Checkbox();
        read_anyPage_text();
        selectADropDown(cardropdown);
    }

    @Test //Actual test call
    public void do_differentBrowserActions() {
        //Get current page title

        String title = driver.getTitle();
        String pageURL = driver.getCurrentUrl();
        System.out.println("Get Page Title is ==>" + title);
        System.out.println("Current URL is ===>" + pageURL);

        //How to refresh Web Page?

        driver.navigate().refresh();


    }

    //Validate Radio Button --ACTUAL TEST
    public void validate_Radio_Button() {

        //Get initial status of radio button
        boolean bmw = driver.findElement(By.xpath("//input[@id='bmwradio' and @value='bmw']")).isSelected();
        boolean benz = driver.findElement(By.xpath("//input[@id='benzradio' and @value='benz']")).isSelected();
        boolean honda = driver.findElement(By.xpath("//input[@id='hondaradio' and @value='honda']")).isSelected();

        System.out.println("Initially BMW radio button selection is == " + bmw);
        System.out.println("Initially Benz radio button selection is == " + benz);
        System.out.println("Initially Honda radio button selection is == " + honda);

        // Click Honda radio button
        driver.findElement(By.xpath("//input[@value='honda' and @type='radio']")).click();

        honda = driver.findElement(By.xpath("//input[@value='honda' and @type='radio']")).isSelected();
        System.out.println("After Click Honda radio button selection is == " + honda);

    }

    //Validate Checkbox --ACTUAL TEST
    public void validate_Checkbox() {

        //Get initial status of radio button
        boolean bmw = driver.findElement(By.xpath("//input[@id='bmwcheck' and @value='bmw']")).isSelected();
        boolean benz = driver.findElement(By.xpath("//input[@id='benzcheck' and @value='benz']")).isSelected();
        boolean honda = driver.findElement(By.xpath("//input[@id='hondacheck' and @value='honda']")).isSelected();

        System.out.println("Initially BMW radio button selection is == " + bmw);
        System.out.println("Initially Benz radio button selection is == " + benz);
        System.out.println("Initially Honda radio button selection is == " + honda);
    }

    public void read_anyPage_text() {
        String header = driver.findElement(By.xpath("//header[@id='top']/../h1")).getText();
        System.out.println("The Header text is ===>" + header);
    }

    //How to Select a Dropdown

    public void selectADropDown(String car) {

        Select select = new Select(driver.findElement(By.xpath("//select[@id='carsselect']")));
        //Select by Visible text
        select.selectByVisibleText("car");
        System.out.println("The dropdown is selected...");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}



