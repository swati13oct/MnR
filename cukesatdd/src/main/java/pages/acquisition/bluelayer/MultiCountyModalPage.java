package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class MultiCountyModalPage extends UhcDriver {

	@FindBy(id = "zipLookup")
	private WebElement lookupZipcodeLink;

	@FindBy(className = "zipcode_text")
	private WebElement zipCodeField;

	@FindBy(id = "goBtn")
	private WebElement goButton;

	private static String PAGE_URL = MRConstants.UHC_OUR_PLANS_URL;

	public MultiCountyModalPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	@Override
	public void openAndValidate() {
		validate(countyModal);
		validate(MultiCOunty_CancelBtn);
	}


	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;

	@FindBy(id = "multiCountyCancelBtn")
	private WebElement MultiCOunty_CancelBtn;

	@FindBy(id = "zipcode")
	private WebElement ZipCodeTxtBx;

	public boolean validateMultiCounty_CancelButton() {
		validate(countyModal);
		boolean ValidationFlag = true;
		if(validate(MultiCOunty_CancelBtn)){
			MultiCOunty_CancelBtn.click();
			if(currentUrl().contains("health-plans.html#/zipcode") && ZipCodeTxtBx.getText().isEmpty()){
				ValidationFlag = (!ValidationFlag)?false:true;
			}else{
				System.out.println("Zip code entry page is not displayed with Zip code field blank");
				ValidationFlag = false;
			}
		}
		else{
			System.out.print("Cancel Button is not dispalyed in the Multy COunty Pop-up");
			ValidationFlag = false;
		}
		return ValidationFlag;
	}



}
