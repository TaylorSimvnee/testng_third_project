package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarSearchPage {

    public CarSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[data-qa='menu-flex'] button")
    public List<WebElement> filterOptions;

    @FindBy(css = "div[data-test='KeywordSuggestions'] input")
    public WebElement searchInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public  WebElement goButton;

    @FindBy(css = "div[class='result-tile']")
    public List<WebElement> tiles;

    @FindBy(css = ".vehicle-image")
    public List<WebElement> tilesImage;

    @FindBy(css = "div[class='favorite-vehicle']")
    public List<WebElement> tileFavoriteButton;

    @FindBy(css = "div[class ='make-model']")
    public List<WebElement> makeModel;

    @FindBy(css = ".trim-mileage")
    public List<WebElement> trimMileage;

    @FindBy(css = ".price ")
    public List<WebElement> price;

    @FindBy(css = ".monthly-payment")
    public List<WebElement> monthlyPayment;

    @FindBy(css = ".down-payment")
    public List<WebElement> downPayment;

    @FindBy(css = ".delivery-chip")
    public List<WebElement> deliveryChip;

}
