import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestLogin {
    @Test
    public void SirstTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru/");
        driver.findElement(By.xpath("//a[@class='home-link desk-notif-card__login-mail-promo']")).click();
        //driver.findElement(By.xpath("//a[@class='home-link desk-notif-card__login-mail-promo']")).submit();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Ajaj");
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Hartd");
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("ajajhartd");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345df");
        driver.findElement(By.xpath("//input[@id='password_confirm']")).sendKeys("12345df");
     /*
     driver.findElement(By.xpath("span[@class='registration__pseudo-link link_has-no-phone']")).submit();
     driver.findElement(By.xpath("//span[@class='select2 select2_theme_normal control-questions select2_size_m select2_width_max select2_type_radio select2_text_Фамилия вашего любимого музыканта']//button[@type='button']")).click();
     */
        //driver.findElement(By.className("registration__pseudo-link link_has-no-phone")).click();
}}
