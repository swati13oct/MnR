package pages.acquisition.uhcretiree;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;


/**
 * @author eb
 *
 */

public class AcquisitionHomePage extends UhcDriver { 

	@Override
	public void openAndValidate() {

		start(UHCRETIREE_ACQISITION_PAGE_URL);
		
		

		validate(prescriptionsLink);
	}

	@FindBy(linkText = "Look up prescription drugs")
	private WebElement prescriptionsLink;	
	

	@FindBy(xpath= ".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[2]/div/div/div/p[2]/a")
	private WebElement lookupproviderLink;
	
	@FindBy(id = "new_form_GroupSelector")
	private WebElement alcatelLucentSelect;	

	private static String UHCRETIREE_ACQISITION_PAGE_URL = MRConstants.UHCRETIREE_URL;
	
	private static String UHCRETIREE_SITE_MAP_URL =  MRConstants.UHCRETIREE_SITE_MAP_URL;

	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public SelectFormularyPage prescriptionsDrugLink() {
		validate(prescriptionsLink);
		prescriptionsLink.click();
		if (getTitle().equalsIgnoreCase(
						"UnitedHealthcare Group Retiree – Search for a Drug")) {
			return new SelectFormularyPage(driver);
		}
		return null;
	}

	public Rallytool_Page lookupproviderclick() {
		validate(lookupproviderLink);
		lookupproviderLink.click();
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase(
						"Find Care")) {
			return new Rallytool_Page(driver);
		}
		
		// TODO Auto-generated method stub
		return null;
	} 
	
	public AlcatelLucentHomePage selectAlcatelLucent_dropdown() {
		validate(alcatelLucentSelect);
		Select dropdown = new Select(alcatelLucentSelect);
		dropdown.selectByIndex(1);
		if(getTitle().equalsIgnoreCase("Alcatel-Lucent Group Retiree - Home")){
			return new AlcatelLucentHomePage(driver);
		}
			
		return null;
	} 

}