/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import pages.acquisition.ulayer.PageTitleConstants;

/**
 * @author pperugu
 *
 */
public class SearchResultsPage {
	
	

	@FindBy(linkText = PageTitleConstants.BLAYER_MEDICARE_PLANS_FOR_DIFFERENT_NEEDS)                          
	private WebElement umsPageLinkGoogle;
			
	@FindBy(xpath = "//div[@class='dd algo qrd0s68 fst Sr']/div/h3/a")                          
	private WebElement umsPageLinkYahoo;
	
//	@FindBy(id = "//a[@h='ID=SERP,5134.1']")
	@FindBy(linkText = PageTitleConstants.BLAYER_MEDICARE_PLANS_FOR_DIFFERENT_NEEDS)        
	private WebElement umsPageLinkBing;
	
	
	private WebDriver driver;
	
	
	 public SearchResultsPage(WebDriver driver){
	       this.driver=driver;
	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }


	public AcquisitionHomePage selectUmsHomePage(String searchEngine) {
		if(searchEngine.contains("google"))
		{
			umsPageLinkGoogle.click();
		}
		if(searchEngine.contains("yahoo"))
		{
			umsPageLinkYahoo.click();
		}
		if(searchEngine.contains("bing"))
		{
			umsPageLinkBing.click();
		}
		
		CommonUtility.checkPageIsReady(driver);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLANS_FOR_DIFFERENT_NEEDS))
		{
		       return new AcquisitionHomePage(driver);
		}
		return null;
		
	}

}
