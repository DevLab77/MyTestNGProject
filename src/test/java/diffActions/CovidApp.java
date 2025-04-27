/*package diffActions;

public class CovidApp {
    package diffActions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.covidHome;
import java.time.Duration;


    public class CovidApp {


        WebDriver driver = null;
        covidHome CH;


        @BeforeClass
        @Parameters({"covurl"})
        // Open the application
        public void setUp(String url){
            CH = new covidHome();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Example of Implicit Wait


        }


        @Test
        public void do_differentSeleniumActions(){
            getTotalCount();
            getDeahCount();
            getTotalRecovered();


        }


        public void getTotalCount(){


            String totalCount = driver.findElement(CH.getTableValueAsPerCondition("Russia","totalcount")).getText();
            System.out.println("The Total Covid Count for Russia is ==>"+ totalCount);
        }
        public void getDeahCount(){
            try{
                String totalCount = driver.findElement(CH.getTableValueAsPerCondition("Italy","death")).getText();
                System.out.println("The Total Covid Death Count for Italy is ==>"+ totalCount);
            }
            catch(Exception e){e.printStackTrace();}


        }
        public void getTotalRecovered(){
            try{
                String totalCount = driver.findElement(CH.getTableValueAsPerCondition("Brazil","recovered")).getText();
                System.out.println("The Total Covid Recovered Count for Brazil is ==>"+ totalCount);
            }
            catch(Exception e){e.printStackTrace();}
        }


        @AfterClass
        public void tearDown(){
            driver.quit();
        }




    }

}
*/