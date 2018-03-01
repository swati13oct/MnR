/**
 * 
 */
package pages.member.ulayer;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

/**
 * @author pperugu
 *
 */
public class ClaimDetailsPage {
	
	@FindBy(id ="searchRange")
	private WebElement searchRange;
	
	@FindBy(id ="searchbutton")
	private WebElement searchbutton;

	@FindBy(id ="medicaldetailsinner")
	private WebElement medicalClaimDetailsSection;
	
	@FindBy(id ="drugclaimdetail")
	private WebElement servicesChargesSection;
	
	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	
	private WebDriver driver;
	
	public ClaimDetailsPage(WebDriver driver){
	       this.driver=driver;
	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }

	public ClaimDetailsPage searchClaims(Map<String, String> timeAttributesMap) {
		
		String claimPeriod = timeAttributesMap.get("Claim Period");
		searchRange.click();
		searchRange.sendKeys(claimPeriod);
		CommonUtility.checkPageIsReady(driver);
		searchbutton.click();
		CommonUtility.checkPageIsReady(driver);
		
		if(driver.getTitle().equalsIgnoreCase("Claims"))
		{
		       return new ClaimDetailsPage(driver);
		}
		return null;
	}

	public String getMedicalClaimsDetails() {
		return medicalClaimDetailsSection.getText();
	}

	public String getServicesChargesContent() {
		return servicesChargesSection.getText();
	}
	
	public void logOut() {
		logOut.click();

	}


}
