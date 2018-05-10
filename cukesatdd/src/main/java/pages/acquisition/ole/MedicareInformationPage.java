/**
 * 
 */
package pages.acquisition.ole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class MedicareInformationPage extends UhcDriver{
	
	//OLE Common Elements

	@FindBy(className = "logo")
	private WebElement SiteLogo;
	
	@FindBy(className = "cta-button next-button")
	private WebElement NextBtn;
	
	@FindBy(className = "cancel-button modal-link")
	private WebElement CancelEnrollmentLink;

	
	@FindBy(className = "only-insurance-info")
	private WebElement MedicalInfoPageHeader;
	
	//Select Medicare Card Type - A 0r B
	
	@FindBy(xpath = "//*[@id='card-type-before']/following-sibling::label")
	private WebElement SelectCardA;
	
	@FindBy(xpath = "//*[@id='card-type-after']/following-sibling::label")
	private WebElement SelectCardB;
	
	
	//Medicare Information fields
	@FindBy(id="First")
	private WebElement firstNameField;
	
	@FindBy(id = "Middle")
	private WebElement middleInitialField;
	
	@FindBy(id = "Last")
	private WebElement lastNameField;
	
	@FindBy(id = "claimNumber")
	private WebElement claimNumberField;
	
	@FindBy(id = "partAdate")
	private WebElement partAStartDateField;
	
	@FindBy(id = "partBdate")
	private WebElement partBStartDateField;
	
	public MedicareInformationPage(WebDriver driver) {
		super(driver);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		
	}



}