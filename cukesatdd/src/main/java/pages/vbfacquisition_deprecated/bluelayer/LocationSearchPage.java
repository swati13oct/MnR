package pages.vbfacquisition_deprecated.bluelayer;

/*@author pagarwa5*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.ElementData;
import atdd.framework.UhcDriver;

public class LocationSearchPage extends UhcDriver {

	@FindBy(className = "ZIPCodeBox")
	WebElement zipCodeField;

	@FindBy(xpath="//div[@ng-show='zipValid']")
	WebElement errorZIPCodeInvalidText;
	
	@FindBy(xpath="//div[@ng-show='noZip']")
	WebElement errorZIPCodeEmptyText;
	
	@FindBy(xpath="//div[@ng-show='nonExistingZIP']")
	WebElement errorZIPCodeNonExistingText;

	@FindBy(linkText = "Continue")
	WebElement continueButton;

	public LocationSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	public void validateZipcodeSearch(String searachData, WebElement erroMsgElement){
		sendkeys(zipCodeField, searachData);
		continueButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(erroMsgElement);
	}
	public AddDrugPage enterLocation(String zipCode, String county,
			String planYear) {
		validateZipcodeSearch("123a",errorZIPCodeInvalidText);
		validateZipcodeSearch("",errorZIPCodeEmptyText);
		validateZipcodeSearch("33044",errorZIPCodeNonExistingText);
		sendkeys(zipCodeField, zipCode);
		if (null != planYear) {
			ElementData elementData = new ElementData("xpath",
					"//div[@class='marginBottom25']//span[.='" + planYear
					+ "']");
			findElement(elementData).click();
		}
		continueButton.click();
		if (currentUrl().contains("drugSearch")) {
			return new AddDrugPage(driver);
		} else if (currentUrl().contains("enterZipCode")) {
			CountySelectionPage countySelectionPage = new CountySelectionPage(
					driver);
			AddDrugPage addDrugPage = countySelectionPage.selectCounty(county);
			return addDrugPage;
		}

		return null;

	}

	@Override
	public void openAndValidate() {
		boolean zipcodeAndcontinueFieldExistence = false;
		for(int i =0; i<10;i++){
			zipcodeAndcontinueFieldExistence = validate(zipCodeField) && validate(continueButton);
			if (zipcodeAndcontinueFieldExistence){
				break;
			}else{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}