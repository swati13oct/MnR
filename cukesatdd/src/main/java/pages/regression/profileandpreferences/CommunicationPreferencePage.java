package pages.regression.profileandpreferences;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class CommunicationPreferencePage extends UhcDriver {


	@FindBy(xpath = ".//*[@class='page-header']//a[contains(text(),'Profile & Preferences')]")
	private WebElement profAndPrefLink;
	
	@FindBy(id= "save-prefs-btn-FEDERAL-INDIVIDUAL")
	private WebElement savePrefButton;


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

	public boolean validatePage() {
		// TODO Auto-generated method stub
		if(validateNew(savePrefButton)&&validateNew(profAndPrefLink))
			return true;
		else 
			return false;
	}
	
	/**
	 * Below method will validate plan name: 'uhcMedicareCompleteChoicePPO'
	 * Added as part of commandos team
	 * @return
	 */

}
