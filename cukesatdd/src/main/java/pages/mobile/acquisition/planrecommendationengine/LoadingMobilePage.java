/**
* 
 */
package pages.mobile.acquisition.planrecommendationengine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;

public class LoadingMobilePage extends UhcDriver {

	public LoadingMobilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	String page = "Loading";

	@FindBy(css = "#loadingText")
	private WebElement loadingText;

	@FindBy(css = ".loading-container .container>div>div>div:nth-of-type(1)>img")
	private WebElement loadingDesktopImage;

	@FindBy(css = ".loading-container .container>div>div>div:nth-of-type(2)>img")
	private WebElement loadingLoaderImage;

	// Loading Page Element Verification Method
	public void loadingresultspage() {
		System.out.println("Validating Loading Page: ");
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		validate(loadingText, 30);
		Assert.assertTrue(loadingText.getText().contains(""));
		validate(loadingDesktopImage);
		validate(loadingLoaderImage);
	}

}
