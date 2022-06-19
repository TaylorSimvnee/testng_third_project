package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;


import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[data-qa= 'logo-wrapper']")
    public WebElement logo;

    @FindBy(xpath = "//div[@data-qa='navigation-wrapper']/div")
    public List<WebElement> mainNavigationItems;

    @FindBy(css = "div[data-qa='desktop-wrapper'] a")
    public WebElement signInButton;

    @FindBy(css = "div[data-cv-test='Header.Modal']")
    public WebElement signInModal;

    @FindBy(id = "usernameField")
    public WebElement emailInputBox;

    @FindBy(id = "passwordField")
    public WebElement passwordInputBox;

    @FindBy(css = "button[data-cv='sign-in-submit']")
    public WebElement signInModalButton;

    @FindBy(css = "div[data-qa='error-message-container']")
    public WebElement errorMessage;

    @FindBy(xpath = "(//div[@data-qa='header-items'])/a[1]")
    public WebElement searchCarsLink;


    public void navigationIsDisplayed(String str){
        for (WebElement mainNavigationItem : mainNavigationItems) {
            if (str.equals(mainNavigationItem.getText())){
                Assert.assertTrue(mainNavigationItem.isDisplayed());
               Assert.assertEquals(mainNavigationItem.getText() , str);
            }
        }
    }






}
