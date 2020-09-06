/**
 * 
 */
package pages.mobile.acquisition.ulayer;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * NOTE: deprecating this one, use the ones in cukesatdd/src/main/java/pages/acquisition/pharmacyLocator/
 */

/**
 * @author pagarwa5
 *
 */
public class Deprecated_PharmacyResultPageMobile extends UhcDriver{
	
	
	@FindBy(xpath = "//h1")
    private WebElement pharmacySearchResultsHeading;
	
	public JSONObject pharmacyResultJson;
	
	@FindBy(xpath = "//div[@class='pharmacymid']/p")
	private WebElement pharmacyTypesicondescription;

	@FindBy(xpath = "//div[@class='Pharmacyresults']/table[@class='searchResults']/thead/tr/th[@class='colPhar2']/div/span")
	private WebElement servicesTooltip;

	@FindBy(xpath = "//div[@class='tooltipinner']/ul/li")
	private List<WebElement> tooltipDetails;
	
	@FindBy(xpath = "//div[@class='Pharmacyresults']/table[@class='searchResults']/tbody/tr/td[3]/div/ul/li[2]/a")
	private WebElement viewMaplink;
	
	@FindBy(xpath = "//div[@class='Pharmacyresults']/table[@class='searchResults']/tbody/tr/td/ul/li")
	private List<WebElement> pharmacyDetails;

	@FindBy(xpath = "//div[@class='mapContainer']/div/div/div/div/div[4]/div[4]/div/div[2]/div/div/p")
	private List<WebElement> viewMapresult;
	
	@FindBy(xpath = "//a[@id='find_searchagainbtn']")
	private WebElement searchAgainButton;
	
	public Deprecated_PharmacyResultPageMobile(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	   }

	@Override
	public void openAndValidate() {

		Assert.assertTrue(pharmacySearchResultsHeading.isDisplayed());
	}
	public boolean validatePharmacyResultpage(JSONObject jsonObject, String zipcode, String planName){
		boolean flag = true;
		try {
			if(planName.contains("PDP")){
				if(!jsonObject.get("preferredMailRightRailWidget").toString().equals("Preferred Mail Service Pharmacy\nGet savings and convenience"
						+ " delivered right to your mailbox when you use home delivery through OptumRX, your plan's preffered "
						+ "mail service pharmacy. You could pay less for the same medications.\nLearn more about the OptumRx "
						+ "Preferred Mail Service Pharmacy"))
					flag = false;

				if(!jsonObject.get("contactUsRightRailWidget").toString().equals("Contact OptumRx\nOptumRx Preferred Mail Service Pharmacy\nPO Box "
						+ "2975\nShawnee Mission, KS\n66201-1375\nCall toll-free: 1-877-266-4832,\n24 hours a day, 7 days a week.\nTTY users, "
						+ "call 711.\n "))
					flag = false;
				
				if(!(pharmacyTypesicondescription.getText().split("\n")[0].contains("Preferred Retail Pharmacy") && 
						pharmacyTypesicondescription.getText().split("\n")[1].contains("Standard Network Pharmacy")))
					flag = false;
			}else{
		
					if(!jsonObject.get("preferredMailRightRailWidget").toString().equals("Preferred Mail Service Pharmacy\nGet savings and "
						+ "convenience delivered right to your mailbox when you use home delivery through OptumRX, your plan's preffered "
						+ "mail service pharmacy. You could pay less for the same medications.\nLearn more about the OptumRx Preferred "
						+ "Mail Service Pharmacy"))
					flag = false;

				if(!jsonObject.get("contactUsRightRailWidget").toString().equals("Contact OptumRx\nOptumRx Preferred Mail Service"
						+ " Pharmacy\nPO Box 2975\nShawnee Mission, KS\n66201-1375\nCall toll-free: 1-877-266-4832,\n24 hours a day, 7"
						+ " days a week.\nTTY users, call 711.\n "))
					flag = false;
				
				if(!(pharmacyTypesicondescription.getText().split("\n")[0].contains("Pharmacy SaverTM Pharmacy") && 
						pharmacyTypesicondescription.getText().split("\n")[1].contains("Standard Network Pharmacy")))
					flag = false;
			}

			if(!jsonObject.get("pharmacyTitleText").toString().equals("Pharmacies close to "+zipcode+" for "+planName))
				flag = false;

			if(!jsonObject.get("pharmacyNameheader").toString().contains("Pharmacy name"))
				flag = false;

			if(!jsonObject.get("servicesHeader").toString().contains("Services"))
				flag = false;

			if(!jsonObject.get("distnaceHeader").toString().contains("Distance"))
				flag = false;

			viewMaplink.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i< viewMapresult.size(); i++){
				System.out.println(viewMapresult.get(i).getText());
				System.out.println(pharmacyDetails.get(i).getText());
				if(!(viewMapresult.get(i).getText().replace("-", "").equals(pharmacyDetails.get(i).getText().replace("-", ""))))
					flag = false;
			}
			
			servicesTooltip.click();
			String expectedTooltip = "";
			if(planName.contains("PDP"))
				expectedTooltip = "Preferred Retail Pharmacy – Preferred retail pharmacies may help you save money on your prescription co-pays. "
						+ "UnitedHealthcare has worked with many retail pharmacies to help you get the savings you've been looking for.";
			else
				expectedTooltip = "Pharmacy Saver™ Program - Pharmacy Saver is a cost savings prescription drug program available to our plan"
						+ " members. UnitedHealthcare has worked with many of our network pharmacies to offer even"
						+ " lower prices on many common prescription drugs.";

			expectedTooltip =expectedTooltip + "Standard Network Pharmacy - A pharmacy where you get the prescription "
					+ "drug benefits provided by your plan.Open 24 hours - This store is open to serve your pharmacy needs 24 hours a day, 7 days a "
					+ "week.Indian/Tribal/Urban (I/T/U) - This location is an Indian health service, Tribal or Urban Indian health program pharmacy."
					+ "Home Infusion and Specialty - Medication therapies and services used to treat complex health conditions can be purchased at this "
					+ "location.Long-term care - Products and services for long-term care facilities are available at this location.Standard"
					+ " Network Pharmacy (90-day) - You can fill a 90-day supply of prescription drugs at this retail pharmacy.Mail Order "
					+ "Pharmacy - You can have a 90-day supply of medications you take regularly shipped directly to your home through a mail "
					+ "service pharmacy.";
			for(int i = 0;i <tooltipDetails.size();i++){
				if(!tooltipDetails.get(i).getText().isEmpty()){
					if(!(expectedTooltip.contains(tooltipDetails.get(i).getText()))){
						System.out.println(tooltipDetails.get(i).getText());
						flag=false;
					}
				}				
			}
			System.out.println(flag);
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public Deprecated_PharmacySearchPageMobile navigateTopharmacySearch(){

		searchAgainButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase(
				PageTitleConstantsMobile.BLAYER_FIND_A_PHARMACY_AARP_MEDICARE_PLANS_FROM_UNITEDHEALTHCARE)) {
			return new Deprecated_PharmacySearchPageMobile(driver);
		}
		return null;
		
	}

}
