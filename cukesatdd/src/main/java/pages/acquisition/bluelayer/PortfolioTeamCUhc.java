package pages.acquisition.bluelayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;

public class PortfolioTeamCUhc extends UhcDriver {

	@FindBy(id = "cta-zipcode")
	private WebElement zipCodeField;

	private static String PAGE_URL = MRConstants.TeamC_UHC_VPP_URL;

	public PortfolioTeamCUhc(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		
	}

	public ResponsivePlanSummaryUhc searchPlans(String zipcode, String County) throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(2000);
		sendkeys(zipCodeField, zipcode);
		zipCodeField.sendKeys(Keys.ENTER);
		// remove thread once page is stable
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * List<WebElement> countyActuals = driver.findElements(By.xpath(
		 * "//a[@class='ng-binding ng-pristine ng-valid']"));
		 * System.out.println(countyActuals.size());
		 * 
		 * for(int i=0; i<=countyActuals.size()-1;i++){
		 * System.out.println(CountyName);
		 * if(countyActuals.get(i).getText().equals(CountyName)){
		 * System.out.println(CountyName);
		 * System.out.println(countyActuals.get(i).getText());
		 * countyActuals.get(i).click(); break; } }
		 */
		if (driver.getTitle().contains(PageTitleConstants.BLAYER_OUR_MEDICARE_PLAN_TYPES)) {
			return new ResponsivePlanSummaryUhc(driver);
		}
		return null;

	}

}
