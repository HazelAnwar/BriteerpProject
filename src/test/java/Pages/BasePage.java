package Pages;

import Utils.BrowserUtils;
import Utils.ConfigurationReader;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

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

    /**
     *
     * @param options : Discuss, Calender, Notes, Contact, CRM, Sales, Website, Inventory, Repairs,
     *                Events, Employees, Leaves, More
     */
    public void clickMenuBarOptions(String options){
        WebElement optionsOfMenuBar=Driver.getDriver().findElement(By.xpath("//span[contains(text(),'"+options+"')]"));
        BrowserUtils.clickWithWait(optionsOfMenuBar);

    }

}
