package GoogleTest2.google2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GoogleTest2.google2.pages.HomePage;

//@Listeners({GoogleTest2.google2.TestNGListerner.class})
public class SampleTestNgTest extends TestNgTestBase {

	private HomePage homepage;

	// @BeforeMethod
	// public void initPageObjects() {
	// homepage = PageFactory.initElements(driver, HomePage.class);
	// }
	private String URL;

	@BeforeSuite
	public void params() throws IOException {

		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(".\\src\\test\\resources\\variable.properties");

		prop.load(fs);

		URL = prop.getProperty("URL");
	}

	@BeforeTest
	public void setup() throws IOException {

		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		homepage = new HomePage(driver);
		driver.get(URL);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@Test
	public void assertPageTitle() {

		String title = homepage.searchItem("software tester");
		Assert.assertEquals(title, "Software Testing Jobs in Auckland - February 2021 | Indeed.com");

	}

	@AfterTest
	public void tearDown() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\test-output\\Final.png"));
		driver.close();
	}

}
