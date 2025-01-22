package org.example;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class WebTableStatic {
    @Test
    public void test_web_tables(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("awesomeqa.com/webtable.html");

        // //table[@id = 'customers']/tbody/tr[2]/td[2]
    }
}
