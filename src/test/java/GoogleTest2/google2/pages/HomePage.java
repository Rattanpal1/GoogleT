package GoogleTest2.google2.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class HomePage extends Page {

	@FindBy(xpath = "//input[@name='q' and @type = 'text']")
	WebElement inputSearch;

	@FindBy(xpath = "//input[@name='q' and @type = 'text']")
	WebElement searchButton;

	@FindBy(xpath = "//a[@aria-label = 'Page 2']")
	WebElement pageNavigate;

	@FindBy(xpath = "//h3[@class='LC20lb DKV0Md']/span")
	WebElement secondPageLink;

	public HomePage(WebDriver webDriver) {
		super(webDriver);

		PageFactory.initElements(driver, this);

	}

	public String searchItem(String value) {

		String title;

		inputSearch.sendKeys(value);
		inputSearch.sendKeys(Keys.ENTER);
		// searchButton.click();

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 5000)");

		pageNavigate.click();
		secondPageLink.click();
		title = driver.getTitle();
		return title;

	}

}
