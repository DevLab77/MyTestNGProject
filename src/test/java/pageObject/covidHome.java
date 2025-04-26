package pageObject;

public class covidHome {

    package pageObject;


import org.openqa.selenium.By;


    public class covidHome {




        public By getTableValueAsPerCondition(String country, String column){
            String xpath = null;
            if(column.equalsIgnoreCase("totalcount")){
                xpath = "//table[@id='main_table_countries_today']//tbody[1]/tr/td/a[text()='"+country+"']/../../td[3]";
            }
            if(column.equalsIgnoreCase("death")){
                xpath = "//table[@id='main_table_countries_today']//tbody[1]/tr/td/a[text()='"+country+"']/../../td[4]";
            }
            if(column.equalsIgnoreCase("recovered")){
                xpath = "//table[@id='main_table_countries_today']//tbody[1]/tr/td/a[text()='"+country+"']/../../td[5]";
            }
            return By.xpath(xpath);
        }




    }

}
