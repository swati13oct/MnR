/**
 * 
 */
package pages.member.bluelayer;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

/**
 * @author pjaising
 *
 */
public class TerminatedHomePage{
	

	

	@FindBy(id = "memberId")
	private WebElement memberId;
	
	@FindBy(linkText = "addaplan")
	private WebElement addaplanlink;
	
	@FindBy(id = "terminatedDate")
	private WebElement terminatedDate;
	
	@FindBy(linkText = "Search claim history")
	private WebElement searchClaimsHistory;
	
	@FindBy(id ="disclosure_link")
	private WebElement logOut;

	private WebDriver driver;
	
	public TerminatedHomePage(WebDriver driver){
	       this.driver=driver;
	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }
	
	public void logOut() {
		logOut.click();
		
	}

	public ClaimSummaryPage navigateToClaimsSummary() {

		searchClaimsHistory.click();
    	CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | Claims")) {
			return new ClaimSummaryPage(driver);
		}
		return null;
	}
	
	public boolean validateaddaplanlink() {
		
	boolean presentLink =false;
		
		try {
			if(addaplanlink.isDisplayed()){
				
				presentLink = true;
				return presentLink;
			}			  
			 
		} catch (NoSuchElementException e) {
			presentLink = false;
		}
		return presentLink;
		// TODO Auto-generated method stub
		
	}



}
