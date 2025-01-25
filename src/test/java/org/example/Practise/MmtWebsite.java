package org.example.Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MmtWebsite {
    @Test
    public void test_mmt_website_click(){

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class=\"commonModal__close\"]")));

        WebElement xIcon = driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]"));
        xIcon.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='fromCity']")));
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

        WebElement formCity = driver.findElement(By.xpath("//input[@id='fromCity']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(formCity).click().build().perform();
        actions.moveToElement(formCity).click().sendKeys("Jaipur").build().perform();
        //formCity.click();
        //formCity.sendKeys("Jaipur");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@role='listbox']/li[1]"));
        for(WebElement e : list_auto_complete){
            if(e.getText().contains("Jaipur")){
                e.click();
                break;
            }

        }



    }
}
