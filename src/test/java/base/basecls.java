package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.bajajDashboard;
import java.io.File;
import org.apache.commons.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class basecls extends bajajDashboard {
    WebDriver driver;
//    @BeforeClass
//    public void launchBrowser(){
//        WebDriver driver = new ChromeDriver();
//      //  driver.get("https://www.bajajfinserv.in/");
//    }

    @BeforeMethod
    public void enterURL() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.bajajfinserv.in/");
    }

    @BeforeTest
    public void logIn() {
        System.out.println("Logged in");
    }

    @Test
    public void bajajTitle() {
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle, "Bajaj Finserv: Loans, Cards, Insurance, Investments, Payments and more");
    }

    @Test
    public void logoTest(){
        driver.findElement(bajajDashboard.logo).isDisplayed();
    }

    @Test
    public void cartIsPresent(){
        driver.findElement(bajajDashboard.cart).isDisplayed();
    }

    @Test
    public void signInIsPresent(){
        driver.findElement(bajajDashboard.signInBtn).isDisplayed();
    }

    @Test
    public void emiCardIsPResent(){
        driver.findElement(bajajDashboard.emiCardOption).isDisplayed();
    }

    @Test
    public void notificationIsPresent(){
        driver.findElement(bajajDashboard.notifications).isDisplayed();
    }

    @Test
    public void userShouldSee_GetItNow() throws InterruptedException {
        driver.findElement(bajajDashboard.emiCardOption).click();
     //   wait(3);
        String getItNowBtn = driver.findElement(bajajDashboard.getItNowBtn).getText();
        Assert.assertEquals(getItNowBtn,"GET IT NOW");
    }

//    @Test
//    public void takeScreenshot(){
//      File srcFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//      String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
//    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterTest
    public void takeScreenshots() throws IOException {
        //Use TakesScreenshot method to capture screenshot
        TakesScreenshot screenshot = (TakesScreenshot)driver;
//Saving the screenshot in desired location
        File source = screenshot.getScreenshotAs(OutputType.FILE);
//Path to the location to save screenshot
        FileUtils.copyFile(source, new File("/SeleniumScreenshots/Screen.png"));
        System.out.println("Screenshot is captured");
     //   driver.quit();
    }

    @AfterClass
    public void closeBrowser() {
        System.out.println("close browser");
    }

    @AfterSuite
    public void generateTestReport() {

    }

}
