package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PocketFMPlayWithWait {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Episode to play 1000 times
            String episodeUrl = "https://pocketfm.com/episode/1fde1cbf1ee44a4cb0a0b8070ed54f77";

            // Loop 1000 plays
            for (int i = 1; i <= 1000; i++) {

                System.out.println("🔵 Play: " + i);

                driver.get(episodeUrl);

                Thread.sleep(5000);  // wait for page load

                WebElement playButton = driver.findElement(By.xpath("//*[@id='player_wrapper']"));
                playButton.click();

                System.out.println("▶️ Playing episode " + i + " | Wait 9 minutes...");

                Thread.sleep(540000);  // 9 minutes = 540,000 ms

                System.out.println("⏹ Completed play #" + i);
            }

            System.out.println("🎉 All 1000 plays completed!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // driver.quit(); // Enable after testing
        }
    }
}
