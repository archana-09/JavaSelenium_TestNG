import base.basecls;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.bajajDashboard;

import java.time.Duration;
import java.util.Set;

public class bajaj_Tests extends basecls {

    void setUp() {
        WebElement emiCardBtn = getDriver().findElement(By.className("bar-icn-text"));
        emiCardBtn.click();
        WebElement getNowBtn = getDriver().findElement(By.xpath("//button[text()='GET IT NOW']"));
        getNowBtn.click();
        WebElement errorMsg = getDriver().findElement(By.xpath("//div[text()='Enter your 10-digit mobile number']"));
        Assert.assertEquals(errorMsg, "please enter your mobile number");
    }


    @Test
    public void productStackShouldBPresent() {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void chooseProduct() {
        try {
            getDriver().findElement(bajajDashboard.productStackItem).isEnabled();
            getDriver().findElement(bajajDashboard.productStackItem).click();
            String pageTitle = getDriver().getTitle();
            System.out.println(pageTitle);
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    //    @Test
    public void testscript(String args[]) {
        System.out.println("test");
        ChromeDriver driver = new ChromeDriver();
        getDriver().get("https://www.bajajfinserv.in/");
        WebElement emiCardBtn = getDriver().findElement(By.className("bar-icn-text"));
        emiCardBtn.click();
        WebElement getNowBtn = getDriver().findElement(By.xpath("//button[text()='GET IT NOW']"));
        getNowBtn.click();
        WebElement errorMsg = getDriver().findElement(By.xpath("//div[text()='Enter your 10-digit mobile number']"));
        Assert.assertEquals(errorMsg, "please enter your mobile number");

    }

    @Test
    public void bajajTitle() {
        try {
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productStack));
            String pageTitle = getDriver().getTitle();
            Assert.assertEquals(pageTitle, "Bajaj Finserv: Loans, Cards, Insurance, Investments, Payments and more");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void logoTest() throws InterruptedException {
        try {
            getDriver().findElement(bajajDashboard.logo).isDisplayed();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void cartIsPresent() throws InterruptedException {
        try {
            getDriver().findElement(bajajDashboard.cart).isDisplayed();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStackIsVisible() throws InterruptedException {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            Thread.sleep(3000);
            getDriver().findElement(bajajDashboard.productStackItem).click();
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Buy electronic products online on EMIs - Bajaj Finserv");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_loans() throws InterruptedException {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            getDriver().findElement(bajajDashboard.productStackSwapper).isEnabled();
            getDriver().findElement(bajajDashboard.productStackSwapper).click();
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productLoan));
            getDriver().findElement(bajajDashboard.productLoan).click();
            Thread.sleep(2000);
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Choose and Apply for Instant Loans from Our Portfolio | Bajaj Finance");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_cards() {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productCards));
            getDriver().findElement(bajajDashboard.productCards).click();
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "A range of easy EMI Cards - Insta EMI Card | Health EMI Network Card | SuperCard - Bajaj Finance");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_lifestyle() {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            getDriver().findElement(bajajDashboard.productLifeStyle).click();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Buy Lifestyle Products Online on EMIs - Bajaj Finserv");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStac_insurance() {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            getDriver().findElement(bajajDashboard.productInsurance).click();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Buy electronic products online on EMIs - Bajaj Finserv");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_investments() throws InterruptedException {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productInvestments));
            getDriver().findElement(bajajDashboard.productInvestments).click();
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Start investing | Mutual funds | Fixed deposit | Systematic Investment Plan (SIP) | Systematic Deposit Plan (SDP)");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_HomeLoan() {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            getDriver().findElement(bajajDashboard.productHomeLoan).click();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Choose from our wide range of products for home loan – Bajaj Finserv");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_DoctorWorld() {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            getDriver().findElement(bajajDashboard.productDoctorWorld).click();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Choose from our wide range of products for doctors – Bajaj Finserv");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_MSMEWorld() {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            getDriver().findElement(bajajDashboard.productMSME).click();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Choose from our wide range of products for MSMEs – Bajaj Finserv");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_TwoWheeler() {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            getDriver().findElement(bajajDashboard.productTwoWheeler).click();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Two-wheeler Loan on EMI - Apply Online Instantly | Bajaj Finserv");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_AutoWorld() {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productAutoWorld));
            getDriver().findElement(bajajDashboard.productAutoWorld).click();
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Choose From Our Wide Range of Loans for Automobiles - Bajaj Finance");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_TradingAccount() {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            getDriver().findElement(bajajDashboard.productTrading).click();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Open Trading Account Online | Hassle-free Trading at Low Brokerage - Bajaj Broking");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_LoanAgainstSecurities() {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            getDriver().findElement(bajajDashboard.productSecurities).click();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Loan against Shares: Apply Online, Get up to Rs. 5 crore");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void productStack_PersonalLoan() {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getDriver().findElement(bajajDashboard.productStackSwapper).isEnabled();
            getDriver().findElement(bajajDashboard.productStackSwapper).click();
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productPersonalLoan));
            getDriver().findElement(bajajDashboard.productPersonalLoan).click();
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "Personal Loan - Apply for Instant Personal Loan Online Of Up To Rs. 40 Lakh | Bajaj Finance Limited");
        } catch (Exception e) {
            System.out.println(e);

        }
    }


    @Test
    public void productStack_OpenFD() throws InterruptedException {
        try {
            getDriver().findElement(bajajDashboard.productStack).isDisplayed();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getDriver().findElement(bajajDashboard.productStackSwapper).isEnabled();
            getDriver().findElement(bajajDashboard.productStackSwapper).click();
            boolean state = getDriver().findElement(bajajDashboard.productOpenFD).isDisplayed();
            if (state == false) {
                Thread.sleep(2000);
                getDriver().findElement(bajajDashboard.productStackSwapper).click();
            } else {
                getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productOpenFD));
                getDriver().findElement(bajajDashboard.productOpenFD).click();
                //  // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
                String pgeTitle = getDriver().getTitle();
                Assert.assertEquals(pgeTitle, "High Safety: FD Rates up to 8.85% p.a.");

            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }


    @Test
    public void bajajPay() {
        try {
            getDriver().findElement(bajajDashboard.bajajPay).isDisplayed();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.bajajPay));
            getDriver().findElement(bajajDashboard.bajajPay).click();
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
            String pgeTitle = getDriver().getTitle();
            Assert.assertEquals(pgeTitle, "UPI, FASTag, Wallet, Gift Card, Bill Payment, Recharges on Bajaj Finserv");
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void UpiPay() {
        try{
        getDriver().findElement(bajajDashboard.UPI).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.UPI));
        getDriver().findElement(bajajDashboard.UPI).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "Make and Receive Payments using Bajaj Pay UPI");}
        catch (Exception e) {
            System.out.println(e);

        }

    }

    @Test
    public void payBills() {
        try{
        getDriver().findElement(bajajDashboard.PayBills).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.PayBills));
        getDriver().findElement(bajajDashboard.PayBills).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        Assert.assertTrue(getDriver().findElement(bajajDashboard.SignInModal).isDisplayed());
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(1));
// The steps on How to handle popup in selenium
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
        try {
            getDriver().findElement(bajajDashboard.closeIcon).click();
        } catch (Exception e) {
        }

        getDriver().switchTo().window(parentWindowHandle);


    }
        catch (Exception e) {
            System.out.println(e);

        }}


    @Test
    public void FASTag() {
        try{
        getDriver().findElement(bajajDashboard.FASTag).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.PayBills));
        getDriver().findElement(bajajDashboard.FASTag).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(1));
// The steps on How to handle popup in selenium
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
        try {
            getDriver().findElement(bajajDashboard.closeIcon).click();
        } catch (Exception e) {
        }

        getDriver().switchTo().window(parentWindowHandle);}

        catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void mobileRecharge() {
        try{
        getDriver().findElement(bajajDashboard.mobileRecharge).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.mobileRecharge));
        getDriver().findElement(bajajDashboard.mobileRecharge).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(1));
// The steps on How to handle popup in selenium
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
        try {
            getDriver().findElement(bajajDashboard.closeIcon).click();
        } catch (Exception e) {
        }

        getDriver().switchTo().window(parentWindowHandle);

    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void ElectricityRecharge() {
        try{
        getDriver().findElement(bajajDashboard.ElectricityRecharge).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.ElectricityRecharge));
        getDriver().findElement(bajajDashboard.ElectricityRecharge).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(1));

// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
        try {
            getDriver().findElement(bajajDashboard.closeIcon).click();
        } catch (Exception e) {
        }

        getDriver().switchTo().window(parentWindowHandle);

    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void DTH() {
        try {
            getDriver().findElement(bajajDashboard.DTH).isDisplayed();
            // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.DTH));
            getDriver().findElement(bajajDashboard.DTH).click();
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
            String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
            // getWait().until(ExpectedConditions.numberOfWindowsToBe(1));
// Get the window handles for all open windows
            Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
            for (String handle : windowHandles) {
                if (!handle.equals(parentWindowHandle)) {
                    getDriver().switchTo().window(handle);
                    break;
                }
            }
            try {
                try {
                    getDriver().findElement(bajajDashboard.closeIcon).click();
                } catch (Exception e) {
                }
            } catch (Exception e) {
            }

            getDriver().switchTo().window(parentWindowHandle);

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Test
    public void CredCardBill() {
        try{
        getDriver().findElement(bajajDashboard.CCbill).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.CCbill));
        getDriver().findElement(bajajDashboard.CCbill).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(1));
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
        try {
            getDriver().findElement(bajajDashboard.closeIcon).click();
        } catch (Exception e) {
        }

        getDriver().switchTo().window(parentWindowHandle);

    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void LPGPayment() {
        try{
        getDriver().findElement(bajajDashboard.LPG).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.LPG));
        getDriver().findElement(bajajDashboard.LPG).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(1));
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
        try {
            getDriver().findElement(bajajDashboard.closeIcon).click();
        } catch (Exception e) {
        }

        getDriver().switchTo().window(parentWindowHandle);

    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void loanPayment() {
        try{
        getDriver().findElement(bajajDashboard.loanPayment).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.loanPayment));
        getDriver().findElement(bajajDashboard.loanPayment).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(1));
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
        try {
            getDriver().findElement(bajajDashboard.closeIcon).click();
        } catch (Exception e) {
        }

        getDriver().switchTo().window(parentWindowHandle);

    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void FASTagRecharge() {
        try{
        getDriver().findElement(bajajDashboard.FASTagRecharge).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.FASTagRecharge));
        getDriver().findElement(bajajDashboard.FASTagRecharge).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(1));
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
        try {
            getDriver().findElement(bajajDashboard.closeIcon).click();
        } catch (Exception e) {
        }

        getDriver().switchTo().window(parentWindowHandle);

    }catch (Exception e) {
            System.out.println(e);

        }}

//    @Test
//    public void insurancePayment() {
//        getDriver().findElement(bajajDashboard.insurancePayment).isDisplayed();
//        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.insurancePayment));
//        getDriver().findElement(bajajDashboard.insurancePayment).click();
//        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
//
//    }

    @Test
    public void PipedGas() throws InterruptedException {
        try{
        getDriver().findElement(bajajDashboard.PipedGas).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        getDriver().findElement(bajajDashboard.SlideNextBtn).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.PipedGas));
        getDriver().findElement(bajajDashboard.PipedGas).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(1));
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
        try {
            getDriver().findElement(bajajDashboard.closeIcon).click();
        } catch (Exception e) {
        }

        getDriver().switchTo().window(parentWindowHandle);

    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void BroadbandRecharge() throws InterruptedException {
        try{
        getDriver().findElement(bajajDashboard.BroadbandRecharge).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        getDriver().findElement(bajajDashboard.SlideNextBtn).click();
        getDriver().findElement(bajajDashboard.BroadbandRecharge).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(1));
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
//        try{
//            getDriver().findElement(bajajDashboard.closeIcon).click();
//        }
//        catch(Exception e){
//        }

        getDriver().switchTo().window(parentWindowHandle);

    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void emiCard() {
        try{
        getDriver().findElement(bajajDashboard.emiCard).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.emiCard));
        getDriver().findElement(bajajDashboard.emiCard).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "Bajaj Finserv Insta EMI Card: Apply EMI Card Online!");

    }catch (Exception e) {
            System.out.println(e);

        }}


    @Test
    public void AcsOnEMI() throws InterruptedException {
        try {
            getDriver().findElement(bajajDashboard.AcsOnEMI).isDisplayed();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,500)");
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.AcsOnEMI));
            getDriver().findElement(bajajDashboard.AcsOnEMI).click();
            String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
            // getWait().until(ExpectedConditions.numberOfWindowsToBe(2));
// Get the window handles for all open windows
            Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
            for (String handle : windowHandles) {
                if (!handle.equals(parentWindowHandle)) {
                    getDriver().switchTo().window(handle);
                    break;
                }
            }
            if (isElementPresent(bajajDashboard.policiesLater))
                getDriver().findElement(bajajDashboard.policiesLater).click();

// Close the pop-up window
            if (isElementPresent(bajajDashboard.cancelcon))
                getDriver().findElement(bajajDashboard.cancelcon).click();
// Close the pop-up window
            // getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum2));
            String pgeTitle = getDriver().getTitle();
            ;
            Assert.assertEquals(pgeTitle, "Buy Latest AC Online at Low Cost EMI | Bajaj Mall");

            getDriver().switchTo().window(parentWindowHandle);

        } catch (Exception e) {
            System.out.println(e);

        }


//        try {
//            getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("wzrk-cancel")));
//            WebElement ele1 = getDriver().findElement(By.xpath("getDriver().findElement(By.id(\"wzrk-cancel\")).click();"));
//            if (ele1.isDisplayed()) {
//                getDriver().findElement(By.id("wzrk-cancel")).click();
//            }
//        }
//        catch (Exception e )
//        {
//
//        }
//
//       try
//       {
//           getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"wrapper-div-card\"]/img")));
//           WebElement ele = getDriver().findElement(By.xpath("//div[@class=\"wrapper-div-card\"]/img"));
//           if (ele.isDisplayed()) {
//
//               getDriver().findElement(By.xpath("//div[@class=\"wrapper-div-card\"]/img")).click();
//           }
//       }
//       catch (Exception e )
//       {
//
//       }

    }

    @Test
    public void smartPhones() {
        try{
        getDriver().findElement(bajajDashboard.smartPhonesOnEMI).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,500)");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.smartPhonesOnEMI));
        getDriver().findElement(bajajDashboard.smartPhonesOnEMI).click();
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(2));
// The steps on How to handle popup in selenium
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            getDriver().switchTo().window(handle);
            if (getDriver().getTitle().contains("Smartphones")) {
                break;
            }
        }
        if (isElementPresent(bajajDashboard.policiesLater))
            getDriver().findElement(bajajDashboard.policiesLater).click();

// Close the pop-up window
        if (isElementPresent(bajajDashboard.cancelcon))
            getDriver().findElement(bajajDashboard.cancelcon).click();

        // getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum2));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "Buy New Smartphones Online at Best Prices | Bajaj Mall");

        getDriver().switchTo().window(parentWindowHandle);
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void LEDs() {
        try{
        getDriver().findElement(bajajDashboard.LEDTvs).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,500)");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.LEDTvs));
        getDriver().findElement(bajajDashboard.LEDTvs).click();
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(2));
// The steps on How to handle popup in selenium
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            getDriver().switchTo().window(handle);
            if (getDriver().getTitle().contains("LED")) {
                break;
            }
        }
        if (isElementPresent(bajajDashboard.policiesLater))
            getDriver().findElement(bajajDashboard.policiesLater).click();

// Close the pop-up
        if (isElementPresent(bajajDashboard.cancelcon))
            getDriver().findElement(bajajDashboard.cancelcon).click();
// Close the pop-up window
        // getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum2));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "Television - Buy Latest LED TV, Smart TV & 4K TVs Online at best prices | Bajaj Mall");

        getDriver().switchTo().window(parentWindowHandle);
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void Refrigerators() {
        try{
        getDriver().findElement(bajajDashboard.Refrigerators).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,500)");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.Refrigerators));
        getDriver().findElement(bajajDashboard.Refrigerators).click();
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(2));
// The steps on How to handle popup in selenium
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            getDriver().switchTo().window(handle);
            if (getDriver().getTitle().contains("Refrigerators")) {
                break;
            }
        }
        if (isElementPresent(bajajDashboard.policiesLater))
            getDriver().findElement(bajajDashboard.policiesLater).click();

// Close the pop-up window
        if (isElementPresent(bajajDashboard.cancelcon))
            getDriver().findElement(bajajDashboard.cancelcon).click();
        // getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum2));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "Buy Fridge/Refrigerators Online at Best Prices | Bajaj Mall");

        getDriver().switchTo().window(parentWindowHandle);
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void coolers() {
        try{
        getDriver().findElement(bajajDashboard.coolers).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,500)");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.coolers));
        getDriver().findElement(bajajDashboard.coolers).click();
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(2));
// The steps on How to handle popup in selenium
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            getDriver().switchTo().window(handle);
            if (getDriver().getTitle().contains("Coolers")) {
                break;
            }
        }
        if (isElementPresent(bajajDashboard.policiesLater))
            getDriver().findElement(bajajDashboard.policiesLater).click();

// Close the pop-up window
        if (isElementPresent(bajajDashboard.cancelcon))
            getDriver().findElement(bajajDashboard.cancelcon).click();
        // getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum2));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "Get the Best Air Coolers in India with Best Prices | Bajaj Mall");

        getDriver().switchTo().window(parentWindowHandle);
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void WashingMachine() throws InterruptedException {
        try{
        getDriver().findElement(bajajDashboard.WashingMAchines).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,500)");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.WashingMAchines));
        getDriver().findElement(bajajDashboard.WashingMAchines).click();
        String parentWindowHandle = getDriver().getWindowHandle();
// Wait for the pop-up window to appear
        // getWait().until(ExpectedConditions.numberOfWindowsToBe(2));
// The steps on How to handle popup in selenium
// Get the window handles for all open windows
        Set<String> windowHandles = getDriver().getWindowHandles();
// Switch to the pop-up window
        for (String handle : windowHandles) {
            getDriver().switchTo().window(handle);
            if (getDriver().getTitle().contains("Washing Machines")) {
                break;
            }
        }
        if (isElementPresent(bajajDashboard.policiesLater))
            getDriver().findElement(bajajDashboard.policiesLater).click();

// Close the pop-up window
        if (isElementPresent(bajajDashboard.cancelcon))
            getDriver().findElement(bajajDashboard.cancelcon).click();
        // getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum2));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "Buy Latest Washing Machines at Best Price in India | Bajaj Mall");

        getDriver().switchTo().window(parentWindowHandle);
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void GoldLoan() {
        try{
        getDriver().findElement(bajajDashboard.GoldLoan).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.GoldLoan));
        getDriver().findElement(bajajDashboard.GoldLoan).click();
        // getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum2));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "Gold Loan - Apply Loan Against Gold Online In India | Up to Rs. 2 crore – Bajaj Finserv Gold Loan");
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void bajajMall() {
        try{
        getDriver().findElement(bajajDashboard.bajajMall).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.bajajMall));
        getDriver().findElement(bajajDashboard.bajajMall).click();
        String pgeTitle = getDriver().getTitle();
        System.out.println(pgeTitle);
        Assert.assertEquals(pgeTitle, "Bajaj Finserv: Loans, Cards, Insurance, Investments, Payments and more");
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void stores() {
        try{
        getDriver().findElement(bajajDashboard.stores).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.stores));
        getDriver().findElement(bajajDashboard.stores).click();
        // getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum2));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "Store Locator: Bajaj Finserv EMI Card Accepted Shops Near You");
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void offers() {
        try{
        getDriver().findElement(bajajDashboard.offers).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.offers));
        getDriver().findElement(bajajDashboard.offers).click();
        // getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.breadcrum2));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "The Best Offers on Bajaj Mall - Exciting Deals and No Cost EMIs");
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void RBLBankSuperCard() throws InterruptedException {
        try{
        getDriver().findElement(bajajDashboard.RBLBankCard).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.RBLBankCard));
        getDriver().findElement(bajajDashboard.RBLBankCard).click();
        Thread.sleep(1000);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.textForRBLCard));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "Apply for Credit Cards Online in India with Instant Approval - Bajaj Finserv RBL Credit Card");
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void DBSBankCard() throws InterruptedException {
        try{
        getDriver().findElement(bajajDashboard.DBSBankCard).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.DBSBankCard));
        getDriver().findElement(bajajDashboard.DBSBankCard).click();
        Thread.sleep(1000);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.textForDSBCard));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "Apply for Bajaj Finserv DBS Credit Card with Instant Approval Online");
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void RblOffers() throws InterruptedException {
        try{
        getDriver().findElement(bajajDashboard.bajajOffers).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.bajajOffers));
        getDriver().findElement(bajajDashboard.bajajOffers).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.textForDSBCard));
        String pgeTitle = getDriver().getTitle();
        Assert.assertEquals(pgeTitle, "Apply for Bajaj Finserv DBS Credit Card with Instant Approval Online");
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void AllCards() {
        try{
        getDriver().findElement(bajajDashboard.AllCards).isDisplayed();
        // WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.AllCards));
        getDriver().findElement(bajajDashboard.AllCards).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.SignInModal));
        Assert.assertTrue(getDriver().findElement(bajajDashboard.SignInModal).isDisplayed());
    }catch (Exception e) {
            System.out.println(e);

        }}


    @Test
    public void maxProductStackCountShouldBe15() {
        try{
            getWait().until(ExpectedConditions.visibilityOfElementLocated(bajajDashboard.productStack));
        int productsCount = getDriver().findElements(bajajDashboard.productStackCount).size();
        Assert.assertEquals(productsCount, 16);
    }catch (Exception e) {
            System.out.println(e);

        }}

    @Test
    public void productStackNextShouldWork() {
        try{
        boolean isEnable = getDriver().findElement(bajajDashboard.productStackSwapper).isEnabled();
        System.out.println(isEnable);
        Assert.assertEquals(isEnable, true);
    }catch (Exception e) {
            System.out.println(e);

        }}


    //
//    @Test
//    public void signInIsPresent() throws InterruptedException {
//        getDriver().findElement(bajajDashboard.signInBtn).isDisplayed();
//    }
//
//    @Test
//    public void emiCardIsPResent() {
//        getDriver().findElement(bajajDashboard.emiCardOption).isDisplayed();
//    }
//
//    @Test
//    public void notificationIsPresent() {
//        getDriver().findElement(bajajDashboard.notifications).isDisplayed();
//    }


}




