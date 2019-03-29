/**
 * 
 */
package pages.vbfacquisition_deprecated.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import pages.vbfacquisition_deprecated.ulayer.PageTitleConstants;

/**
 * @author pperugu
 *
 */
public class SearchEnginePage {
	
	@FindBy(id = "lst-ib")
	private WebElement googelSearchFeild;
	
	@FindBy(id = "p_13838465-p")
	private WebElement yahooSearchFeild;
	
	@FindBy(id = "search-submit")
	private WebElement yahooSubmitFeild;
	
	@FindBy(id = "sb_form_q")
	private WebElement bingSearchFeild;
	
	@FindBy(id = "sb_form_go")
	private WebElement bingSubmitFeild;
	
	
	
	private WebDriver driver;
	
	
	 public SearchEnginePage(WebDriver driver, String URL){
		 	
	       this.driver=driver;
	       driver.get(URL);
	       driver.manage().window().maximize();
	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }

	public SearchResultsPage searchParameter(String searchParamter,String searchEngine) {
		if(searchEngine.contains("google"))
		{
			googelSearchFeild.click();
			googelSearchFeild.clear();
			googelSearchFeild.sendKeys(searchParamter);
			googelSearchFeild.submit();
			CommonUtility.checkPageIsReady(driver);
			if (driver.getTitle().equalsIgnoreCase(
					PageTitleConstants.BLAYER_UHC_MEDICARE_SOLUTIONS)) {
				return new SearchResultsPage(driver);
			}
			return null;
		}
		
		if(searchEngine.contains("yahoo"))
		{
			yahooSearchFeild.click();
			yahooSearchFeild.clear();
			yahooSearchFeild.sendKeys(searchParamter);
			yahooSubmitFeild.click();
			CommonUtility.checkPageIsReady(driver);
			if (driver.getTitle().equalsIgnoreCase(
					PageTitleConstants.BLAYER_UHC_MEDICARE_SOLUTIONS_YAHOO)) {
				return new SearchResultsPage(driver);
			}
			return null;
		}
		
		if(searchEngine.contains("bing"))
		{
			bingSearchFeild.click();
			bingSearchFeild.clear();
			bingSearchFeild.sendKeys(searchParamter);
			bingSubmitFeild.click();
			CommonUtility.checkPageIsReady(driver);
//			if (driver.getTitle().equalsIgnoreCase(
//					"UHC medicare solutions - Bing")) {
//				return new SearchResultsPage(driver);
//			}
			
			if (driver.getCurrentUrl().contains("q=UHC"))
			{
				return new SearchResultsPage(driver);
			}
			return null;
		}
	
		return null;
	}

}