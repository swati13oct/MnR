package pages.regression.profileandpreferences;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class CommunicationPreferencePage extends UhcDriver {


	@FindBy(xpath = ".//*[@class='page-header']//a[contains(text(),'Profile & Preferences')]")
	private WebElement profAndPrefLink;


	public CommunicationPreferencePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//openAndValidate();
	}
	
	public ProfileandPreferencesPage clickProfAndPrefLink(){
		profAndPrefLink.click();
		if(driver.getTitle().equalsIgnoreCase("Profile"))
			return new ProfileandPreferencesPage(driver);
		return null;
	}

	@Override
	public void openAndValidate() {
		validate(profAndPrefLink);
		

	}
	
	/**
	 * Below method will validate plan name: 'uhcMedicareCompleteChoicePPO'
	 * Added as part of commandos team
	 * @return
	 */

}
