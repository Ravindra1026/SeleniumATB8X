package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class SvgHandling {
    @Test
    public void test_Svg_Handling() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.flipkart.com/");

        WebElement searchElement = driver.findElement(By.name("q"));
        searchElement.sendKeys("macmini");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name() = 'svg']"));
        svgElements.get(0).click();

        List<WebElement> titleResult = driver.findElements(By.xpath("//div[contains(@data-id, 'CPU')]/div/a[2]"));
        for(WebElement title : titleResult){
            System.out.println(title.getText());
        }


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    } }
