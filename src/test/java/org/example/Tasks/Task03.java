package org.example.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Task03 {
    @Test
    public void test_iDriveLogin() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");

        WebElement email = driver.findElement(By.xpath("//input[@id = 'username']"));
        email.sendKeys("augtest_040823@idrive.com");

        WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
        password.sendKeys("123456");

        WebElement signIn = driver.findElement(By.xpath("//button[@id = 'frm-btn']"));
        signIn.click();
        Thread.sleep(5000);





        driver.quit();

    }

}
