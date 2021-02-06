package GoogleTest2.google2;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  
  protected static String URL;
  protected WebDriver driver;
  String title;

  /*@BeforeSuite
  public void initTestSuite() throws IOException {
    SuiteConfiguration config = new SuiteConfiguration();
    URL = config.getProperty("site.url");
   
    //capabilities = config.getCapabilities();
  }

  @BeforeSuite
  public void initWebDriver() throws IOException {
	  
	  SuiteConfiguration config = new SuiteConfiguration();
	  
	  System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ranje\\OneDrive\\Documents\\Selenium\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		URL = config.getProperty("site.url");
		
		driver.get(URL);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  }
*/

  
  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
    WebDriverPool.DEFAULT.dismissAll();
  }
}
