package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class WebTableStatic {
    @Test
    public void test_web_tables(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://awesomeqa.com/webtable.html");

        // //table[@id = 'customers']/tbody/tr[2]/td[2]
        int row = driver.findElements(By.xpath("//table[@id = 'customers']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id = 'customers']/tbody/tr[2]/td")).size();

        System.out.println(row);
        System.out.println(col);

        String firstPart = "//table[@id = 'customers']/tbody/tr[";
        String secondPart = "]/td[";
        String thirdPart = "]";

        for(int i = 2; i<=row; i++){
            for(int j=1; j<=col; j++){
                String dynamicXpath = firstPart + i + secondPart + j + thirdPart;
                String data = driver.findElement(By.xpath(dynamicXpath)).getText();
                //System.out.println(data);

                if(data.contains("Helen Bennett")){
                    String countryPath = dynamicXpath + "/following-sibling::td";
                    String companyPath = dynamicXpath + "/preceding-sibling::td";
                    String countryName = driver.findElement(By.xpath(countryPath)).getText();
                    String companyName = driver.findElement(By.xpath(companyPath)).getText();
                    System.out.println("============================");

                    System.out.println("Helen Bennett is in " + countryName);
                    System.out.println("Helen Bennett is in " + companyName);
                    System.out.println("============================");

                }
            }
        }
        driver.quit();

    }
}
