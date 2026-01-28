package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorDemoQA {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

        // JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // ---------------------------------------
        // 1️⃣ Scroll Down by pixel
        // ---------------------------------------
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(2000);

        // ---------------------------------------
        // 2️⃣ Scroll UP by pixel
        // ---------------------------------------
        js.executeScript("window.scrollBy(0,-200)");
        Thread.sleep(2000);

        // ---------------------------------------
        // 3️⃣ Scroll to bottom of page
        // ---------------------------------------
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        // ---------------------------------------
        // 4️⃣ Scroll to top of page
        // ---------------------------------------
        js.executeScript("window.scrollTo(0, 0)");
        Thread.sleep(2000);

        // ---------------------------------------
        // 5️⃣ Scroll using PAGE DOWN key (WebElement)
        // ---------------------------------------
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);

        // ---------------------------------------
        // 6️⃣ Scroll to a specific element
        // ---------------------------------------
        WebElement submitButton = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(2000);

        // ---------------------------------------
        // 7️⃣ Highlight the element (Border + Background)
        // ---------------------------------------
        js.executeScript("arguments[0].style.border='3px solid red'", submitButton);
        js.executeScript("arguments[0].style.background='yellow'", submitButton);
        Thread.sleep(2000);

        // ---------------------------------------
        // 8️⃣ Click using JavaScript
        // ---------------------------------------
        js.executeScript("arguments[0].click();", submitButton);

        Thread.sleep(2000);
        driver.quit();
    }
}
