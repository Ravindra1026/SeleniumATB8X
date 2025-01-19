package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Selectbox {
    private static final Logger log = LoggerFactory.getLogger(Selectbox.class);
    @Test

    public void test_SelectBox(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement element_select = driver.findElement(By.id("dropdown"));

        Select select = new Select(element_select);
        //select.selectByIndex(1);
        select.selectByVisibleText("Option 2");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();


    }
}
