package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaHomeBasePage{

    public CarvanaHomeBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "a[target=\"_self\"]>svg")
    public WebElement carvanaLogo;

    @FindBy(css = "div[data-qa=\"menu-wrapper\"]>a")
    public List<WebElement> navigationSection;

    @FindBy(css = "div[class^=\"SignIn\"]>a")
    public WebElement signInButtonHomePage;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(css = "button[class^=\"button\"]")
    public WebElement continueButton;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(css = "button[class^=\"button\"]")
    public WebElement signInButton;

    @FindBy(css = "div[class^=\"error\"]>p")
    public WebElement errorMessage;

    @FindBy(css = "div[class^=\"HeaderMenu\"] > a:nth-child(1)")
    public WebElement searchCarsTab;

    @FindBy(css = "button[class^=\"Drop\"]")
    public List<WebElement> filterOptions;

}
