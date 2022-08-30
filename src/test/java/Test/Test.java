package Test;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    static WebDriver driver;
    public static void setup(){
        System.setProperty("WebDriver.chrome.driver","chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");}
    public static void login() {


            driver.findElement(By.name("user-name")).sendKeys("standard_user");
            driver.findElement(By.name("password")).sendKeys("secret_sauce");
            driver.findElement(By.name("login-button")).click();
        }
        public static void verification(String locator,String expected )
        {
            String actual=driver.findElement(By.xpath(locator)).getText();
            Assert.isTrue(actual.contains(expected),"not expected");
        }


    public static void Addtocart(){
        driver.findElement(By.className("inventory_item_name")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.name("remove-sauce-labs-backpack")).click();
        driver.findElement(By.id("continue-shopping")).click();
        driver.findElement(By.className("inventory_item_name")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.name("checkout")).click();

    }
    public static void verification2(String locatior,String expected){
        String actual=driver.findElement(By.xpath(locatior)).getText();
        Assert.isTrue(actual.contains(expected),"not expected");
    }


    public static void myinformation(){
        driver.findElement(By.id("first-name")).sendKeys("Sachin");
        driver.findElement(By.id("last-name")).sendKeys("Soni");
        driver.findElement(By.id("postal-code")).sendKeys("10101");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium cart_button']")).click();
    }


    public static void main(String[] args){
        setup();
        login();
        verification("//span[@class='title']","PRODUCTS");
        Addtocart();
        verification2("//span[@class='title']","CHECKOUT: YOUR INFORMATION");
        myinformation();
    }
}
