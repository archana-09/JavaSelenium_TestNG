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






}
