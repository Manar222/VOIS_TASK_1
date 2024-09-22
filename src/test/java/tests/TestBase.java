package tests;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utilities.Helper;
//import utilities.Helper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestBase {

    public static WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));
        driver.get("http://amazon.eg/");
       HomePage homePage = new HomePage(driver);
    }



    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("test failed: " + result.getName());
            System.out.println("taking screenshot");
           Helper.takeScreenShot(driver, result.getName());
        }
        driver.close();
    }




}