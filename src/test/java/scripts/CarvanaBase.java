package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CarvanaHomeBasePage;
import pages.MercedesBasePage;
import utilities.ConfigReader;
import utilities.Driver;

public class CarvanaBase {

    WebDriver driver;
    SoftAssert softAssert;
    CarvanaHomeBasePage carvanaHomeBasePage;
    MercedesBasePage mercedesBasePage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        driver.get(ConfigReader.getProperty("appURL"));


    }

    @AfterMethod
    public void teardown(){
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
