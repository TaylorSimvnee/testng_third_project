package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CarSearchPage;
import pages.HomePage;
import utilities.Driver;

public class Base {
    //instance variables
    WebDriver driver;
    WebDriverWait explicitWait;
    SoftAssert softAssert;
    HomePage homePage;
    CarSearchPage carSearchPage;



    @BeforeMethod(alwaysRun = true)
    public void setup(){
        driver = Driver.getDriver();
        explicitWait = new WebDriverWait(driver, 30);
        softAssert = new SoftAssert();
        homePage = new HomePage();
        carSearchPage = new CarSearchPage();


    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        softAssert.assertAll();
        Driver.quitDriver();
    }
}

