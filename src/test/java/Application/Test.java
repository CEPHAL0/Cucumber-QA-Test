package Application;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import java.time.Duration;

import PageObject.*;

import static com.codeborne.selenide.Selenide.closeWindow;


public class Test {

    public LoginFile loginPage;

    public void openBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginFile();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        WebDriverRunner.setWebDriver(driver);
    }

    public void goToSauce(){
        System.out.print("Redirected");
    }

    public void enterCredential(String username, String password){
        loginPage.enterUsername().should(Condition.appear, Duration.ofSeconds(30)).sendKeys(username);
        loginPage.enterPassword().sendKeys(password);
    }

    public void clickLoginButton(){
        loginPage.loginButton().should(Condition.appear, Duration.ofSeconds(5)).click();
    }

    public static void closeBrowser(){
        closeWindow();
    }

    public void dashboardOpen(){
        loginPage.goToDashboard().isDisplayed();
    }


}
