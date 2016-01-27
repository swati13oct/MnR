/**
 * 
 */
package pages.acquisition.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ulayer.AcquisitionHomePage;
import acceptancetests.atdd.util.CommonUtility;

/**
 * @author pperugu
 *
 */
public class SearchResultsPage {
	
	
	@FindBy(xpath = "//div[@id='ires']/ol/div/div/div/h3/a")                          
	private WebElement aarpPageLinkGoogle;
			
			
	@FindBy(xpath = "//div[@class='dd algo qrd0s68 fst Sr']/div/h3/a")                          
	private WebElement aarpPageLinkYahoo;
	
//	@FindBy(id = "//a[@h='ID=SERP,5134.1']")
	@FindBy(linkText = "Medicare Plans | AARP® Medicare Plans from UnitedHealthcare…")        
	private WebElement aarpPageLinkBing;
	
	
	private WebDriver driver;
	
	
	 public SearchResultsPage(WebDriver driver){
	       this.driver=driver;
	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }


	public AcquisitionHomePage selectAarpHomePage(String searchEngine) {
		if(searchEngine.contains("google"))
		{
			aarpPageLinkGoogle.click();
			CommonUtility.checkPageIsReady(driver);
		}
		if(searchEngine.contains("yahoo"))
		{
			aarpPageLinkYahoo.click();
		}
		if(searchEngine.contains("bing"))
		{
			aarpPageLinkBing.click();
		}
		
		CommonUtility.checkPageIsReady(driver);
		if(driver.getTitle().equalsIgnoreCase("Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®"))
		{
		       return new AcquisitionHomePage(driver);
		}
		return null;
		
	}

}
