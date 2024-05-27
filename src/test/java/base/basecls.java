package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.*;

import pages.bajajDashboard;

import java.io.File;

import org.apache.commons.*;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class basecls extends bajajDashboard {
    WebDriver driver;

//    @BeforeClass
//    public void launchBrowser() {
//        WebDriver driver = new ChromeDriver();
//        //  driver.get("https://www.bajajfinserv.in/");
//    }

    @BeforeMethod
    public void enterURL() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-geolocation");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.bajajfinserv.in/");
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //    options.addArguments("disable-notifications");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(text(),'Mutual Fund')])[2]")));

    }

    @Test
    public void bajajTitle() {
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assert.assertEquals(pageTitle, "Bajaj Finserv: Loans, Cards, Insurance, Investments, Payments and more");
    }

//    @Test
//    public void logoTest() throws InterruptedException {
//        driver.findElement(bajajDashboard.logo).isDisplayed();
//        System.out.println("passed");
//    }
//
//    @Test
//    public void cartIsPresent() throws InterruptedException {
//     //  Thread.sleep(1000);
//        driver.findElement(bajajDashboard.cart).isDisplayed();
//    }

    @Test
    public void productStackIsVisible() throws InterruptedException {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        Thread.sleep(3000);
        driver.findElement(bajajDashboard.productStackItem).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Buy electronic products online on EMIs - Bajaj Finserv");
    }

    @Test
    public void productStack_loans() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(bajajDashboard.productStackSwapper).isEnabled();
        driver.findElement(bajajDashboard.productStackSwapper).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productLoan));
        driver.findElement(bajajDashboard.productLoan).click();
        //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Choose and Apply for Instant Loans from Our Portfolio | Bajaj Finance");
    }

    @Test
    public void productStack_cards() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.findElement(bajajDashboard.productStackSwapper).isEnabled();
//        driver.findElement(bajajDashboard.productStackSwapper).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productCards));
        driver.findElement(bajajDashboard.productCards).click();
        //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "A range of easy EMI Cards - Insta EMI Card | Health EMI Network Card | SuperCard - Bajaj Finance");
    }

    @Test
    public void productStack_lifestyle() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        driver.findElement(bajajDashboard.productLifeStyle).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Buy Lifestyle Products Online on EMIs - Bajaj Finserv");
    }

    @Test
    public void productStac_insurance() {
        try {
            driver.findElement(bajajDashboard.productStack).isDisplayed();
            //  driver.findElement(bajajDashboard.productStackSwapper).click();
            driver.findElement(bajajDashboard.productInsurance).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
            String pgeTitle = driver.getTitle();
            System.out.println(pgeTitle);
            Assert.assertEquals(pgeTitle, "Buy electronic products online on EMIs - Bajaj Finserv");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_investments() throws InterruptedException {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productInvestments));
//        driver.findElement(bajajDashboard.productStackSwapper).click();
//        Thread.sleep(3000);
        driver.findElement(bajajDashboard.productInvestments).click();
        //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Start investing | Mutual funds | Fixed deposit | Systematic Investment Plan (SIP) | Systematic Deposit Plan (SDP)");
    }

    @Test
    public void productStack_HomeLoan() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        driver.findElement(bajajDashboard.productHomeLoan).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Choose from our wide range of products for home loan – Bajaj Finserv");
    }

    @Test
    public void productStack_DoctorWorld() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        driver.findElement(bajajDashboard.productDoctorWorld).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Choose from our wide range of products for doctors – Bajaj Finserv");
    }

    @Test
    public void productStack_MSMEWorld() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        driver.findElement(bajajDashboard.productMSME).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Choose from our wide range of products for MSMEs – Bajaj Finserv");
    }

    @Test
    public void productStack_TwoWheeler() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        driver.findElement(bajajDashboard.productTwoWheeler).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Two-wheeler Loan on EMI - Apply Online Instantly | Bajaj Finserv");
    }

    @Test
    public void productStack_AutoWorld() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productAutoWorld));
        driver.findElement(bajajDashboard.productAutoWorld).click();
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Choose From Our Wide Range of Loans for Automobiles - Bajaj Finance");
    }

    @Test
    public void productStack_TradingAccount() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        driver.findElement(bajajDashboard.productTrading).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Open Trading Account Online | Hassle-free Trading at Low Brokerage - Bajaj Broking");
    }

    @Test
    public void productStack_LoanAgainstSecurities() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
//        driver.findElement(bajajDashboard.productStackSwapper).click();
        driver.findElement(bajajDashboard.productSecurities).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Loan against Shares: Apply Online, Get up to Rs. 5 crore");
    }

    @Test
    public void productStack_PersonalLoan() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //   wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productPersonalLoan));
        driver.findElement(bajajDashboard.productStackSwapper).isEnabled();
        driver.findElement(bajajDashboard.productStackSwapper).click();
        //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productPersonalLoan));

        driver.findElement(bajajDashboard.productPersonalLoan).click();
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Personal Loan - Apply for Instant Personal Loan Online Of Up To Rs. 40 Lakh | Bajaj Finance Limited");
    }

    @Test
    public void productStack_OpenFD() throws InterruptedException {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(bajajDashboard.productStackSwapper).isEnabled();
        driver.findElement(bajajDashboard.productStackSwapper).click();
        boolean state = driver.findElement(bajajDashboard.productOpenFD).isDisplayed();
        if (state == false) {
            Thread.sleep(3000);
            driver.findElement(bajajDashboard.productStackSwapper).click();
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productOpenFD));
            driver.findElement(bajajDashboard.productOpenFD).click();
            //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
            String pgeTitle = driver.getTitle();
            System.out.println(pgeTitle);
            Assert.assertEquals(pgeTitle, "High Safety: FD Rates up to 8.85% p.a.");
        }
    }

//    @Test
//    public void maxProductStackCountShouldBe15(){
//        int productsCount= driver.findElements(bajajDashboard.productStackCount).size();
//        Assert.assertEquals(productsCount,16);
//    }
//
//    @Test
//    public void productStackNextShouldWork(){
//        boolean isEnable=driver.findElement(bajajDashboard.productStackSwapper).isEnabled();
//        System.out.println(isEnable);
//        Assert.assertEquals(isEnable,true);
//    }
//
//
////
//    @Test
//    public void signInIsPresent() throws InterruptedException {
//        driver.wait(2);
//        driver.findElement(bajajDashboard.signInBtn).isDisplayed();
//    }
//
//    @Test
//    public void emiCardIsPResent() {
//        driver.findElement(bajajDashboard.emiCardOption).isDisplayed();
//    }
//
//    @Test
//    public void notificationIsPresent() {
//        driver.findElement(bajajDashboard.notifications).isDisplayed();
//    }
//
//    @Test
//    public void userShouldSee_GetItNow() throws InterruptedException {
//        driver.findElement(bajajDashboard.emiCardOption).click();
//        //   wait(3);
//        String getItNowBtn = driver.findElement(bajajDashboard.getItNowBtn).getText();
//        Assert.assertEquals(getItNowBtn, "GET IT NOW");
//    }
//
//
//    @Test
//    public void takeScreenshot() {
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

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

}
