package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptTittleMethod {
    @Test
    public void titleMethod(){
        //NOTE; USE JAVASCRIPT TITLE AND CLICK WHEN NORMAL METHODS ARE NOT WORKING
            //THIS SHOULD BE YOUR LAST STEP TO GET THE TITLE AND CLICK THE ELEMENT
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle()+" --> Driver");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();//it gets the title
        System.out.println(title + " --> JavaScriptExecutor");

    }
    @Test
    public void clickMethodJS(){
        //NOTE: If the javascript fails, it will throw the "JavaScriptException"
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techtorialacademy.com/");
        WebElement login = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", login);

    }
    @Test//INTERVIEW QUESTION
    public void scrollIntoViewMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement applyNow = driver.findElement(By.xpath("//div[@class='sidenav']//a[.='Apply Now']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", applyNow);

    }
    @Test
    public void text(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement texxt = driver.findElement(By.xpath("//p[.='© Copyrights 2022 Techtorial - All Rights Reserved']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true)", texxt);


    }
    @Test
    public void scrollIntoViewPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");
        WebElement getStarted = driver.findElement(By.linkText("Browse Course"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", getStarted);
        String actualTitle = js.executeScript("return document.title").toString();
        String expectedTitle = "Programs - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement information = driver.findElement(By.xpath("//h2[.='information']"));
        js.executeScript("arguments[0].scrollIntoView(true)", information);
        WebElement SDET = driver.findElement(By.xpath("//h4[.='SDET Course']//..//a[.='Get Started']"));
        js.executeScript("arguments[0].click()", SDET);






    }
    /*
    1-Navigate to the website
    2-Click browse course with JS
    3-GetTitle with JS and validate it
    4-Scroll down until information bottom of the page

        BONUS:
        5-Get started SDET COURSE(*) and click with JS
     */

}
