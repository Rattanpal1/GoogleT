package GoogleTest2.google2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GoogleTest2.google2.pages.HomePage;

public class SampleTestNgTest extends TestNgTestBase {

	private HomePage homepage;

	// @BeforeMethod
	// public void initPageObjects() {
	// homepage = PageFactory.initElements(driver, HomePage.class);
	// }

	@BeforeTest
	public void setup() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				".\\src\\test\\resources\\chromedriver.exe");
		
		
		driver = new ChromeDriver();
		homepage = new HomePage(driver);
				driver.get("https://www.google.com/");

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
	public void tearDown() {

		driver.close();
	}

}
