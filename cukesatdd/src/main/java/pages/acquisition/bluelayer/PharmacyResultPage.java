/**
 * 
 */
package pages.acquisition.bluelayer;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class PharmacyResultPage extends UhcDriver{

	@FindBy(id = "currentRowObject")
	private WebElement pharmacyResults;

	@FindBy(id ="disclosure_link")
	private WebElement logOut;

	public JSONObject pharmacyResultJson;

	private PageData pharmacyResult;

	@FindBy(xpath = "//div[@class='pub_mid']/p")
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
	
	public PharmacyResultPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PHARMACY_RESULT_PAGE_DATA;
		pharmacyResult = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : pharmacyResult.getExpectedData().keySet()) {
			System.out.println(key);
			List<WebElement> elements = findElements(pharmacyResult
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				validate(elements.get(0));
				try {
					jsonObject.put(key, elements.get(0).getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					validate(element);
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put(pharmacyResult.getExpectedData()
								.get(key).getElementName(), element.getText());
						jsonArray.put(jsonObjectForArray);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		pharmacyResultJson = jsonObject;
	}

	public boolean validatePharmacyResultpage(JSONObject jsonObject, String zipcode, String planName){
		boolean flag = true;
		try {
			if(planName.contains("PDP")){
				if(!jsonObject.get("pharmacySaverRightRailWidget").toString().equals("Preferred Retail Pharmacy Network\nThe Preferred Retail "
						+ "Pharmacy Network may help you save money on your prescription co-pays. UnitedHealthcare has worked with many "
						+ "retail pharmacies to help you get the savings you've been looking for. You could save 25% or more on co-pays when "
						+ "you fill your prescriptions at a preferred retail pharmacy.1\n1Savings of 25% or more apply to Tier 1 and Tier 2 "
						+ "co-pays on the AARP MedicareRx Preferred (PDP) and AARP MedicareRx Saver Plus (PDP) plans at a preferred retail "
						+ "pharmacy compared with the co-pays of standard pharmacies within the network .\nEstimate your drug costs at a "
						+ "preferred retail pharmacy"))
					flag = false;
				
				if(!jsonObject.get("preferredMailRightRailWidget").toString().equals("Preferred Mail Service Pharmacy\nGet savings and convenience "
						+ "delivered right to your mailbox when you use home delivery through OptumRx, your plan's preferred mail service pharmacy. "
						+ "You could pay less for the same medications.\nLearn more about the OptumRx Preferred Mail Service Pharmacy"))
					flag = false;

				if(!jsonObject.get("contactUsRightRailWidget").toString().equals("Preferred Mail Service Pharmacy\nGet savings and convenience "
						+ "delivered right to your mailbox when you use home delivery through OptumRx, your plan's preferred mail service pharmacy. "
						+ "You could pay less for the same medications.\nLearn more about the OptumRx Preferred Mail Service Pharmacy"))
					flag = false;
				
				if(!(pharmacyTypesicondescription.getText().split("\n")[0].contains("Preferred Retail Pharmacy") && 
						pharmacyTypesicondescription.getText().split("\n")[1].contains("Standard Network Pharmacy")))
					flag = false;
			}else{
				if(!jsonObject.get("pharmacySaverRightRailWidget").toString().equals("Pharmacy SaverTM offers prescriptions as low as $1.501."
						+ "\nPharmacy SaverTM is a cost savings prescription drug program available to you as a plan member. UnitedHealthcare® "
						+ "has worked with many of our network pharmacies to offer even lower prices on many common prescription drugs. "
						+ "You may be able to pay less than your plan co-pay for your prescription drugs with the Pharmacy Saver program. "
						+ "Simply use one of the participating pharmacies and show your member ID card.\nLook up qualifying drugs, prices and "
						+ "participating pharmacies\n1Drugs and prices may vary between pharmacies and are subject to change during the plan year. "
						+ "Prices are based on quantity filled at the pharmacy. Quantities may be limited by pharmacy based on their dispensing policy or "
						+ "by the plan based on Quantity Limit requirements; if prescription is in excess of a limit, co-pay amounts may be higher."))
					flag = false;
				
				if(!jsonObject.get("preferredMailRightRailWidget").toString().equals("Preferred Mail Service Pharmacy\nGet savings and "
						+ "convenience delivered right to your mailbox when you use home delivery through OptumRx, your plan's preferred mail service pharmacy."
						+ " You could pay less for the same medications.\nLearn more about the OptumRx Preferred Mail Service Pharmacy"))
					flag = false;

				if(!jsonObject.get("contactUsRightRailWidget").toString().equals("Contact OptumRx\nOptumRx Preferred Mail Service Pharmacy\nPO Box 2975\n"
						+ "Shawnee Mission, KS 66201-1375\nCall toll-free: 1-877-266-4832, 24 hours a day, 7 days a week. TTY users, call: 711."))
					flag = false;
				
				if(!(pharmacyTypesicondescription.getText().split("\n")[0].contains("Pharmacy SaverTM Pharmacy") && 
						pharmacyTypesicondescription.getText().split("\n")[1].contains("Standard Network Pharmacy")))
					flag = false;
			}

			if(!jsonObject.get("pharmacyTitleText").toString().equals("Pharmacies close to "+zipcode+" for "+planName))
				flag = false;

			if(!jsonObject.get("pharmacyNameheader").toString().equals("Pharmacy name"))
				flag = false;

			if(!jsonObject.get("servicesHeader").toString().contains("Services"))
				flag = false;

			if(!jsonObject.get("distnaceHeader").toString().equals("Distance"))
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
	
	public PharmacySearchPage navigateTopharmacySearch(){

		searchAgainButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getTitle().equalsIgnoreCase(
				"Locate a Pharmacy | UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
		}
		return null;
		
	}

}
