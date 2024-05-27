import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.bajajDashboard;

public class bajaj_Tests {
    WebDriver driver;
       @BeforeMethod
       void setUp(){
       System.out.println("test");
        driver = new ChromeDriver();
        driver.get("https://www.bajajfinserv.in/");
        WebElement emiCardBtn = driver.findElement(By.className ("bar-icn-text"));
        emiCardBtn.click();
        WebElement getNowBtn = driver.findElement(By.xpath("//button[text()='GET IT NOW']"));
        getNowBtn.click();
        WebElement errorMsg = driver.findElement(By.xpath("//div[text()='Enter your 10-digit mobile number']"));
        Assert.assertEquals(errorMsg,"please enter your mobile number");
       }


    @Test
    public void productStackShouldBPresent(){
        driver.findElement(bajajDashboard.productStack).isDisplayed();
    }

    @Test
    public void chooseProduct(){
        driver.findElement(bajajDashboard.productStackItem).isEnabled();
        driver.findElement(bajajDashboard.productStackItem).click();
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }

    @Test
    public void testscript(String args[]){
      System.out.println("test");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.bajajfinserv.in/");
        WebElement emiCardBtn = driver.findElement(By.className ("bar-icn-text"));
        emiCardBtn.click();
        WebElement getNowBtn = driver.findElement(By.xpath("//button[text()='GET IT NOW']"));
        getNowBtn.click();
        WebElement errorMsg = driver.findElement(By.xpath("//div[text()='Enter your 10-digit mobile number']"));
        Assert.assertEquals(errorMsg,"please enter your mobile number");

    }
}




