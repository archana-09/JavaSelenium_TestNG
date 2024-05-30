package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class bajajDashboard {
    public static By logo = By.className("r-header__logo");
    public static By cart = By.className("header-cart");
    public static  By signInBtn = By.id("header-sign-in_btn");
    public static By emiCardOption = By.className("header-emi-card__icon-box");
    public static By notifications = By.className("r-header__quick-cta-list__icon-box");
    public static By getItNowBtn =By.xpath("//button[text()='GET IT NOW']");
    public static By SignInModal = By.className("modal__content");

    //product stack
    public static By productStack =By.className("swiper-wrapper");
    public static By productStackItem = By.xpath("//p[ text() = \"Electronics on EMI\" ]");
    public static By productStackCount = By.xpath("//div[@class=\"swiper-wrapper\"]/a");
    public static By productStackSwapper = By.xpath("(//span[contains(@class, 'next') and contains(@class, 'swiper-button-next')])[1]");
    public static By productLoan = By.xpath("//a/p[ text() = \"Loans\"]");
    public static By productCards = By.xpath("//a/p[ text() = \"Cards\"]");
    public static By productLifeStyle = By.xpath("//p[ text() = \"Lifestyle on EMI\"]");
    public static By productInsurance = By.xpath("//p[ text() = \"Insurance\"]");
    public static By productInvestments = By.xpath("//a/p[ text() = \"Investments\"]");
    public static By productHomeLoan = By.xpath("//p[ text() = \"Home Loan World\"]");
    public static By productDoctorWorld = By.xpath("//p[ text() = \"Doctor World\"]");
    public static By productMSME = By.xpath("//p[ text() = \"MSME World\"]");
    public static By productTwoWheeler = By.xpath("//p[ text() = \"Two-wheeler\"]");
    public static By productAutoWorld = By.xpath("//a/p[ text() = \"Auto World\"]");
    public static By productTrading = By.xpath("//p[ text() = \"Trading Account\"]");
    public static By productSecurities = By.xpath("//p[ text() = \"Loan Against Securities\"]");
    public static By productPersonalLoan = By.xpath("(//p[contains(text(),'Personal Loan')])[1]");
    public static By productOpenFD = By.xpath("//p[ text() = \"Open FD\"]");

    //Payment UPI
    public static By bajajPay = By.xpath("//a/p[ text() = \"Bajaj Pay\"]");
    public static By UPI = By.xpath("//a/p[ text() = \"UPI\"]");
    public static By PayBills = By.xpath("//a/p[ text() = \"Pay Bills\"]");
    public static By FASTag = By.xpath("//a/p[ text() = \"Buy FASTag\"]");
    public static By emiCard = By.xpath("//a/p[ text() = \"EMI Card\"]");
    public static By bajajMall = By.xpath("//a/p[ text() = \"Bajaj Mall\"]");
    public static By stores = By.xpath("//a/p[ text() = \"Stores\"]");
    public static By offers = By.xpath("//div[@class=\"swiper-slide swiper-slide-next\"]//a/p[ text() = \"Offers\"]");
    public static By RBLBankCard = By.xpath("//a/p[ text() = \"RBL Bank SuperCard\"]");
    public static By DBSBankCard = By.xpath("//a/p[ text() = \"DBS Bank Credit Card\"]");
    public static By AllCards = By.xpath("//a/p[ text() = \"All Cards\"]");
    public static By bajajOffers = By.xpath("//a/p[ text() = \"Offers\"]/../..//../..//div[@class=\"swiper-slide\"]");

//Recharge
    public static By mobileRecharge= By.xpath("//p[normalize-space()='Mobile Recharge']");
    public static By ElectricityRecharge= By.xpath("//p[normalize-space()='Electricity']");
    public static By DTH= By.xpath("//p[normalize-space()='DTH']");
    public static By CCbill= By.xpath("//p[normalize-space()='Credit Card Bill']");
    public static By LPG= By.xpath("//p[normalize-space()='LPG Cylinder']");
    public static By loanPayment= By.xpath("//p[normalize-space()='Loan Repayment']");
    public static By FASTagRecharge= By.xpath("//p[normalize-space()='FASTag Recharge']");
    public static By insurancePayment= By.xpath("//p[normalize-space()='Mobile Recharge']");
    public static By PipedGas= By.xpath("//p[normalize-space()='Piped Gas']");
    public static By BroadbandRecharge= By.xpath("//p[normalize-space()='Broadband']");
    public static By AcsOnEMI= By.xpath("//p[normalize-space()='ACs']");
    public static By smartPhonesOnEMI= By.xpath("//p[normalize-space()='Smartphones']");
    public static By LEDTvs= By.xpath("//p[normalize-space()='LED TVs']");
    public static By Refrigerators= By.xpath("//p[normalize-space()='Refrigerators']");
    public static By coolers= By.xpath("//p[normalize-space()='Air Coolers']");
    public static By WashingMAchines= By.xpath("//p[normalize-space()='Washing Machines']");
    public static By GoldLoan= By.xpath("//p[normalize-space()='Gold Loan']");

         }
