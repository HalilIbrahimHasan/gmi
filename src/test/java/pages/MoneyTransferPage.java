package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MoneyTransferPage {

    public MoneyTransferPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@name='fromAccountId']")
    public WebElement fromAccountDropdown;

    @FindBy(xpath = "//*[@name='toAccountId']")
    public WebElement toAccountDropdown;

    @FindBy(xpath = "//*[@name='balance']")
    public WebElement balance;

    @FindBy(xpath = "(//*[@name='description'])[2]")
    public WebElement description;

    @FindBy(xpath = "//*[@id='make-transfer']")
    public WebElement makeMoneyTransferButton;

    @FindAll
    ( { @FindBy(xpath = "//*[text()='View Transaction']") } )
    public List <WebElement> transactions;

    @FindAll( {@FindBy(xpath = "//tbody/tr") } )
    public List <WebElement> accountIds;

    @FindAll( {@FindBy(xpath = "//tbody/tr/td[3]") } )
    public List <WebElement> accountBalances;

    @FindAll( {@FindBy(xpath = "(//tbody)[2]/tr/td[4]") } )
    public List <WebElement> transferDates;

    @FindAll( {@FindBy(xpath = "(//tbody)[2]/tr/td[5]") } )
    public List <WebElement> transferAmount;

    @FindAll( {@FindBy(xpath = "(//tbody)[2]/tr/td[6]") } )
    public List <WebElement> newBalance;

    @FindBy(xpath = "//*[text()='Transfer is succesfull']")
    public WebElement toastContainerValidationMessage;
}
