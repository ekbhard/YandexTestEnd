import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    ChromeDriver driver = new ChromeDriver();

    WebDriverWait wait = (new WebDriverWait(driver, 2));

    @AfterTest(groups = "T3")
    protected void cookligin() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().to("https://mail.yandex.ru");
    }

    @org.testng.annotations.Test(groups = {"T1"})
    public void login() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru/");
        WebElement InEaill = driver.findElement(By.xpath("//div//div//a[contains(@class,'button desk-notif-card__login-enter')]/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(InEaill).click().build().perform();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("ajajhartd");
        driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("12345df");
        driver.findElement(By.xpath("//button[@type='submit']//span[@class='passport-Button-Content']")).click();
    }



    @org.testng.annotations.Test(dependsOnGroups = "T1", groups = {"T3"}, priority = 3)
    public void sendMassage() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mail-ComposeButton-Wrap']")));
        //driver.findElement(By.xpath("//body//button[@class='button2 button2_size_l button2_theme_normal button2_width_max'")).click();
        WebElement dynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//div//a[contains(@class,'mail-ComposeButton js-main-action-compose')]")));
        driver.findElement(By.xpath("//div//div//a[contains(@class,'mail-ComposeButton js-main-action-compose')]")).click();
        driver.findElement(By.xpath("//div[@name='to']")).sendKeys("ajajhartd@yandex.ru");
        driver.findElement(By.xpath("//input[@name='subj-8f182c2e9272c2015b1b4cd48e08d167ef84e2c1']")).sendKeys("fdbrdr");
        driver.findElement(By.xpath("//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys("ddfvdfvf");
        //driver.findElement(By.xpath("//button[@id='nb-13']//span[@class='_nb-button-content']")).click();
        driver.findElement(By.xpath("//div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div//span[contains(@class,'ui-button-text')]")).click();

    }



    @org.testng.annotations.Test(dependsOnGroups = "T1", groups = {"T3"}, priority = 0)
    public void findMyMassages() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mail-User-Name']")));
        int i;
        List<WebElement> POSTS = driver.findElements(By.xpath("//div[contains(@class,'mail-MessageSnippet-Wrap js-messages-item')]//span[contains(@title,'@')]"));
        for (i = 0; i < POSTS.size(); i++) {
            if (POSTS.get(i).getAttribute("title").contains("ajajhartd@yandex.ru")) {
                Thread.sleep(1000);
                WebElement elem = driver.findElement(By.xpath("//input[@class='_nb-checkbox-input' and contains(@id, '" + i + "')]"));
                Actions clac = new Actions(driver);
                clac.moveToElement(elem).click().build().perform();
            }
        }
        driver.findElement(By.xpath("//span[@class='mail-Toolbar-Item-Text js-toolbar-item-title js-toolbar-item-title-delete']")).click();
        driver.findElement(By.xpath("//div//div//button[contains(@class,'theme_action js-confirm-mops')]")).click();
    }

    @org.testng.annotations.Test(dependsOnGroups = "T1", groups = {"T3"}, priority = 1)
    public void changeName(String name) throws InterruptedException {
        // WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='nb-3']//*[@class='svgicon svgicon-mail--Settings']")));
        WebElement settings = driver.findElement(By.xpath("//a[@id='nb-3']//*[@class='svgicon svgicon-mail--Settings']"));
        Actions settAc = new Actions(driver);
        settAc.moveToElement(settings).click().build().perform();
        List<WebElement> set = driver.findElements(By.xpath("//div//div//span[contains(@class,'settings-popup-menu-item-content')]"));
        set.get(0).click();
        try {
            WebElement field = driver.findElement(By.xpath("//input[contains(@class,'nb-input _nb-small-simple')]"));
            Thread.sleep(1000);
            field.clear();
            field.sendKeys(name);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement field = driver.findElement(By.xpath("//input[contains(@class,'nb-input _nb-small-simple')]"));
            Thread.sleep(1000);
            field.clear();
            field.sendKeys(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div//div//div//form//button[contains(@class,'nb-button _nb-action-button b-mail-button_setup-saver')]//span[contains(@class,'b-button-text')]")).click();
    }

    /*dependsOnGroups = "T1"*/


    @org.testng.annotations.Test(dependsOnGroups = "T1", groups = {"T3"}, priority = 2)
    public void changeLanguage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='nb-3']//*[@class='svgicon svgicon-mail--Settings']")));
        WebElement settings = driver.findElement(By.xpath("//a[@id='nb-3']//*[@class='svgicon svgicon-mail--Settings']"));
        Actions settAc = new Actions(driver);
        settAc.moveToElement(settings).click().build().perform();
        List<WebElement> set = driver.findElements(By.xpath("//div//div//span[contains(@class,'settings-popup-menu-item-content')]"));
        set.get(0).click();
        driver.findElement(By.xpath("//span[@class='b-selink__link mail-Settings-Lang']")).click();
        driver.findElement(By.xpath("//img[@class='b-mail-icon b-mail-icon_lang-en']")).click();

    }

    @org.testng.annotations.Test(groups = "3")
    public void quot() {
        driver.quit();
    }

    //НАЧИНАЕТСЯ ПОСТРОЕНИЕ


    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\System32\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru/");
    }
    public void passLogin(String pas, String login){
        WebElement InEaill = driver.findElement(By.xpath("//div//div//a[contains(@class,'button desk-notif-card__login-enter')]/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(InEaill).click().build().perform();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(pas);
        driver.findElement(By.xpath("//button[@type='submit']//span[@class='passport-Button-Content']")).click();
        //добавить проверку логина
    }
    //ТЕСТ НА ЛОГИН
    public void log(){
        setup();
        passLogin("asdasdas", "asdasdasd");
    }
    //ТЕСТ

    public void toTheStart() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().to("https://mail.yandex.ru");
    }

    //ТЕСТ НА НАХОЖДЕНИЯ ПИСЕМ
    public void messges() throws InterruptedException {
        setup();
        findMyMassages();
    }
    //ТЕСТ НА ИЗМЕНЕНИЕ ИМЕНИ
    public void name() throws InterruptedException {
        setup();
        changeName("Asvdsv ASsds");
    }
    //ТЕСТ НА ИЗМЕНЕНИЕ ЯЗЫКА
    public void leng(){
        setup();
        changeLanguage();
    }
    //ТЕСТ НА ОТПРАВКУ СООБЩЕНИЙ
    public void send(){
    }
    public void buttonIn(){
        driver.findElement(By.xpath("//div//div//a[contains(@class,'mail-ComposeButton js-main-action-compose')]")).click();
    }
    public void komu (String maill){
        driver.findElement(By.xpath("//div[@name='to']")).sendKeys(maill);
    }
    public void theme(String them){
        driver.findElement(By.xpath("//input[@name='subj-8f182c2e9272c2015b1b4cd48e08d167ef84e2c1']")).sendKeys(them);
    }
    public void text(String tex){
        driver.findElement(By.xpath("//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(tex);
    }
    public void buttonSend(){
        driver.findElement(By.xpath("//div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div//span[contains(@class,'ui-button-text')]")).click();
    }
    public void sendM1(){
        setup();
        buttonIn();
        buttonSend();
    }
    public void sendM2(){
        setup();
        buttonIn();
        komu("ajajhartd@yandex.ru");
        buttonSend();
    }
    public void sendM3(){
        setup();
        buttonIn();
        komu("ajajhartd@yandex.ru");
        theme("dsjhnjmkdl");
        buttonSend();
    }
    public void sendM4(){
        setup();
        buttonIn();
        komu("ajajhartd@yandex.ru");
        theme("dsjhnjmkdl");
        text("sddfgsfbdgfh");
        buttonSend();
    }
}