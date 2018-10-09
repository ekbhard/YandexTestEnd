import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    ChromeDriver driver = new ChromeDriver();

    @org.testng.annotations.Test(groups = {"T1","T3"})
    public void login() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru/");
        WebElement InEaill = driver.findElement(By.xpath("//span[contains(text(),'Войти в почту')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(InEaill).click().build().perform();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("ajajhartd");
        driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("12345df");
        driver.findElement(By.xpath("//button[@type='submit']//span[@class='passport-Button-Content']")).click();
    }

    @org.testng.annotations.Test(dependsOnGroups = "T1",enabled = true, groups = {"T3"})
    public void change_name() throws InterruptedException {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='nb-3']//*[@class='svgicon svgicon-mail--Settings']")));
        WebElement settings = driver.findElement(By.xpath("//a[@id='nb-3']//*[@class='svgicon svgicon-mail--Settings']"));
        Actions settAc = new Actions(driver);
        settAc.moveToElement(settings).click().build().perform();
        driver.findElement(By.xpath("//span[contains(text(),'Личные данные, подпись, портрет')]")).click();
        try {
            WebElement field = driver.findElement(By.xpath("//input[contains(@class,'nb-input _nb-small-simple')]"));
            Thread.sleep(1000);
            field.clear();
            field.sendKeys("Stsvdv Gardvf");
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement field = driver.findElement(By.xpath("//input[contains(@class,'nb-input _nb-small-simple')]"));
            Thread.sleep(1000);
            field.clear();
            field.sendKeys("Stsvdv Gardvf");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//span[contains(text(),'сохранить изменения')]")).click();
    }

    @org.testng.annotations.Test(dependsOnGroups = "T1",enabled = true,groups = {"T3"})
    public void send_massage() {
        //login();
        //driver.findElement(By.xpath("//body//button[@class='button2 button2_size_l button2_theme_normal button2_width_max'")).click();
        driver.findElement(By.xpath("//div[@class='mail-ComposeButton-Wrap']//a[@title='Написать (w, c)']")).click();
        driver.findElement(By.xpath("//div[@name='to']")).sendKeys("ajajhartd@yandex.ru");
        driver.findElement(By.xpath("//input[@name='subj-8f182c2e9272c2015b1b4cd48e08d167ef84e2c1']")).sendKeys("fdbrdr");
        driver.findElement(By.xpath("//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys("ddfvdfvf");
        driver.findElement(By.xpath("//button[@id='nb-13']//span[@class='_nb-button-content']")).click();
        /*
        driver.findElement(By.xpath("//button[@id='nb-136']")).click();
        WebElement In = driver.findElement(By.xpath("//a[@class='mail-Done-Redirect-Link']"));
        Actions InACt = new Actions(driver);
        InACt.moveToElement(In).click().build().perform();*/
    }

    @org.testng.annotations.Test(dependsOnGroups = "T1",groups = {"T3"})
    public void find_my_massages() throws InterruptedException {
        int i;
        List<WebElement> POSTS = driver.findElements(By.xpath("//div[contains(@class,'mail-MessageSnippet-Wrap js-messages-item')]//span[contains(@title,'@')]"));
        for (i = 0; i < POSTS.size(); i++) {
            if (POSTS.get(i).getAttribute("title").contains("ajajhartd@yandex.ru")) {
                Thread.sleep(1000);
                WebElement elem = driver.findElement(By.xpath("//input[@class='_nb-checkbox-input' and contains(@id, '" + i + "')]"));
                Actions clac = new Actions(driver);
                clac.moveToElement(elem).click().build().perform();
            }

            driver.findElement(By.xpath("//span[@class='mail-Toolbar-Item-Text js-toolbar-item-title js-toolbar-item-title-delete']")).click();
        }
    }
    @org.testng.annotations.Test(dependsOnGroups = "T1", enabled = true,groups = {"T3"})
    public void change_language() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='nb-3']//*[@class='svgicon svgicon-mail--Settings']")));
        WebElement settings = driver.findElement(By.xpath("//a[@id='nb-3']//*[@class='svgicon svgicon-mail--Settings']"));
        Actions settAc = new Actions(driver);
        settAc.moveToElement(settings).click().build().perform();
        driver.findElement(By.xpath("//span[contains(text(),'Личные данные, подпись, портрет')]")).click();
        driver.findElement(By.xpath("//span[@class='b-selink__link mail-Settings-Lang']")).click();
        driver.findElement(By.xpath("//img[@class='b-mail-icon b-mail-icon_lang-en']")).click();
    }
    @org.testng.annotations.Test
    public void quot(){
        driver.quit();
    }
}