/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class RequestAgentAppointmentPage extends UhcDriver{
	
	@FindBy(id = "firstNameTxt")
	private WebElement firstName;

	@FindBy(id = "lastNameTxt")
	private WebElement lastName;

	@FindBy(id = "postcodeTxt")
	private WebElement zipCodeInput;

	//@FindBy(xpath = "//button//*[contains(text(),'STARTED')]")
	@FindBy(xpath = "//span[contains(text(),'Get Started')]")
	private WebElement getStartedBtn;

	@FindBy(xpath = "//button[contains(@class,'form-control')]//*[contains(text(),'SEARCH')]")
	private WebElement searchBtn;

	@FindBy(id = "selectedState")
	private WebElement state;
	
	@FindBy(name = "reppage")
	private WebElement viewRepresentativePage;

	//@FindBy(xpath = "(//div[@id='searchResultDiv'][contains(@style,'display: block;')]//*[contains(@class,'agentname')])[1]")
	@FindBy(xpath="//div[@id='targetContainer']//div[4]/div[1]/div[1]/h4[1]")
	private WebElement firstAgentName;
	

	
	
	public RequestAgentAppointmentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		//CommonUtility.waitForPageLoadNew(driver, firstName, 60);
		//validateNew(lastName);
		//validateNew(state);
		validate(zipCodeInput);
		validateNew(getStartedBtn);
		
	}
	
	public boolean submitAgentAppointmentByZip(Map<String, String> personalDetails) {
		sendkeys(zipCodeInput, personalDetails.get("Zipcode"));
		getStartedBtn.click();
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, firstAgentName, 60);
		if (firstAgentName.isDisplayed()) {
			validateNew(viewRepresentativePage);
			return true;
		}

		return false;
	}
	
	public boolean submitAgentAppointment(Map<String, String> personalDetails) {
		if(personalDetails.get("Zipcode") == "" || personalDetails.get("Zipcode") == null){
		sendkeys(firstName, personalDetails.get("First Name"));
		sendkeys(lastName, personalDetails.get("Last Name"));
		selectFromDropDownByText(driver, state, personalDetails.get("State"));
		searchBtn.click();
		}
		else{
			sendkeys(zipCodeInput, personalDetails.get("Zipcode"));
			getStartedBtn.click();
		}
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, firstAgentName, 60);
		if (firstAgentName.isDisplayed()) {
			validateNew(viewRepresentativePage);
			return true;
		}

		return false;
	}
	

}
