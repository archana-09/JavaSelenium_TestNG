package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class bajajDashboard {
    public static By logo = By.xpath("//a[@class='r-header__logo']");
    public static By cart = By.className("header-cart");
    public static  By signInBtn = By.id("header-sign-in_btn");
    public static By emiCardOption = By.className("header-emi-card__icon-box");
    public static By notifications = By.className("r-header__quick-cta-list__icon-box");
    public static By getItNowBtn =By.xpath("//button[text()='GET IT NOW']");


}
