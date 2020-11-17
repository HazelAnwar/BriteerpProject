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
