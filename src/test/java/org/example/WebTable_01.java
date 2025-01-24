package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;


import java.util.List;

public class WebTable_01 {
    @Test
    public void test_web_table(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://awesomeqa.com/webtable1.html");

        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
        //rows & columns
        List <WebElement> rows = driver.findElements(By.tagName("tr"));

        for(int i = 0; i<rows.size(); i++){
            List <WebElement> columns = driver.findElements(By.tagName("td"));
            for(WebElement c: columns){
                System.out.println(c.getText());
            }
        }
    }
}
