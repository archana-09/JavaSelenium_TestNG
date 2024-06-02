package base;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.*;
import pages.bajajDashboard;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class basecls extends bajajDashboard {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void enterURL() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-geolocation");
        options.addArguments("--headless=new");
        if(driver == null){
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.navigate().to("https://www.bajajfinserv.in/");
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }
        else{
            driver.navigate().to("https://www.bajajfinserv.in/");
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        }
    }

//    @BeforeMethod
//    public void launchAppURL() {
//        driver.navigate().to("https://www.bajajfinserv.in/");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        //    options.addArguments("disable-notifications");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(text(),'Mutual Fund')])[2]")));
//    }


//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }

//    @Test
//    public void userShouldSee_GetItNow() throws InterruptedException {
//        driver.findElement(bajajDashboard.emiCardOption).click();
//        //   wait(3);
//        String getItNowBtn = driver.findElement(bajajDashboard.getItNowBtn).getText();
//        Assert.assertEquals(getItNowBtn, "GET IT NOW");
//    }


//    @Test
//    public void takeScreenshot() {
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//    }


//    @AfterTest
//    public void takeScreenshots() throws IOException {
//        //Use TakesScreenshot method to capture screenshot
//        TakesScreenshot screenshot = (TakesScreenshot) driver;
////Saving the screenshot in desired location
//        File source = screenshot.getScreenshotAs(OutputType.FILE);
////Path to the location to save screenshot
//        FileUtils.copyFile(source, new File("/SeleniumScreenshots/Screen.png"));
//        System.out.println("Screenshot is captured");
//        driver.quit();
//    }

//    @AfterClass
//    public void closeBrowser() {
//        driver.quit();
//        System.out.println("close browser");
//    }
//
//    @AfterSuite
//    public void generateTestReport() {
//
//    }

    protected WebDriver getDriver(){
        return driver;
    }

    protected WebDriverWait getWait(){
        return wait;
    }

    protected boolean isElementPresent(By ele){
        boolean flag = false;
        try{
            driver.findElement(ele);
            flag = true;
        }
        catch(Exception e){
            flag = false;
        }
        return flag;
    }

}
