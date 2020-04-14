package pages.acquisition.shopperprofile;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class ProfileSearch extends UhcDriver {
	
	@FindBy(id = "visitorsEmail")
	private WebElement visitorEmail;
	
	@FindBy(id = "authFirstName")
	private WebElement firstName;
	
	@FindBy(id = "authLastName")
	private WebElement lastName;
	
	@FindBy(xpath = "//button[text()='Search Shopper']")
	private WebElement btnSearchShopper;
	
	@FindBy(xpath = "//button[contains(text(),'Profile')]")
	private WebElement btnCreateProfile;
	
	@FindAll({@FindBy(xpath = "//table/tbody/tr")})
	private List<WebElement> searchResults;
	
	@FindBy(xpath="//table//button")
	private WebElement btnCloakIn;

	public static final String DELETE_PROFILE_URL = "http://digital-checkout-team-e.ocp-elr-core-nonprod.optum.com/digital-checkout/guest/profile";
	
	
	public ProfileSearch(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, firstName, 45);
		CommonUtility.waitForPageLoadNew(driver, btnSearchShopper, 45);
	}
	
	/**
	 * Validate the search results 
	 */
	public void validateSearchProfileResults() {
		CommonUtility.waitForPageLoadNew(driver, visitorEmail, 45);
		waitforElement(searchResults.get(0));
		Assert.assertTrue(searchResults.size()>0);
	}

	/**
	 * Search profile by email
	 * @param email
	 */
	public void searchProfileByEmail(String email) {
		
		CommonUtility.waitForPageLoadNew(driver, visitorEmail, 45);
		sendkeys(visitorEmail, email);
		btnSearchShopper.click();
		validateSearchProfileResults();
	}
	
	/**
	 * Search Profile by First Name and Last Name
	 * @param fname
	 * @param lname
	 */
	public void searchProfileByName(String fname,String lname) {
		
		CommonUtility.waitForPageLoadNew(driver, firstName, 45);
		sendkeys(firstName, fname);
		sendkeys(lastName, lname);
		btnSearchShopper.click();
		validateSearchProfileResults();
	}
	
	/**
	 * Cloak In the Searched Profile
	 * @return
	 */
	public VPPPlanSummaryPage doCloakIn() {
		try {
			CommonUtility.waitForPageLoadNew(driver, searchResults.get(0), 45);
			btnCloakIn.click();
			Thread.sleep(5000);
			switchToNewTab();
			Thread.sleep(10000);
			if(driver.getCurrentUrl().contains("health-plans.html#/plan-summary")) {
				return new VPPPlanSummaryPage(driver);
			}else {
				System.out.println("Plan Summary page is not loaded");
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	public void deleteAProfile(String email, String dob, String MBI) {
		try {
			
			HttpClient httpClient = HttpClients.createDefault();
			
			HttpDelete req = new HttpDelete(DELETE_PROFILE_URL);
			
			req.setHeader("Accept", "application/json");
			req.setHeader("Content-type", "application/json");
			String inputJson = "{\n" +
					"  \"email\": \""+email+"\",\n" +
					"  \"dob\": \""+dob+"\",\n" +
					"  \"mbi\": \""+MBI+"\"\n" +
					"}";
			 /*StringEntity input = new StringEntity(PARAMS, ContentType.APPLICATION_JSON);
		        httpDelete.addHeader("header", header);
		        httpDelete.setEntity(input); */ 
			
			//req.setEntity(stringEntity);
			
			System.out.println(inputJson);
			
			System.out.println("####Response Code = "+httpClient.execute(req).getStatusLine().getStatusCode());
			
			
			/*URL url = new URL(DELETE_PROFILE_URL);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestProperty(
			                "Content-Type", "application/json");
			httpCon.setRequestMethod("DELETE");
			OutputStreamWriter out = new OutputStreamWriter(
			                httpCon.getOutputStream());
			ObjectMapper objectMapper = new ObjectMapper();
			out.write(objectMapper.writeValueAsString(stringEntity));
			out.close();
			httpCon.connect();*/
			
		} catch (Exception e) {
			
		}
		
	}
	
	
	
	
}
