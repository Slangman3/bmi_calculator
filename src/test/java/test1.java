import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class test1 {

    @Test

    public void testOfBMICalculator() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://healthunify.com/bmicalculator/");

        driver.findElement(By.name("wg")).sendKeys("15.01");

        driver.findElement(By.name("ht")).sendKeys("100");

        driver.findElement(By.name("cc")).click();

        String category = driver.findElement(By.name("desc")).getAttribute("value");

        String weight = driver.findElement(By.name("wg")).getAttribute("value");

        String height = driver.findElement(By.name("ht")).getAttribute("value");

        double w = Double.parseDouble(weight);

        double h = Math.pow(Double.parseDouble(height) / 100, 2);

        double BMI = w / h;

        String x;

        if (BMI > 0 && BMI <= 15) {
            x = "Your category is Very severely underweight";
        } else if (BMI > 15 && BMI <= 16) {
            x = "Your category is Severely underweight";
        } else if (BMI > 16 && BMI <= 18.50) {
            x = "Your category is Underweight";
        } else if (BMI > 18.50 && BMI <= 25) {
            x = "Your category is Normal";
        } else if (BMI > 25 && BMI <= 30) {
            x = "Your category is Overweight";
        } else if (BMI > 30 && BMI <= 35) {
            x = "Your category is Moderately obese";
        } else if (BMI > 35 && BMI <= 40) {
            x = "Your category is Severely obese";
        } else {
            x = "Your category is Very severely obese";
        }

        if (category.equalsIgnoreCase(x)) {
            System.out.println("Your BMI calculator is nice working.");
        } else {
            System.out.println("Your BMI calculator has incorrect formula of BMI, need to be fixed from '" + category + "'.");
        }

        System.out.println("BMI = " + BMI + ". And it must be suitable to '" + x + "'.");

        driver.quit();

    }

}