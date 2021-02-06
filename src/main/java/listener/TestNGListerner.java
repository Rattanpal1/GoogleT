package GoogleTest2.google2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class homePage {

	@FindBy(xpath = "//input[@name='q' and @type = 'text']")
	WebElement inputSearch;

	@FindBy(xpath = "//input[@name='q' and @type = 'text']")
	WebElement searchButton;

	@FindBy(xpath = "//a[@aria-label = 'Page 2']")
	WebElement pageNavigate;

	@FindBy(xpath = "//h3[@class='LC20lb DKV0Md']/span")
	WebElement secondLink;

	public homePage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(driver, this);	

	} ////NOOOOOOOOOOOOOOOOOOOO

	
}
