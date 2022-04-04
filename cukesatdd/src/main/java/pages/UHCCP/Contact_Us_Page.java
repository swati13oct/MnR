package pages.UHCCP;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import atdd.framework.UhcDriver;
import atdd.framework.Assertion;
import atdd.framework.MRScenario;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;

public class Contact_Us_Page extends UhcDriver {

	public Contact_Us_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
//		openAndValidate();
	}

	@FindBy(xpath = "//h1[contains(@class,'title')]")
	public WebElement PageHeader;

	@FindBy(xpath = "//h3[contains(text(),'Meet With an Agent')]/following-sibling::div//a")
	public WebElement agentRequestForm;

	@FindBy(id = "firstNameField-468900320")
	public WebElement FirstName;

	@FindBy(id = "lastNameField-342218250")
	public WebElement LastName;

	@FindBy(id = "address1Field-489364186")
	public WebElement Address;

	@FindBy(id = "address2Field-517993337")
	public WebElement Address2;

	@FindBy(id = "cityField-1846784020")
	public WebElement City;

	/*
	 * @FindBy(id = "stateField-1894604470") public WebElement State;
	 */

	By state = By.id("stateField-1894604470");

	@FindBy(id = "zipcodeField-84785427")
	public WebElement ZipCode;

	@FindBy(id = "emailField-348337889")
	public WebElement Email;

	@FindBy(id = "phoneNumberField-1468364260")
	public WebElement PhoneNumber;

	@FindBy(xpath = "//h1[text()='Thank You']")
	public WebElement conftext;

	@FindBy(id = "submit-submit-form-2042133236")
	public WebElement btnSubmitRequest;
	
	@Override
	public void openAndValidate() {		
	}

	// Action Methods
	
	public Dual_Landing_Page meetAnAgentForm() throws InterruptedException {
		validateNew(agentRequestForm);
		agentRequestForm.click();
		CommonUtility.checkPageIsReadyNew(driver);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		checkModelPopup(driver,10);
		if (driver.getCurrentUrl().contains("dual-landing")) {
			validateNew(PageHeader);
			Assertion.assertTrue("Dual Landing page is loaded",
					PageHeader.getText().contains("Need help finding a plan"));
			System.out.println("Page Loaded: "+driver.getTitle());
			return new Dual_Landing_Page(driver);
		}
		return null;	
	}
}
