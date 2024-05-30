package base;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
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

    @Test
    public void logoTest() throws InterruptedException {
        driver.findElement(bajajDashboard.logo).isDisplayed();
        System.out.println("passed");
    }

    @Test
    public void cartIsPresent() throws InterruptedException {
     //  Thread.sleep(1000);
        driver.findElement(bajajDashboard.cart).isDisplayed();
    }

    @Test
    public void productStackIsVisible() throws InterruptedException {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        Thread.sleep(3000);
        driver.findElement(bajajDashboard.productStackItem).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        Assert.assertEquals(pgeTitle, "Buy electronic products online on EMIs - Bajaj Finserv");
    }

    @Test
    public void productStack_loans() throws InterruptedException {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(bajajDashboard.productStackSwapper).isEnabled();
        driver.findElement(bajajDashboard.productStackSwapper).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productLoan));
        driver.findElement(bajajDashboard.productLoan).click();
        Thread.sleep(2000);
        //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
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
        driver.findElement(bajajDashboard.productInvestments).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        Assert.assertEquals(pgeTitle, "Start investing | Mutual funds | Fixed deposit | Systematic Investment Plan (SIP) | Systematic Deposit Plan (SDP)");
    }

    @Test
    public void productStack_HomeLoan() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        driver.findElement(bajajDashboard.productHomeLoan).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        Assert.assertEquals(pgeTitle, "Choose from our wide range of products for home loan – Bajaj Finserv");
    }

    @Test
    public void productStack_DoctorWorld() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        driver.findElement(bajajDashboard.productDoctorWorld).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        Assert.assertEquals(pgeTitle, "Choose from our wide range of products for doctors – Bajaj Finserv");
    }

    @Test
    public void productStack_MSMEWorld() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        driver.findElement(bajajDashboard.productMSME).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        Assert.assertEquals(pgeTitle, "Choose from our wide range of products for MSMEs – Bajaj Finserv");
    }

    @Test
    public void productStack_TwoWheeler() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        driver.findElement(bajajDashboard.productTwoWheeler).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        Assert.assertEquals(pgeTitle, "Two-wheeler Loan on EMI - Apply Online Instantly | Bajaj Finserv");
    }

    @Test
    public void productStack_AutoWorld() {
        driver.findElement(bajajDashboard.productStack).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productAutoWorld));
        driver.findElement(bajajDashboard.productAutoWorld).click();
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
        driver.findElement(bajajDashboard.productStackSwapper).isEnabled();
        driver.findElement(bajajDashboard.productStackSwapper).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productPersonalLoan));
        driver.findElement(bajajDashboard.productPersonalLoan).click();
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

    @Test
    public void bajajPay() {
        driver.findElement(bajajDashboard.bajajPay).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.bajajPay));
        driver.findElement(bajajDashboard.bajajPay).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "UPI, FASTag, Wallet, Gift Card, Bill Payment, Recharges on Bajaj Finserv");
    }

    @Test
    public void UpiPay() {
        driver.findElement(bajajDashboard.UPI).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.UPI));
        driver.findElement(bajajDashboard.UPI).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Make and Receive Payments using Bajaj Pay UPI");
    }

    @Test
    public void payBills() {
        driver.findElement(bajajDashboard.PayBills).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.PayBills));
        driver.findElement(bajajDashboard.PayBills).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        Assert.assertTrue(driver.findElement(bajajDashboard.SignInModal).isDisplayed());

    }

    @Test
    public void FASTag() {
        driver.findElement(bajajDashboard.FASTag).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.PayBills));
        driver.findElement(bajajDashboard.FASTag).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));

    }

    @Test
    public void mobileRecharge() {
        driver.findElement(bajajDashboard.mobileRecharge).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.mobileRecharge));
        driver.findElement(bajajDashboard.mobileRecharge).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));

    }
    @Test
    public void ElectricityRecharge() {
        driver.findElement(bajajDashboard.ElectricityRecharge).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.ElectricityRecharge));
        driver.findElement(bajajDashboard.ElectricityRecharge).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));

    }
    @Test
    public void DTH() {
        driver.findElement(bajajDashboard.DTH).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.DTH));
        driver.findElement(bajajDashboard.DTH).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));

    }
    @Test
    public void CredCardBill() {
        driver.findElement(bajajDashboard.CCbill).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.CCbill));
        driver.findElement(bajajDashboard.CCbill).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));

    }
    @Test
    public void LPGPayment() {
        driver.findElement(bajajDashboard.LPG).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.LPG));
        driver.findElement(bajajDashboard.LPG).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));

    }
    @Test
    public void loanPayment() {
        driver.findElement(bajajDashboard.loanPayment).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.loanPayment));
        driver.findElement(bajajDashboard.loanPayment).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));

    }

    @Test
    public void FASTagRecharge() {
        driver.findElement(bajajDashboard.FASTagRecharge).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.FASTagRecharge));
        driver.findElement(bajajDashboard.FASTagRecharge).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));

    }
//    @Test
//    public void insurancePayment() {
//        driver.findElement(bajajDashboard.insurancePayment).isDisplayed();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.insurancePayment));
//        driver.findElement(bajajDashboard.insurancePayment).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
//
//    }

    @Test
    public void PipedGas() {
        driver.findElement(bajajDashboard.PipedGas).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.PipedGas));
        driver.findElement(bajajDashboard.PipedGas).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));

    }

    @Test
    public void BroadbandRecharge() {
        driver.findElement(bajajDashboard.BroadbandRecharge).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.BroadbandRecharge));
        driver.findElement(bajajDashboard.BroadbandRecharge).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));

    }
    @Test
    public void emiCard() {
        driver.findElement(bajajDashboard.emiCard).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.emiCard));
        driver.findElement(bajajDashboard.emiCard).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Bajaj Finserv Insta EMI Card: Apply EMI Card Online!");
    }
    @Test
    public void AcsOnEMI() {
        driver.findElement(bajajDashboard.AcsOnEMI).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.AcsOnEMI));
        driver.findElement(bajajDashboard.AcsOnEMI).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='plp-Breadcrumb']")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Bajaj Finserv Insta EMI Card: Apply EMI Card Online!");
    }
    @Test
    public void smartPhones() {
        driver.findElement(bajajDashboard.smartPhonesOnEMI).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.smartPhonesOnEMI));
        driver.findElement(bajajDashboard.smartPhonesOnEMI).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Bajaj Finserv Insta EMI Card: Apply EMI Card Online!");
    }
    @Test
    public void LEDs() {
        driver.findElement(bajajDashboard.LEDTvs).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.LEDTvs));
        driver.findElement(bajajDashboard.LEDTvs).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='plp-Breadcrumb']")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Bajaj Finserv Insta EMI Card: Apply EMI Card Online!");
    }
    @Test
    public void Refrigerators() {
        driver.findElement(bajajDashboard.Refrigerators).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.Refrigerators));
        driver.findElement(bajajDashboard.Refrigerators).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='plp-Breadcrumb']")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Bajaj Finserv Insta EMI Card: Apply EMI Card Online!");
    }
    @Test
    public void coolers() {
        driver.findElement(bajajDashboard.coolers).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.coolers));
        driver.findElement(bajajDashboard.coolers).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='plp-Breadcrumb']")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Bajaj Finserv Insta EMI Card: Apply EMI Card Online!");
    }
    @Test
    public void WashingMachine() {
        driver.findElement(bajajDashboard.WashingMAchines).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.WashingMAchines));
        driver.findElement(bajajDashboard.WashingMAchines).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='plp-Breadcrumb']")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Bajaj Finserv Insta EMI Card: Apply EMI Card Online!");
    }
    @Test
    public void GoldLoan() {
        driver.findElement(bajajDashboard.GoldLoan).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.GoldLoan));
        driver.findElement(bajajDashboard.GoldLoan).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Gold Loan - Apply Loan Against Gold Online In India | Up to Rs. 2 crore – Bajaj Finserv Gold Loan");
    }
    @Test
    public void bajajMall() {
        driver.findElement(bajajDashboard.bajajMall).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.bajajMall));
        driver.findElement(bajajDashboard.bajajMall).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"wzrk_wrapper\"]")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Bajaj Finserv: Loans, Cards, Insurance, Investments, Payments and more");
    }

    @Test
    public void stores() {
        driver.findElement(bajajDashboard.stores).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.stores));
        driver.findElement(bajajDashboard.stores).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Store Locator: Bajaj Finserv EMI Card Accepted Shops Near You");
    }

    @Test
    public void offers() {
        driver.findElement(bajajDashboard.offers).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.offers));
        driver.findElement(bajajDashboard.offers).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "The Best Offers on Bajaj Mall - Exciting Deals and No Cost EMIs");
    }

    @Test
    public void RBLBankSuperCard() throws InterruptedException {
        driver.findElement(bajajDashboard.RBLBankCard).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.RBLBankCard));
        driver.findElement(bajajDashboard.RBLBankCard).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[ text() = \"Bajaj Finserv RBL Bank Binge SuperCard - First-Year-Free\"]")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Apply for Credit Cards Online in India with Instant Approval - Bajaj Finserv RBL Credit Card");

    }

    @Test
    public void DBSBankCard() throws InterruptedException {
        driver.findElement(bajajDashboard.DBSBankCard).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.DBSBankCard));
        driver.findElement(bajajDashboard.DBSBankCard).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[ text() = \"Bajaj Finserv DBS Bank 5X Plus Rewards Credit Card - First-Year-Free\"]")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Apply for Bajaj Finserv DBS Credit Card with Instant Approval Online");
    }

    @Test
    public void RblOffers() throws InterruptedException {
        driver.findElement(bajajDashboard.bajajOffers).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.bajajOffers));
        driver.findElement(bajajDashboard.bajajOffers).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"breadcrumsGTM\"]/span")));
        String pgeTitle = driver.getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Apply for Bajaj Finserv DBS Credit Card with Instant Approval Online");
    }

    @Test
    public void AllCards() {
        driver.findElement(bajajDashboard.AllCards).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.AllCards));
        driver.findElement(bajajDashboard.AllCards).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        Assert.assertTrue(driver.findElement(bajajDashboard.SignInModal).isDisplayed());
    }


    @Test
    public void maxProductStackCountShouldBe15(){
        int productsCount= driver.findElements(bajajDashboard.productStackCount).size();
        Assert.assertEquals(productsCount,16);
    }

    @Test
    public void productStackNextShouldWork(){
        boolean isEnable=driver.findElement(bajajDashboard.productStackSwapper).isEnabled();
        System.out.println(isEnable);
        Assert.assertEquals(isEnable,true);
    }


//
    @Test
    public void signInIsPresent() throws InterruptedException {
        driver.wait(5);
        driver.findElement(bajajDashboard.signInBtn).isDisplayed();
    }

    @Test
    public void emiCardIsPResent() {
        driver.findElement(bajajDashboard.emiCardOption).isDisplayed();
    }

    @Test
    public void notificationIsPresent() {
        driver.findElement(bajajDashboard.notifications).isDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

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

}
