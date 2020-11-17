package Pages;

import Utils.ConfigurationReader;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
    @FindBy(xpath = "//input[@id='login']")
    private WebElement userNameInput;

    @FindBy(id = "//input[@id='password']")
    private WebElement passwordInput;

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperties("BriteerpURL"));
        userNameInput.sendKeys(ConfigurationReader.getProperties("BriteerpUsername"));
        passwordInput.sendKeys(ConfigurationReader.getProperties("BriteerpPassword")+ Keys.ENTER);
        WebElement homePage=Driver.getDriver().findElement(By.xpath("//li[contains(text(),'#Inbox')]"));
        if (homePage.isDisplayed()){
            System.out.println("You are on the Home Page. **Login Success** ");
        }else {
            System.out.println("You are not in the homepage **Login Failed**");
            throw new RuntimeException("**Login Failed**");
        }
    }

}
