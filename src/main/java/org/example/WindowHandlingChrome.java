package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandlingChrome {

    public static void main(String[] args) throws InterruptedException {

        // Launch Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open website
        driver.get("https://demoqa.com/browser-windows");

        // Step 1: Get Parent Window ID
        String parentWindowId = driver.getWindowHandle();
        System.out.println("Parent Window ID: " + parentWindowId);

        // Step 2: Click button to open new window
        driver.findElement(By.id("windowButton")).click();

        // Step 3: Get all Window IDs
        Set<String> windowIds = driver.getWindowHandles();

        // Step 4: Switch to Child Window
        for (String id : windowIds) {
            if (!id.equals(parentWindowId)) {
                System.out.println("Child Window ID: " + id);

                driver.switchTo().window(id);
                Thread.sleep(3000);

                // Perform action in child window
                String childText = driver.findElement(By.id("sampleHeading")).getText();
                System.out.println("Child Window Text: " + childText);

                // Close child window
                driver.close();
            }
        }

        // Step 5: Go back to Parent Window
        driver.switchTo().window(parentWindowId);

        System.out.println("Back to Parent Window!");
        Thread.sleep(2000);

        driver.quit();
    }
}
