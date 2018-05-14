/**
 * 
 */
package pages.acquisition.ole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class PersonalInformationPage extends UhcDriver{
		
	
	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	//Progress Bar Elements 
	@FindBy(xpath = "//*[@class = 'progress-legend']")
	private WebElement ProgressBarText;

	@FindBy(xpath = "//*[@class = 'form-current-progress']")
	private WebElement ProgressBarPercentageIndicator;

	//Page Navigation Elements
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;
	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "cancel-enrollment")
	private WebElement CancelEnrollmentLink;

	//Personal Page header
	@FindBy(xpath = "//*[@class = 'ole-form-header']")
	private WebElement PersonalInfoPageHeader;

	public PersonalInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		
	}


}