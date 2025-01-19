package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptAlerts {
    @Test
    public void test_javaScriptAlerts(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // //button[text() = "Click for JS Alert"]
        // //button[text() = "Click for JS Confirm"]
        // //button[text() = "Click for JS Prompt"]

        //WebElement element = driver.findElement(By.xpath("//button[text() = \"Click for JS Alert\"]"));
       // WebElement elementConfirm = driver.findElement(By.xpath("//button[text() = \"Click for JS Confirm\"]"));
        WebElement elementPrompt = driver.findElement(By.xpath("//button[text() = \"Click for JS Prompt\"]"));
       // element.click();
      //  elementConfirm.click();
        elementPrompt.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());


        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Ravi");
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();
        //Assert.assertEquals(result,"You successfully clicked an alert");
        //Assert.assertEquals(result, "You clicked: Ok");
        Assert.assertEquals(result, "You entered: Ravi");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
