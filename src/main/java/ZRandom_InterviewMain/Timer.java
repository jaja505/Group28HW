package ZRandom_InterviewMain;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Timer {
    public static void main(String[] args) throws InterruptedException {

        String test = "test [2 min.]";
        test = test.substring(test.indexOf("min.") - 2, test.indexOf("min"));

        System.out.println(test);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://timer.onlineclock.net/");//goes to URL
        Select dropDown = new Select(driver.findElement(By.id("minutesSelect")));//FORM SOURCE CODE


        dropDown.selectByVisibleText(test.concat("Minutes"));

        while (driver.getCurrentUrl().equals("https://timer.onlineclock.net/")) {
            driver.getCurrentUrl();

            if (driver.getCurrentUrl().equals("https://timer.onlineclock.net/alarm.html")) {

                driver.close();
                System.exit(0);
            }
        }
        //Thread.sleep(2000);


    }
}
