package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Task02 {
    @Test
    public void test_simpleForm(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(--start-maximized);

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://awesomeqa.com/practice.html");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Ravindra");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Singh");

        WebElement gender = driver.findElement(By.id("sex-0"));
        gender.click();

        WebElement yearsOfExperience = driver.findElement(By.id("exp-3"));
        yearsOfExperience.click();

        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("25/Dec/2024");

        WebElement profession = driver.findElement(By.id("profession-1"));
        profession.click();

        WebElement automationTool = driver.findElement(By.id("tool-2"));
        automationTool.click();

       // WebElement continents = driver.findElement(By.id("continents"));
       // continents.



    }
}
