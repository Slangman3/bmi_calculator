import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class test2 {

    @Test

    public void testOfBMICalculator() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://healthunify.com/bmicalculator/");

        driver.findElement(By.name("wg")).sendKeys("88");
        driver.findElement(By.name("ht")).sendKeys("193");

        driver.findElement(By.name("cc")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        driver.quit();

    }

}