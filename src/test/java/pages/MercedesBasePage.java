package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MercedesBasePage{

    public MercedesBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "picture[class=\"vehicle-image\"]")
    public List<WebElement> image;

    @FindBy(css = "svg[class=\"favorite-icon\"]")
    public List<WebElement> favoriteButton;

    @FindBy(css = "div[class='result-tile']")
    public List<WebElement> tileBody;

    @FindBy(css = "div[class^=\"inven\"]")
    public List<WebElement> inventoryType;

    @FindBy(css = "div[class^=\"make\"]")
    public List<WebElement> makeAndModel;

    @FindBy(css ="div[class=\"trim-mileage\"]")
    public List<WebElement> trimAndMileage;


    @FindBy(css = "div[data-testid=\"price\"]")
    public List<WebElement> price;

    @FindBy(css = "div[class=\"monthly-payment\"]")
    public List<WebElement> monthlyPayment;

    @FindBy(css ="div[class=\"down-payment\"]")
    public List<WebElement> downPayment;

    @FindBy(css ="div[class^=\"items-center\"]" )
    public List<WebElement> ship;



    @FindBy(css = "input[placeholder^=\"Search\"]")
    public WebElement searchButton;

    @FindBy(css = "button[class^='Key']")
    public WebElement goButton;

    @FindBy(css = "div[class^=\"HeaderMenu\"] > a:nth-child(1)")
    public WebElement searchCarsTab;

}
